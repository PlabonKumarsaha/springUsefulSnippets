package com.pks.security.Config;

import com.pks.security.Model.CustomerDetailService;
import com.pks.security.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailService customerDetailService;

    //basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* Basic Authentication
        http.authorizeRequests()
                //.antMatchers("/home","/reg").permitAll() - Way of adding multiple URLs
                .antMatchers("public/**").permitAll() // way of adding on one common group
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); */

        /* This is role base authentication
        Role based authentication . If ROLE -> Normal then only READ
        IF ROLE -> Authority then READ
        IF ROLE -> ADMIN then read, write, update */

        http
               // .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/home","/reg").permitAll() - Way of adding multiple URLs
                .antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/user/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        // form based authentication
       /* http
                // .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/home","/reg").permitAll() - Way of adding multiple URLs
                .antMatchers("/signIn").permitAll()
                .antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/user/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/user/"); */
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* In memory check
        auth.inMemoryAuthentication().withUser("normal").password(this.bCryptPasswordEncoder()
                .encode("normal")).roles("NORMAL");

        auth.inMemoryAuthentication().withUser("admin").password(this.bCryptPasswordEncoder()
                .encode("admin")).roles("ADMIN");
                */
        auth.userDetailsService(customerDetailService).passwordEncoder( bCryptPasswordEncoder());


    }

    // Creating a bean for password encoder. Creating a bean of encoder so that it can be used/ injected using autowired
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
