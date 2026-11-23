package com.emp.inherit;

public class Employee {

	protected int id;
	protected String name;
	protected double salary;
	
	private static int number = 0;

	public Employee() {
		this.id = number++;
	}

	Employee(String aName, double aSalary) {
		this.id = number++;
		this.name = aName;
		this.salary = aSalary;
	}

	@Override
	public String toString() {
		return this.id + " | " + this.name + " | " + this.salary;
	}

	private double incrementSalary() {
		this.salary += (this.salary * 0.2);
		return this.salary;
//		return this.salary + (this.salary * 0.2); 
	}

	public double calculateSalary() {
		return salary;
	}

	public void display() {
		System.out.println("ID: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary);
	}

}
