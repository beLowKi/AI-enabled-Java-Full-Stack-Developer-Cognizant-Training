package com.jpb;

public class Q4 {

	public static void main(String[] args) {
		String age = "25";
		String salary = "45000.75";
		String active = "true";
		
		Integer intAge = Integer.parseInt(age);
		Double dSalary = Double.parseDouble(salary);
		Double boostedSalary = dSalary * 1.1;
		Boolean bActive = Boolean.parseBoolean(active);
		
		System.out.println("Integer intAge: " + intAge);
		System.out.println("Double dSalary: " + dSalary);
		System.out.println("Double boostedSalary: " + boostedSalary);
		System.out.println("Integer bActive: " + bActive);
	}

}
