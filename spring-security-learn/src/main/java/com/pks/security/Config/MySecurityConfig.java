package com.pks.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/home","/reg").permitAll() - Way of adding multiple URLs
                .antMatchers("public/**").permitAll() // way of adding on one common group
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("xyz").password(this.bCryptPasswordEncoder()
                .encode("xyz")).roles("NORMAL");

        auth.inMemoryAuthentication().withUser("abc").password(this.bCryptPasswordEncoder()
                .encode("abc")).roles("ADMIN");

    }

    /*Role based authentication . If ROLE -> Normal then only READ
   IF ROLE -> Authority then READ
   IF ROLE -> ADMIN then read, write, update

     */

    // Creating a bean for password encoder. Creating a bean of encoder so that it can be used/ injected using autowired
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
