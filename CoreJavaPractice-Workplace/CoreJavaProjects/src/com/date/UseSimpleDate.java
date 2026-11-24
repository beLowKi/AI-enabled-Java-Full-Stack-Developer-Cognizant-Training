package com.date;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UseSimpleDate {
	
	public static void main( String[] args ) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		
		try {
			System.exit(0);
			int x = 100 / 0;
			
		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println( "Error" );
			
		} finally {
			System.out.println( "Finally" );
		} 
		
		
//		LocalDate currDate = LocalDate.now(); 
//		System.out.println( currDate );
//		System.out.println( formattedDate );
	}

}
