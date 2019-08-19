package com.example.security.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class UserPO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	@Size(max = 60)
	@Email
	private String email;

	private boolean ativo;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_paper")
	private PaperPO paper;

	public UserPO(String name, String email, String password, boolean ativo) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.ativo = ativo;
	}

}
