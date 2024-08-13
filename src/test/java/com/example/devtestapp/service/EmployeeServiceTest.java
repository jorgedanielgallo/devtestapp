package com.example.devtestapp.service;

import com.example.devtestapp.model.Employee;
import com.example.devtestapp.model.EmployeeResponse;
import com.example.devtestapp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee mockedEmployee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        mockedEmployee = new Employee(1, "Tiger Nixon", 320800, 3849600, "23", "");
        
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setStatus("success");
        employeeResponse.setData(Collections.singletonList(mockedEmployee));

        when(restTemplate.getForObject(
                eq("http://dummy.restapiexample.com/api/v1/employee/1"), 
                eq(EmployeeResponse.class)))
            .thenReturn(employeeResponse);
        
        EmployeeResponse employeeListResponse = new EmployeeResponse();
        employeeListResponse.setStatus("success");
        employeeListResponse.setData(Collections.singletonList(mockedEmployee));

        when(restTemplate.getForObject(
                eq("http://dummy.restapiexample.com/api/v1/employees"), 
                eq(EmployeeResponse.class)))
            .thenReturn(employeeListResponse);
        
        when(employeeRepository.findById(anyInt()))
        	.thenReturn(Optional.of(mockedEmployee));

        when(employeeRepository.findAll())
        	.thenReturn(Collections.singletonList(mockedEmployee));
    }

    @Test
    public void testGetAllEmployees() {
    	List<Employee> employees = employeeService.getAllEmployees();
    	assertNotNull(employees);
    	assertEquals(1, employees.size());
    }
    
    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeService.getEmployeeById(1);
        assertNotNull(employee);
        assertEquals(mockedEmployee.getId(), employee.getId());
    }

}
