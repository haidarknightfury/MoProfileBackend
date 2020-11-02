package com.smartfox.moprofile.model;

import java.time.LocalDate;

public class PersonalDetails {

	private String firstName;
	private String lastName;
	private String gender;
	private String title;
	private String email;
	private LocalDate dateOfBirth;

	public PersonalDetails() {
		super();
	}


	public PersonalDetails(String firstName, String lastName, String gender, String title, String email,
			LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.title = title;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
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
		return "PersonalDetails [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", title="
				+ title + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
