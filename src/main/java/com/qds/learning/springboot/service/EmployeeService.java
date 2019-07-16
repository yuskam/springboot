package com.qds.learning.springboot.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.qds.learning.springboot.dao.EmployeeRepository;
import com.qds.learning.springboot.model.Employee;

@Service
public class EmployeeService {

	@Inject
	private EmployeeRepository employeeRepository;


	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
}
