package com.rating.userservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced //for using the service with name and removing host and port we are using this annotation
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
