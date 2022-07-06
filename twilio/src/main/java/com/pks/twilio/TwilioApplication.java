package com.pks.twilio;

import com.pks.twilio.configure.TwillioConfig;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TwilioApplication {


	@Autowired
	private TwillioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}


	public static void main(String[] args) {
		SpringApplication.run(TwilioApplication.class, args);
	}

}
