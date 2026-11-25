package com.cts.service;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

public class EmployeeService {

	private final EmployeeRepository empRepo;


	public EmployeeService( EmployeeRepository empRepo ) {
		this.empRepo = empRepo;
	}
	
	
	public Employee[] getAllEmployees() {
		return empRepo.findAllEmployees();
	}
	
	
	public void saveEmployee(Employee emp) {
		empRepo.saveEmployee( emp );
	}

}
