package com.fungtest.microservice_simple_consumer_movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fungtest.microservice_simple_consumer_movie.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/users")
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://localhost:8000/api/v1/users/" + id, User.class);
  }

}
