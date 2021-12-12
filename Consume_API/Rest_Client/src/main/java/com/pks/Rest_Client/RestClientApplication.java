package com.pks.Rest_Client;

import com.pks.Rest_Client.Controller.RestClient;
import com.pks.Rest_Client.Model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
		RestClient restClient = new RestClient();
		restClient.callGetAllUser();

		//get user by id
		restClient.callUserByIdUserId(1);

		//create user
		User user = new User("ME", "Naaamee","MEE@gmail.com");
		restClient.callCreateUser(user);

		//update user
		User update = new User("Bolbona", "Naaamee","MEE@gmail.com");
		restClient.callUpdateUser(update,8);

		//Delete api call
		restClient.callDeleteUser(7);
	}

}
