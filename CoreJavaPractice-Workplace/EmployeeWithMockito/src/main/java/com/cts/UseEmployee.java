package com.cts;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepositoryImpl;
import com.cts.service.EmployeeService;

public class UseEmployee {
	
	public static void main( String[] args ) {
		EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
		EmployeeService empService = new EmployeeService( empRepo );
		
		Employee e1 = new Employee( 1L, "Malcolm", "Trainee", 10.0d );
		Employee e2 = new Employee( 2L, "Malcolm II", "Trainee", 20.0d );
		
		empService.saveEmployee( e1 );
		empService.saveEmployee( e2 );
		
		Employee[] emps = empService.getAllEmployees();
		
		for ( Employee e : emps ) {
			System.out.println( e );
		}
		
	}

}
