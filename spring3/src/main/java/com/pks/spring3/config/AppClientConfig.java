package com.pks.spring3.config;

import com.pks.spring3.Service.ServiceConsumptionUsingHttpExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppClientConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public ServiceConsumptionUsingHttpExchange postClient(){
        HttpServiceProxyFactory httpServiceProxyFactory=
                HttpServiceProxyFactory.builder(WebClientAdapter
                        .forClient(webClient())).build();
        return httpServiceProxyFactory.createClient(ServiceConsumptionUsingHttpExchange.class);
    }
}
