package com.abstracts;

public abstract class Employee {

	int id;
	String name;
	double salary;

	/**
	 * @param id
	 * @param name
	 * @param salary
	 */
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void display() {
		System.out.println(this.id + " | " + this.name + " | " + this.salary);
	}
	
	abstract double calculateSalary();
}
