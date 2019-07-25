package com.qds.learning.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qds.learning.springboot.model.Employee;
import com.qds.learning.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees/findAll")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
}
