package com.week2.day4;

public class TestWrapper {

	public static void main(String[] args) {
		Integer age = 20;
		Double price = 5.00;
		Character grade = 'A';
		Boolean active = true;
		String str = new String("New String");
		String aStr = "Hey, I'm String here";
		
		// Autoboxxing
		int x = 210;
		Integer y = x;
		System.out.println(y);
		
		int z = 2;
		age = z;
		System.out.println(age);
		
		double p = price.doubleValue();
		
		String num = "200";
		int amount = Integer.valueOf(num);
		System.out.println(amount);
		age.intValue();
		
		age.compareTo(age);
		
		byte b = 0b1111111;
		System.out.println(b);
		
		int[] arr = new int[3];
		arr.length
	}

}
