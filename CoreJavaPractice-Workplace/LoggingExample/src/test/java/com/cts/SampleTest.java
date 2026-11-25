package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A simple sample test class used to demonstrate a JUnit 5 test suite.
 */
@DisplayName( "Sample Tests" )
public class SampleTest {

	private Calculator calculator;


	@BeforeEach
	void setUp() {
		calculator = new Calculator();
		System.out.println( "SampleTest: setting up a new Calculator" );
	}


	@AfterEach
	void tearDown() {
		calculator = null;
		System.out.println( "SampleTest: test finished" );
	}


	@Test
	@DisplayName( "Adding a number and zero returns the same number" )
	void testAddZero() {
		assertEquals( 15, calculator.add( 15, 0 ) );
	}


	@Test
	@DisplayName( "Multiplying by one returns the same number" )
	void testMultiplyByOne() {
		assertEquals( 42, calculator.multiply( 42, 1 ) );
	}


	@Test
	@DisplayName( "Zero is an even number, one is not" )
	void testIsEvenEdgeCases() {
		assertTrue( calculator.isEven( 0 ) );
		assertFalse( calculator.isEven( 1 ) );
	}


	@Test
	@DisplayName( "Greeting is never null" )
	void testGreetNotNull() {
		assertNotNull( calculator.greet( "Asha" ) );
	}


	@Test
	@DisplayName( "Division of a number by itself returns one" )
	void testDivisionBySelf() {
		assertEquals( 1, calculator.division( 9, 9 ) );
	}

}
