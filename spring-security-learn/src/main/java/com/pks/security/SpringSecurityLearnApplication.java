package com.pks.security;

import com.pks.security.Model.User;
import com.pks.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityLearnApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("xyz@gmail.com");
		user.setUserName("normal");
		user.setPassword(this.bCryptPasswordEncoder.encode("normal"));
		user.setRole("ROLE_NORMAL");
		userRepository.save(user);

		User user1 = new User();
		user1.setUserName("admin");
		user1.setEmail("abc@gmail.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("admin"));
		user1.setRole("ROLE_ADMIN");
		userRepository.save(user1);

	}
}
