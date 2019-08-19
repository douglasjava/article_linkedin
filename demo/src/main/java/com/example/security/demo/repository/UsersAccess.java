package com.example.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.demo.model.UserAccess;

@Repository
public interface UsersAccess extends JpaRepository<UserAccess, Long> {

	boolean existsByToken(String token);

}
