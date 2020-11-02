package com.smartfox.moprofile.dto;

import java.time.LocalDate;

public class PersonalDetailsDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String gender;
	private String title;
	private LocalDate dateOfBirth;

	public PersonalDetailsDTO(String firstName, String lastName, String gender, String title, LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.title = title;
		this.dateOfBirth = dateOfBirth;
	}

	public PersonalDetailsDTO() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "PersonalDetailsDTO [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", title=" + title + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
