package com.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadWriteObject {

	public static void main( String[] args ) {

		Employee e1 = new Employee( "Malcolm Marberry", 1e5 );
		Employee e2 = null;

		try (
			FileOutputStream fos = new FileOutputStream( "emp.txt" );
			ObjectOutputStream oos = new ObjectOutputStream( fos );
			FileInputStream fis = new FileInputStream( "emp.txt" );
			ObjectInputStream ois = new ObjectInputStream( fis );
		) {
			
			System.out.println( "Writing to file" );
			oos.writeObject(e1);
			
			System.out.println( "Reading file" );
			e2 = (Employee) ois.readObject();
			System.out.println( e2 );
			
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();

		} catch ( IOException e ) {
			e.printStackTrace();
			
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}

}
