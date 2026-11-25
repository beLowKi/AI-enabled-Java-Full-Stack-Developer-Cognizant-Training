package com.cts.repository;

import com.cts.model.Employee;

public interface EmployeeRepository {

	Employee[] findAllEmployees();
	
	void saveEmployee(Employee emp);
	
}
