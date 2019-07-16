package com.qds.learning.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qds.learning.springboot.model.Employee;

@Repository
public class EmployeeRepository {

	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "F1", "L1", "f1.l1@company.com"));
		employees.add(new Employee(2, "F2", "L2", "f2.l2@company.com"));
		employees.add(new Employee(3, "F3", "L3", "f3.l3@company.com"));
		employees.add(new Employee(4, "F4", "L4", "f4.l4@company.com"));
		employees.add(new Employee(5, "F5", "L5", "f5.l5@company.com"));
		employees.add(new Employee(6, "F6", "L6", "f6.l6@company.com"));
		employees.add(new Employee(7, "F7", "L7", "f7.l7@company.com"));
		employees.add(new Employee(8, "F8", "L8", "f8.l8@company.com"));
		employees.add(new Employee(9, "F9", "L9", "f9.l9@company.com"));
		employees.add(new Employee(10, "F10", "L10", "f10.l10@company.com"));

		return employees;
	}
}
