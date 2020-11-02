package com.smartfox.moprofile.dto;

public class ProfileDTO extends AbstractDTO {


	private static final long serialVersionUID = 1L;
	private String username;
	private PersonalDetailsDTO personal;
	private WorkDetailsDTO work;

	public ProfileDTO(String username, PersonalDetailsDTO personal, WorkDetailsDTO work) {
		super();
		this.username = username;
		this.personal = personal;
		this.work = work;
	}

	@Override
	public String toString() {
		return "ProfileDTO [username=" + username + ", personal=" + personal + ", work=" + work + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PersonalDetailsDTO getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalDetailsDTO personal) {
		this.personal = personal;
	}

	public WorkDetailsDTO getWork() {
		return work;
	}

	public void setWork(WorkDetailsDTO work) {
		this.work = work;
	};

}
