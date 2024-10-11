package com.fungtest.microservice_simple_provider_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fungtest.microservice_simple_provider_user.service.UserService;

@Configuration
public class AppConfig {
  @Bean
  public String populateData(UserService userService) {
    userService.populateData();
    return "Data populated successfully";
  }
}
