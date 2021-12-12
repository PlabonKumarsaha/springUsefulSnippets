package com.pks.Rest_Client;

import com.pks.Rest_Client.Controller.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
		RestClient restClient = new RestClient();
		//restClient.callGetAllUser();

		//get user by id
		restClient.callUserByIdUserId(1);
	}

}
