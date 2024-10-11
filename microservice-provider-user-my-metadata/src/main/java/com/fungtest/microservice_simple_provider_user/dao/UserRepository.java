package com.fungtest.microservice_simple_provider_user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fungtest.microservice_simple_provider_user.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
}
