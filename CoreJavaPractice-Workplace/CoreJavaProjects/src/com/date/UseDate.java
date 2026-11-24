package com.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UseDate {

	public static void main( String[] args ) {
		LocalDate today = LocalDate.now();
		System.out.println( today );

		LocalTime nowTime = LocalTime.now();
		System.out.println( nowTime );

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println( ldt );

		LocalDate joiningDate = LocalDate.of( 2026, 11, 12 );
		System.out.println( joiningDate );

		System.out.println( "Year: " + today.getYear() );
		System.out.println( "Month: " + today.getMonth() );
		System.out.println( "Day: " + today.getDayOfMonth() );
		System.out.println( "Day of Week: " + today.getDayOfWeek() );

		System.out.println( "After ten days: " + today.plusDays( 10 ) );
		System.out.println( "2 months ago: " + LocalDate.of( 2026, 12, 31 ).minusMonths( 1 ) );
		
		Period per = Period.between(joiningDate, today);
		System.out.println( per );
		System.out.println( per.getYears() );
		System.out.println( per.getDays() );
		System.out.println( per.getMonths() );
		
		DateTimeFormatter datifo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = today.format(datifo);
		System.out.println( formattedDate );
		
		String inputDate = "06-11-2003";
		LocalDate dateFormat = LocalDate.parse(inputDate, datifo);
		System.out.println( dateFormat );
	}

}
