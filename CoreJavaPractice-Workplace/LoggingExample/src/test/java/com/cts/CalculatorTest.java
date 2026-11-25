package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	public static Calculator calc;


	@BeforeAll
	static void setUp() {
		calc = new Calculator();
	}


	@BeforeEach
	void beforeEach() {
		System.out.println( "Running before each test case" );
	}


	@AfterEach
	void afterEach() {
		System.out.println( "Running after each test case" );
	}


	@Test
	void testAdd() {

		int result = calc.add( 5, 3 );

		assertEquals( 8, result );

	}


	@Test
	void testSubtract() {
		int result = calc.subtract( 10, 3 );

		assertEquals( 7, result );
	}


	@Test
	void testMultiply() {
		int result = calc.multiply( 5, 3 );

		assertEquals( 15, result );
	}


	@Test
	void testDivide_Positive() {

		int result = calc.division( 20, 4 );

		assertEquals( 5, result );

	}


	@Test
	void testDivision_Negative_DivideByZero() {
		try {
			calc.division( 10, 0 );
			fail( "Expected ArithmeticException was not thrown" );
		} catch ( ArithmeticException exception ) {
			assertEquals( "Cannot divide by zero", exception.getMessage() );
		}
	}


	@Test
	void testIsEven() {
		assertTrue( calc.isEven( 8 ) );
		assertFalse( calc.isEven( 3 ) );
	}

}
