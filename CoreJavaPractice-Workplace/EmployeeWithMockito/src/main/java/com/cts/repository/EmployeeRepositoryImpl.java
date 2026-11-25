package com.cts.repository;

import com.cts.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Employee[] emps = new Employee[5];

	private int count = 0;


	@Override
	public Employee[] findAllEmployees() {

		Employee[] result = new Employee[count];

		for ( int i = 0; i < count; i++ ) {
			result[i] = emps[i];
		}

		return result;

	}


	@Override
	public void saveEmployee( Employee emp ) {
		
		if ( count < emps.length ) {
			emps[count] = emp;
			count++;
		
		} else {
			System.out.println( "Employee array is full!" );
		}
		
	}

}
