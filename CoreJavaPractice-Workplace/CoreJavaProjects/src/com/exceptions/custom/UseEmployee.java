package com.exceptions.custom;

public class UseEmployee {

	public static void main( String[] args ) {

		Employee e1 = null;

		try {
			e1 = new Employee( "Malcolm", -1e6 );
		} catch ( InvalidSalaryException e ) {
			e.printStackTrace();
			// System.err.println( "Error creating employee: " + e.getMessage() );
		}

	}

}
