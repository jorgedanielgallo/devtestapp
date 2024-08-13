package com.example.devtestapp.repository;

import com.example.devtestapp.model.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findById(Long id);
}
