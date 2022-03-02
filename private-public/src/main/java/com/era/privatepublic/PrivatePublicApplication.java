package com.era.privatepublic;

import com.era.privatepublic.key.RSA;
import com.squareup.okhttp.OkHttpClient;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrivatePublicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivatePublicApplication.class, args);
		try{
			RSA rs = new RSA();
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
					.url("http://localhost:8080/getSecretMessage")
					.method("GET",null)
					.build();
			Response response = client.newCall(request).execute();
			String encryptedMessage = response.body().string();
			System.out.println(" RESPOSNE BODY : "+encryptedMessage);
			String decryptedMessage = rs.decrypt(encryptedMessage);
			System.out.println(" decrypted message : "+decryptedMessage);
		}catch (Exception e){

		}

	}

}
