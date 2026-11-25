package com.cts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseLogging {
	
	private static final Logger logger =
        LoggerFactory.getLogger(UseLogging.class);
	
	public static void main( String[] args ) {
		
		System.out.println( "Application started" );
		
		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.error("This is an error message");
		
		System.out.println( "Application completed" );
		
	}

}
