package com.day5;

public class UseEmployee {

	public static void main(String[] args) {
		Employee empObj1 = new Employee();
		System.out.println(empObj1.id);
		System.out.println(empObj1.name);
		System.out.println(empObj1.salary);
		System.out.println();
		
		Employee empObj2 = new Employee(123, "Malcolm", 1e6);
		System.out.println(empObj2.id);
		System.out.println(empObj2.name);
		System.out.println(empObj2.salary);
		
		System.out.println();
		System.out.println(empObj1 + "\n");
		System.out.println(empObj2);
	}

}
