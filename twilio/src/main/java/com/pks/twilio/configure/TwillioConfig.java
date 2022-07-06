package com.pks.twilio.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwillioConfig {

    private String accountSid;
    private String authToken;
    private String trialNumber;
}
