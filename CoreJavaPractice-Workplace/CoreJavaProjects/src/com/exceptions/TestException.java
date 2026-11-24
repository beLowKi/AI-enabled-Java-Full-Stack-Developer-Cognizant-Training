package com.exceptions;

public class TestException {

	public static void main( String[] args ) {

		int[] arr = { 1, 2, 3, 4 };

		try {
			System.out.println( arr[2] );
			System.out.println( "I'm in the try block" );

			int x = 10 / 2;

			String name = "Max";
			name = null;

			System.out.println( name.length() );

		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println( "You cannot show the value ofthe array beyond the boundry.\n" + e.getMessage() );

		} catch ( ArithmeticException e ) {
			System.out.println( "You cannot divide a number by zero" );

		} catch ( NullPointerException e ) {
			System.out.println( "You cannot find the length of a null pointer\n" + e.getMessage() );
			
		} finally {
			System.out.println( "I am anyways going to be executed" );
		}

		System.out.println( "Program complete" );
	}

}
