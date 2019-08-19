package com.example.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.demo.model.PaperPO;
import com.example.security.demo.model.RoleName;
import com.example.security.demo.model.UserPO;
import com.example.security.demo.repository.Papers;
import com.example.security.demo.repository.Users;

@Service
public class UserService {

	@Autowired
	private Users repository;

	@Autowired
	private Papers repositoryPaper;

	public List<UserPO> getUsers() {
		return repository.findAll();
	}

	public UserPO getUserToUsername(String username) {
		return repository.findByEmail(username)
				.orElseThrow(() -> new RuntimeException("Not found user with username: " + username));
	}

	public void createUser() {

		UserPO usuario = new UserPO();
		usuario.setName("João da Silva");
		usuario.setEmail("joao.silva@teste.com.br");
		usuario.setPassword("$2a$10$E7h3NwmSU5W34s/8oKzkVO8yr9MOo3oiFTdJolD0SJIu3HKfDdUwW");
		usuario.setAtivo(true);
		usuario.setPaper(new PaperPO(RoleName.ROLE_ADMIN.getDescricao()));
		repository.save(usuario);

	}

	public void createPaper() {
		PaperPO paper = new PaperPO(RoleName.ROLE_ADMIN.getDescricao());
		repositoryPaper.save(paper);
	}

}
