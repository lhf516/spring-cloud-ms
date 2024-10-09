package com.fungtest.microservice_simple_provider_user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fungtest.microservice_simple_provider_user.dao.UserRepository;
import com.fungtest.microservice_simple_provider_user.model.UserEntity;
import com.fungtest.microservice_simple_provider_user.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;

  @GetMapping()
  public List<UserEntity> findAll() {
    List<UserEntity> allUsers = userRepository.findAll();
    return allUsers;
  }

  @GetMapping("/{id}")
  public Optional<UserEntity> findById(@PathVariable Long id) {
    Optional<UserEntity> oneUser = userRepository.findById(id);
    return oneUser;
  }

  @PostMapping
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userService.createUser(user);
  }
}
