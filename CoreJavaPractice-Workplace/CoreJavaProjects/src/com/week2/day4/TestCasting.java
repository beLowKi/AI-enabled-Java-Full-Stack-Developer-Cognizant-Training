package com.week2.day4;

public class TestCasting {

	public static void main(String[] args) {
		
		// implicit casting
		int num = 200;
		double d = num;  
		System.out.println("Widening cast conversion from int to double " + d);
		
		// explicit casting
		double value = 9.87;
		int rounded = (int) value;
		System.out.println("Narrowing cast conversion from double to int " + rounded);
		
		char ch = 'A';
		int chCode = (int) ch;
		System.out.println("Char to int conversion: " + chCode);
		
		ch = 'a';
		chCode = (int) ch;
		System.out.println("Char to int conversion: " + chCode);
	}

}
