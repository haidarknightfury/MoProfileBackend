package com.smartfox.moprofile.dto;

import java.util.ArrayList;
import java.util.List;

public class RegisterRequestDTO {

	private String username;
	private String email;
	private String password;
	private List<String> roles = new ArrayList<String>();

	public RegisterRequestDTO(String username, String email, String password, List<String> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public RegisterRequestDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
