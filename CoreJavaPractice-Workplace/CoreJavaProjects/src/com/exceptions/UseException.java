package com.exceptions;

public class UseException {

	public static void main( String[] args ) throws NullPointerException {
		int[] arr = { 1, 2, 3, 4 };

		try {
			System.out.println( arr[2] );
			System.out.println( "I'm in the try block" );

			int x = 10 / 2;

			String name = "Max";
			name = null;

			System.out.println( name.length() );

		} catch ( ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e ) {
			System.out.println( "Exception thrown: " + e.getMessage() );

		} finally {
			System.out.println( "I am anyways going to be executed" );
		}

		System.out.println( "Program complete" );
	}

}
