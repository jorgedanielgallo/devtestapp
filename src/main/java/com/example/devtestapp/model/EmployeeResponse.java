package com.example.devtestapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("data")
	private List<Employee> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}
	
	
}
