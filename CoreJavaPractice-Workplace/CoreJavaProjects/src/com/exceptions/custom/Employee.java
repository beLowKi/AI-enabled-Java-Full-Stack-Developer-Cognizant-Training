package com.exceptions.custom;

public class Employee {
	int id;
	String name;
	double salary;
	
	private static int number = 0;
	
	public Employee() {}
	
	Employee(String aName, double aSalary) throws InvalidSalaryException {
		if ( aSalary <= 0 ) {
			throw new InvalidSalaryException( "Salary must be greater than 0" );
		}
		
		this.id = number++;
		this.name = aName;
		this.salary = aSalary;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary;
	}
	
	private double incrementSalary() {
		this.salary += (this.salary * 0.2);
		return this.salary;
//		return this.salary + (this.salary * 0.2); 
	}
	
	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}
