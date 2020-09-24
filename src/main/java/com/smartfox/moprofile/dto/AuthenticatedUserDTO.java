package com.smartfox.moprofile.dto;

import java.util.List;

public class AuthenticatedUserDTO extends AbstractDTO {

	private String jwtToken;
	private String username;
	private String email;
	private List<String> roles;
	public AuthenticatedUserDTO(String jwtToken, String username, String email, List<String> roles) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	public AuthenticatedUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
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
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "AuthenticatedUserDTO [jwtToken=" + jwtToken + ", username=" + username + ", email=" + email + ", roles="
				+ roles + "]";
	}
	
	
}
