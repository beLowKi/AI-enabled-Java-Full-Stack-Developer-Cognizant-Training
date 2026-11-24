package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {

	public static void main( String[] args ) {
		
		final String filepath = "employees.txt";
		
		// Writing to file
		Employee[] emps =
			new Employee[] { new Employee( 1, "Carl John", "HR", 80000 ),
				new Employee( 2, "Sally Sallyton", "Management", 1e6 ), new Employee( 3, "Mary Sue", "R&D", 95000 ),
				new Employee( 4, "Billy Bob", "HR", 60000 ), new Employee( 5, "Karen Stewart", "Marketing", 75000 ) };

		// Writing employees to file
		try ( 
			FileOutputStream os = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream( os ); 
		) {
			
			oos.writeObject(emps);
			
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
			
		} catch ( IOException e ) {
			e.printStackTrace();
		}

		// Reading employees on file
		Employee[] empsOnFile = null;
		
		try (
			FileInputStream fs = new FileInputStream( filepath );
			ObjectInputStream ois = new ObjectInputStream(fs)
		) {
			
			empsOnFile = (Employee[]) ois.readObject();
			
		} catch ( IOException e ) {
			e.printStackTrace();
			
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		// Displaying employees
		if ( empsOnFile == null ) {
			System.err.println( "Failed to get employees on file" );
		}
		
		for ( final Employee employee : empsOnFile ) {
			System.out.println( employee );
		}
		
	}

}
