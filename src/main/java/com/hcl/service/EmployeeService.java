package com.hcl.service;

import java.util.List;

import com.hcl.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeId);

	public Employee updateEmployee(Employee employee);
}
