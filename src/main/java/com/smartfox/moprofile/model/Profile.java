package com.smartfox.moprofile.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
public class Profile extends AbstractDocument {


	private static final long serialVersionUID = 1L;
	
	@Indexed(unique = true)
	private String username;
	@Indexed(unique = true)
	private PersonalDetails personal;
	private WorkDetails work;

	public Profile(String username, PersonalDetails personal, WorkDetails work) {
		super();
		this.personal = personal;
		this.work = work;
		this.setUsername(username);
	}

	public Profile() {
		super();
	}

	public PersonalDetails getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalDetails personalDetails) {
		this.personal = personalDetails;
	}

	public WorkDetails getWork() {
		return work;
	}

	public void setWork(WorkDetails work) {
		this.work = work;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Profile [username=" + username + ", personal=" + personal + ", work=" + work + "]";
	}
	
	

}
