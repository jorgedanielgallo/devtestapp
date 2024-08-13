package com.example.devtestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.devtestapp.model.Employee;
import com.example.devtestapp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String getEmployees(@RequestParam(required = false) Integer id, Model model) {
		if (id == null) {
			List<Employee> employees = employeeService.getAllEmployees();
			model.addAttribute("employees", employees);
		} else {
			Employee employee = employeeService.getEmployeeById(id);
			model.addAttribute("employee", employee);
		}
		return "employeeView";
	}
}
