package com.week2.day5;

public class Employee {
	private int id;
	private String name;
	private double salary;
	
	private static int number = 0;
	
	public Employee() {}
	
	Employee(String aName, double aSalary) {
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
