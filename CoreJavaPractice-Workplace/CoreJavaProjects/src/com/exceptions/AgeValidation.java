package com.exceptions;

public class AgeValidation {

	public static void checkAge( int age ) throws IllegalArgumentException {
		if ( age < 16 ) {
			throw new IllegalArgumentException( "Underage person cannot be processed" );
		}

		System.out.println( "Valid age" );
	}


	public static void main( String[] args ) {

		try {
			checkAge( 15 );
		} catch ( IllegalArgumentException e ) {
			System.out.println( e.getMessage() );
		}

	}

}
