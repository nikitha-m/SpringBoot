package com.javaproject.springboot.BasicCRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.springboot.BasicCRM.entity.Employee;

@Repository
public class EmployeeDAOImple implements EmployeeDAO {
	
//	Fields
	private EntityManager entityManager;
	
//	Constructor
	public EmployeeDAOImple(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findall() {
		// get Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Query - accesses data from the database
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// Execute Query and get the total list
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	public Employee findById(int theId) {
		// get Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		// get Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object (by primanry key)
		Query theQuery = currentSession.createQuery("delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}
	
}