package com.shristi.training;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	EntityManager entityManager;
	
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		
	}

	public Employee getById(Integer empId) {
		return entityManager.find(Employee.class,empId);
	}

	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

	public void updateEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

}
