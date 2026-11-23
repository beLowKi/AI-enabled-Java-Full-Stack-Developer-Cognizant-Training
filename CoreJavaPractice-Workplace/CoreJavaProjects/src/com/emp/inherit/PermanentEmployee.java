package com.emp.inherit;

public class PermanentEmployee extends Employee {

	private double bonus;

	public PermanentEmployee(double bonus) {
		super();
		this.bonus = bonus;
	}

	public PermanentEmployee(double bonus, String name, int salary) {
		super(name, salary);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + this.bonus;
	}

	@Override
	public double calculateSalary() {
		return salary + bonus;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Bonus: " + this.bonus);
	}

}
