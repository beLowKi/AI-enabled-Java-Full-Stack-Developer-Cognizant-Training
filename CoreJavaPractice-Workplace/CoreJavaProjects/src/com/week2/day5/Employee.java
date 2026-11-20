package com.day5;

public class Employee {
	int id;
	String name;
	double salary;
	
	public Employee() {}
	
	Employee(int aId, String aName, double aSalary) {
		this.id = aId;
		this.name = aName;
		this.salary = aSalary;
	}
	
	@Override
	public String toString() {
		return (
				"ID: " + this.id +
				"\nName: " + this.name +
				"\nSalary: " + this.salary
		);
	}
}
