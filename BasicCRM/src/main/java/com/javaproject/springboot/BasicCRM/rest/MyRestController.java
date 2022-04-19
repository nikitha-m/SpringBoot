package com.javaproject.springboot.BasicCRM.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.springboot.BasicCRM.entity.Employee;
import com.javaproject.springboot.BasicCRM.service.EmployeeService;

@RestController
public class MyRestController {
	
	private EmployeeService employeeService;

	public MyRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findall();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		try {
			employeeService.save(theEmployee);
			
			return theEmployee;
		}catch(Exception exp) {
			throw new RuntimeException("Employee ID not found!!!");
		}
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee empEmployee = employeeService.findById(employeeId);
		
		if (empEmployee == null) {
			throw new RuntimeException(employeeId + "Employee id not found!!! ");

 		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee with id: " + employeeId;
	}
}