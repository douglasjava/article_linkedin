package com.example.security.demo.model;

public enum RoleName {

	ROLE_USER("user"), ROLE_ADMIN("admin");

	private String descricao;

	RoleName(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
