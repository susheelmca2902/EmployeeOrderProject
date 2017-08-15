package com.hcl.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.dao.EmployeeDAO;
import com.hcl.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;  
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public void deleteEmployee(Integer empId) {
		employeeDAO.deleteEmployee(empId);
	}

	@Override
	public Employee getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO){
		this.employeeDAO = employeeDAO;
	}
}
