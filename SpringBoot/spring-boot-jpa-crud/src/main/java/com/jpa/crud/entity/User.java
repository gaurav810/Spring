package com.jpa.crud.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message = "Please add user's first name")
	private String firstName;
	
	@NotEmpty(message = "Please add user's last name")
	private String lastName;
	
	@Email(message = "Email Id is not valid.")
	private String emailId;
	
	@Min(value =  18, message = "age should be more than 18.")
	@NotNull(message = "Please provide user's age")
	private int age;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
