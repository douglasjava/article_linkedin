package com.example.security.demo.dto;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * UserDTO
 */
@Validated
@Getter
@Setter
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("nome")
	private String nome = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("ativo")
	private Boolean ativo = null;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserDTO {\n");

		sb.append("    id: ").append(toIndentedString(this.id)).append("\n");
		sb.append("    nome: ").append(toIndentedString(this.nome)).append("\n");
		sb.append("    email: ").append(toIndentedString(this.email)).append("\n");
		sb.append("    ativo: ").append(toIndentedString(this.ativo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object object) {
		return object != null ? object.toString().replace("\n", "\n    ") : "null";
	}

}
