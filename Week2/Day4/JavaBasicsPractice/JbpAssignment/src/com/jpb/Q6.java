package com.jpb;

public class Q6 {

	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println(a);
		System.out.println(b);
	}

}
