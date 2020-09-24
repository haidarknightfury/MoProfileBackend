package com.smartfox.moprofile.model;

import java.math.BigInteger;

public class WorkDetails {

	private String company;
	private String dateOfEmployment;
	private BigInteger salary;
	
	public WorkDetails() {
		super();
	}

	public WorkDetails(String company, String dateOfEmployment, BigInteger salary) {
		super();
		this.company = company;
		this.dateOfEmployment = dateOfEmployment;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "WorkDetails [companyName=" + company + ", dateOfEmployment=" + dateOfEmployment + ", salary="
				+ salary + "]";
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String companyName) {
		this.company = companyName;
	}

	public String getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public BigInteger getSalary() {
		return salary;
	}

	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}


}
