package com.example.devtestapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty("employee_name")
	private String employee_name;

	@JsonProperty("employee_salary")
	private double employee_salary;
	
	@JsonProperty("employee_anual_salary")
	private double employee_anual_salary;

	@JsonProperty("employee_age")
	private String employee_age;

	@JsonProperty("profile_image")
	private String profile_image;
	
	public Employee() {
	}


	public Employee(
			@JsonProperty("id") int id, 
			@JsonProperty("employee_name") String employee_name, 
			@JsonProperty("employee_salary") double employee_salary, 
			@JsonProperty("employee_anual_salary") double employee_anual_salary,
			@JsonProperty("employee_age") String age, 
			@JsonProperty("profile_image") String profile_image) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_anual_salary = employee_anual_salary;
		this.employee_age = age;
		this.profile_image = profile_image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public double getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(double employee_salary) {
		this.employee_salary = employee_salary;
	}

	public double getEmployee_anual_salary() {
		return employee_anual_salary;
	}

	public void setEmployee_anual_salary(double employee_anual_salary) {
		this.employee_anual_salary = employee_anual_salary;
	}

	public String getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(String employee_age) {
		this.employee_age = employee_age;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	

}
