package com.fungtest.microservice_simple_consumer_movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fungtest.microservice_simple_consumer_movie.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/users")
public class MovieController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @Value("${user.userServiceName}")
  private String userServiceName;
  @Value("${user.userServiceUrl}")
  private String userServiceUrl;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
  }

  @GetMapping("/log-user-instance")
  public void logUserInstance() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose(this.userServiceName);
    MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getInstanceId(), serviceInstance.getHost(),
        serviceInstance.getPort());
  }

}
