package com.javaproject.springboot.BasicCRM.dao;

import java.util.List;
import com.javaproject.springboot.BasicCRM.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findall();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}