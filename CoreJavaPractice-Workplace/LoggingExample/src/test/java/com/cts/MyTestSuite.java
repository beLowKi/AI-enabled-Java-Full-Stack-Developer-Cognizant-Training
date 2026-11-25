package com.cts;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("MyTestSuite")
@SelectClasses({
    CalculatorTest.class,
    CalculatorParameterizedTest.class,
    SampleTest.class
})
public class MyTestSuite {
	
	
	
}
