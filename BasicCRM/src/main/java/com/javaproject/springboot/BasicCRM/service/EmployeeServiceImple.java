package com.javaproject.springboot.BasicCRM.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.springboot.BasicCRM.dao.EmployeeDAO;
import com.javaproject.springboot.BasicCRM.entity.Employee;


@Service
public class EmployeeServiceImple implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImple(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public List<Employee> findall() {
		// TODO Auto-generated method stub
		return employeeDAO.findall();
	}

	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
	}

	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);
	}

}