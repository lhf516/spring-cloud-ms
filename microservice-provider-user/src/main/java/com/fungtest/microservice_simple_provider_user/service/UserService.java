package com.fungtest.microservice_simple_provider_user.service;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fungtest.microservice_simple_provider_user.dao.UserRepository;
import com.fungtest.microservice_simple_provider_user.model.UserEntity;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserEntity createUser(UserEntity user) {
    return userRepository.save(user);
  }

  public void populateData() {
    List<UserEntity> usersToPopulate = Arrays.asList(
        new UserEntity("john.doe", "John Doe", 10, new BigDecimal(120.00)),
        new UserEntity("jane.smith", "Jane Smith", 12, new BigDecimal(180.00))

    );

    for (int i = 0; i < usersToPopulate.size(); i++) {
      userRepository.save(usersToPopulate.get(i));
    }
  }
}
