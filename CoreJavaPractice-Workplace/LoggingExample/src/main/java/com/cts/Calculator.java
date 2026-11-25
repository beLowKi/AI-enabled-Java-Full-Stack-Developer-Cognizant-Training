package com.cts;

public class Calculator {

	public int add( int a, int b ) {
		return a + b;
	}


	public int subtract( int a, int b ) {
		return a - b;
	}


	public int multiply( int a, int b ) {
		return a * b;
	}


	public int division( int a, int b ) {
		if ( b == 0 ) {
			throw new ArithmeticException( "Cannot divide by zero" );
		}
		return a / b;
	}


	public boolean isEven( int number ) {
		return number % 2 == 0;
	}


	public String greet( String name ) {
		return "Hello, " + name;
	}

}
