package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName( "Calculator - Parameterized Tests" )
public class CalculatorParameterizedTest {

	private Calculator calculator;


	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}


	// @formatter:off
	@ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "10, 20, 30",
        "0, 0, 0",
        "-5, 5, 0",
        "-10, -20, -30",
        "100, 250, 350"
    })
	// @formatter:on
	void testAdd( int a, int b, int expected ) {
		
		assertEquals( expected, calculator.add(a, b) );
		
	}

}
