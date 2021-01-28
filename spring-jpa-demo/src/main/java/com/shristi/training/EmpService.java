package com.shristi.training;

public interface EmpService {
	void addEmployee(Employee employee);
	Employee getById(Integer id);
	void deleteEmployee(Integer id);
	void updateEmployee(Integer id);

}
