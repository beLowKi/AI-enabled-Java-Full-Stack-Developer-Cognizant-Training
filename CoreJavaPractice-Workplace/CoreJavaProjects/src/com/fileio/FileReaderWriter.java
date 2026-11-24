package com.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main( String[] args ) {
		
		try (
			FileWriter fw = new FileWriter( "writtenFile.txt" );
			FileReader fr = new FileReader( "writtenFile.txt" );
		) {

			fw.write( "Hello" );
			fw.close();
			
			
			
			int i = fr.read();

			while ( i != -1 ) {
				System.out.print( (char) i );
				System.out.print( (char) i );
				i = fr.read();
			}

		} catch ( IOException e ) {
			e.printStackTrace();
		}

	}

}
