package com.emp.inherit;

public class TemporaryEmployee extends Employee {

	private int workingDays;
	private double perDayRate;

	public TemporaryEmployee(int workingDays, double perDayRate) {
		super();

		this.workingDays = workingDays;
		this.perDayRate = perDayRate;
	}

	public TemporaryEmployee(String name, double salary, int workingDays, double perDayRate) {
		super(name, salary);

		this.workingDays = workingDays;
		this.perDayRate = perDayRate;
	}

	/**
	 * @return the workingDays
	 */
	public int getWorkingDays() {
		return this.workingDays;
	}

	/**
	 * @param workingDays the workingDays to set
	 */
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	/**
	 * @return the perDayRate
	 */
	public double getPerDayRate() {
		return this.perDayRate;
	}

	/**
	 * @param perDayRate the perDayRate to set
	 */
	public void setPerDayRate(double perDayRate) {
		this.perDayRate = perDayRate;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + this.workingDays + " | " + this.perDayRate;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Working Days: " + this.workingDays);
		System.out.println("Per Day Rate: " + this.perDayRate);
	}
}
