package com.fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteInAFile {

	public static void main( String[] args ) {

		String filepath = "testFile.txt";
		FileOutputStream fo = null;

		try {
			fo = new FileOutputStream( filepath );
			final String fileContent = "The quick brown fox jumped over the lazy dog";
			fo.write( fileContent.getBytes() );

			System.out.println( "Wrote to file successfully" );

		} catch ( FileNotFoundException e ) {
			System.err.println( "Failed to find file " + filepath );

		} catch ( IOException e ) {
			System.err.println( "IOError: " + e.getMessage() );

		} finally {
			try {
				fo.close();
			} catch ( IOException e ) {
				System.err.println( "Error closing file: " + e.getMessage() );
			}
		}

	}

}
