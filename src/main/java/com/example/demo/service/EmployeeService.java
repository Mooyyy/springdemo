package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeebyID(long id);
	void deleteEmployeeByID(long id);
	List<Employee> findByKeyword(String keyword);
}
