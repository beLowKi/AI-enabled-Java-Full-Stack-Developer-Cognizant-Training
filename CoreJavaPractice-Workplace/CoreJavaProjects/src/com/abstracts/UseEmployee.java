package com.abstracts;

public class UseEmployee {

	public static void main(String[] args) {
		PermanentEmployee p1 = new PermanentEmployee(100, "Alice", 50000, 15000);
		System.out.println(p1.calculateSalary());
	}
	
}
