package com.example.security.demo.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.security.demo.model.UserPO;
import com.example.security.demo.repository.Users;
import com.example.security.demo.security.UserPrincipal;
import com.example.security.demo.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private Users repository;

	@Autowired
	private UserService service;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		service.createUser();

		UserPO user = repository.findByNameOrEmail(username, username).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email : " + username));

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		return UserPrincipal.create(repository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id)));
	}

}
