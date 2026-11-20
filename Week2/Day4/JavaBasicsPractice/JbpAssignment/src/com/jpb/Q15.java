package com.jpb;

import java.math.BigDecimal;

// For the sake of my environment's naming convention,
// the main class of this file is going to stay Q15 and I'll
// just add this extra one.

class Employee {
	
	private Long id;
	private String name;
	private BigDecimal salary;
	private Float bonusPercentage;
	private Boolean active;
	
	Employee(
			Long aId, 
			String aName, 
			String aSalary, 
			Float aBonusPercentage, 
			Boolean isActive
	) {
		this.id = aId;
		this.name = aName.toUpperCase();
		this.salary = new BigDecimal(aSalary);
		this.bonusPercentage = aBonusPercentage;
		this.active = isActive;
	}
	
	public BigDecimal getFinalSalary() {
		return this.salary.add(this.getBonus());
	}

	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getBonus() {
		return this.salary.multiply(new BigDecimal(this.bonusPercentage));
	}
	
	public BigDecimal getSalary() {
		return this.salary;
	}
	
	public Boolean getActive() {
		return this.active;
	}
}


public class Q15 {
	
	public static String reverseStr(String s) {
		StringBuilder reversed = new StringBuilder();
		
		for ( int i = s.length() - 1; i >= 0; i-- ) {
			reversed.append(s.charAt(i));
		}
		
		return reversed.toString();
	}
	
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee(
				101L,
				"Rahul",
				"60000",
				0.2f,
				true
		);
		
		System.out.println("Employee ID: " + e1.getId());
		System.out.println("Employee Name: " + e1.getName());
		System.out.println("Basic Salary: " + e1.getSalary());
		System.out.println("Bonus: " + e1.getBonus());
		System.out.println("Final Salary: " + e1.getFinalSalary());
		System.out.println("Active: " + e1.getActive());
		System.out.println("Reversed Name: " + reverseStr(e1.getName()));
		System.out.println(
						"Salary above 75,000: " + 
						(e1.getFinalSalary().compareTo(new BigDecimal(75_000)) > 0)
		);
		
	}

}
