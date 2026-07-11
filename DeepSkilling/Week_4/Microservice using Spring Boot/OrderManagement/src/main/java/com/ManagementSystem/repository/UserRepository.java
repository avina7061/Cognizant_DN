package com.ManagementSystem.repository;

import com.ManagementSystem.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}