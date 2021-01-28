package com.shristi.training;

public interface EmpDAO {
	void addEmployee(Employee employee);
	Employee getById(Integer id);
	void deleteEmployee(Integer id);
	void updateEmployee(Integer id);

}
