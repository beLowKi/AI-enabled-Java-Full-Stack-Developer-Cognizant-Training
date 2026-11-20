package com.day5;

public class MethodTest {
	
	public static int addition() {
		return 1 + 2;
	}
	
	public static int addition(int a, int b) {
		return a + b;
	}
	
	public static int multiply() {
		return 4 * 3;
	}
	
	public static int multiply(int a, int b) {
		return a * b;
	}
	
	public static int divide() {
		return 12 / 4;
	}
	
	public static int divide(int a, int b) {
		if (b == 0) throw new ArithmeticException("Cannot divide by zero");
		return a / b;
	}
	
	
	public static void main(String[] args) {
		System.out.println(addition());
		System.out.println(addition(5, 10));
		System.out.println(multiply());
		System.out.println(multiply(3, 12));
	}

}
