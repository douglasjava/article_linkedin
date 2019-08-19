package com.example.security.demo.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.demo.model.UserPO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal() {
	}

	public UserPrincipal(Long id, String name, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(UserPO user) {
		List<GrantedAuthority> authorities = Arrays.asList(user.getPaper()).stream()
				.map(role -> new SimpleGrantedAuthority(createRole(role.getName()))).collect(Collectors.toList());

		return new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getEmail(), user.getPassword(),
				authorities);
	}

	public static String createRole(String role) {
		return "ROLE_" + role.toUpperCase();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
}
