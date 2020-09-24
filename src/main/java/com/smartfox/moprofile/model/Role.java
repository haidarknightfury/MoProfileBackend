package com.smartfox.moprofile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {

	@Id
	private String id;
	
	private RoleEnum name;

	public Role(RoleEnum name) {
		this.name = name;
	}

	public Role() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + "]";
	}	

	
}
