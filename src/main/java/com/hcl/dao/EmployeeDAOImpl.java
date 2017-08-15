package com.hcl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}
	
	@Override
	public void deleteEmployee(Integer empId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, empId);
		if(null != employee){
			this.sessionFactory.getCurrentSession().delete(employee);
		}		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(int empId) {		
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, empId);
	}

}
