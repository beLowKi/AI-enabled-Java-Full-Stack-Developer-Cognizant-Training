package com.emp.inherit;

import java.util.Scanner;

public class UseEmployee {

	public static void main(String[] args) {
		
		final PermanentEmployee p1 = new PermanentEmployee(200, "Bob", 90000);
		System.out.println(p1 + "\n");
		p1.display();
		
		final TemporaryEmployee t1 = new TemporaryEmployee("Mary", 100000, 5, 1000);
		System.out.println(t1 + "\n");
		t1.display();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter the employee name: ");
		String name = sc.nextLine();
		System.out.println(name);
		
		System.out.print("\nEnter the employee salary: ");
		double salary = sc.nextDouble();
		System.out.println(salary);
		
	}

}
