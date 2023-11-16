package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Configuration
class AppConfig {
  @Bean
  RestTemplate restTemplate(RestTemplateBuilder builder) {
    System.out.println("hello rest template config");
    RestTemplate restTemplate = builder.build();
    return restTemplate;
  }
}