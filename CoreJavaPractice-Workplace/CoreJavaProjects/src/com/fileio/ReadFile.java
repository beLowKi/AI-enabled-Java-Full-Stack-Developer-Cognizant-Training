package com.fileio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

	public static void main( String[] args ) {
		try (
			FileInputStream fis = new FileInputStream( "testFile.txt" );
			BufferedInputStream bis = new BufferedInputStream( fis );
		) {
			
			while ( bis.available() > 0 ) {
				System.out.print( (char) bis.read() );
			}
			
		} catch ( FileNotFoundException e ) {
			System.err.println( e.getMessage() );

		} catch ( IOException e ) {
			System.err.println( "IO Error: " + e.getMessage() );
		}
	}
}
