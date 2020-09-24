package com.smartfox.moprofile.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
public class Profile extends AbstractDocument {


	private static final long serialVersionUID = 1L;
		
	@Indexed(unique = true)
	private PersonalDetails personal;
	private WorkDetails work;

	public Profile(PersonalDetails personal, WorkDetails work) {
		super();
		this.personal = personal;
		this.work = work;
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

	@Override
	public String toString() {
		return "Profile [personal=" + personal + ", work=" + work + "]";
	}

}
