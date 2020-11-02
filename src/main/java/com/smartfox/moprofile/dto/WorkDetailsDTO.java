package com.smartfox.moprofile.dto;

import java.math.BigInteger;

public class WorkDetailsDTO extends AbstractDTO {


	private static final long serialVersionUID = 1L;
	private String company;
	private String dateOfEmployment;
	private BigInteger salary;

	public WorkDetailsDTO(String company, String dateOfEmployment, BigInteger salary) {
		super();
		this.company = company;
		this.dateOfEmployment = dateOfEmployment;
		this.salary = salary;
	}

	public WorkDetailsDTO() {
		super();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	@Override
	public String toString() {
		return "WorkDetailsDTO [company=" + company + ", dateOfEmployment=" + dateOfEmployment + ", salary=" + salary
				+ "]";
	}

}
