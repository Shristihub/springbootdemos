package com.shristi.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	public void addEmployee(Employee employee) {
		empDAO.addEmployee(employee);
		
	}

	public Employee getById(Integer empId) {
		return empDAO.getById(empId);
	}

	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

	public void updateEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

}
