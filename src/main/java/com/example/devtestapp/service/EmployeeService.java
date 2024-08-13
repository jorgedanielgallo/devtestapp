package com.example.devtestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.devtestapp.model.Employee;
import com.example.devtestapp.model.EmployeeResponse;
import com.example.devtestapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final String EMPLOYEES_API = "http://dummy.restapiexample.com/api/v1/employees";
	private static final String EMPLOYEE_API = "http://dummy.restapiexample.com/api/v1/employee/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		try {
            EmployeeResponse response = restTemplate.getForObject(EMPLOYEES_API, EmployeeResponse.class);
            List<Employee> employeeList = response.getData();
            employeeList.forEach(emp -> emp.setEmployee_anual_salary(emp.getEmployee_salary() * 12));
            employeeRepository.saveAll(employeeList);
            return employeeList;
		} catch (RestClientException e) {
            return employeeRepository.findAll();
		}
	}
	
	public Employee getEmployeeById(int id) {
		try {
			EmployeeResponse response = restTemplate.getForObject(EMPLOYEE_API + id, EmployeeResponse.class);
			Employee employee = response.getData().get(0);	
			if (employee != null) {
				employee.setEmployee_anual_salary(employee.getEmployee_salary() * 12);
			}
			return employee;
		} catch (RestClientException e) {
            return employeeRepository.findById(id).orElse(null);
		}
	}
}
