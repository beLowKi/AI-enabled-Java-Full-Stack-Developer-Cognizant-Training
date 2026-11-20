
public class MethodLab {

	// Prints the given values
	public static void printProfile(
			String name, 
			int age, 
			double height, 
			boolean student,
			char grade
	) {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Height: " + height);
		System.out.println("Student: " + student);
		System.out.println("Grade: " + grade);
		
	}
	
	
	// Returns the average of the 3 integers
	public static double average(int a, int b, int c) {
		return (a + b + c) / 3.0;
	}
	
	
	// Returns whether the given int fits inside 'byte' type [-128, 127]
	public static boolean fitsInByte(int value) {
		return ( value >= Byte.MIN_VALUE ) && ( value <= Byte.MAX_VALUE );
	}
	
	
	// Converts both strings to Integer before returning their sum.
	// Non-numeric strings aren't handled
	public static int addTexts(String a, String b) {
		return Integer.parseInt(a) + Integer.parseInt(b);
	}
	
	
	// Boxes the given primitive int twice (*= 2 the second time) 
	// before returning the value.
	public static int boxTwice(int x) {
		return Integer.valueOf(new Integer(x) * 2);
	}

	
	public static void describe(Integer n) {
		System.out.println("Binary String: " + Integer.toBinaryString(n));
		System.out.println("Integer Max: " + Integer.MAX_VALUE);
		System.out.println("Comparison to 10.5: " + Double.compare(n, 10.5));
	}
	
	
	// Returns if the 2 Integers have the same value
	public static boolean sameValue(Integer a, Integer b) {
		System.out.println("'equals': " + a.equals(b));
		System.out.println("'==': " + (a == b));
		return a.equals(b);
	}
	
	
	public static void main(String[] args) {
		
		// 1.1 Testing printProfile
		System.out.println("Output of 'printProfile':");
		printProfile(
				"Malcolm",
				22,
				1.95,
				false,
				'A'
		);
		System.out.println();
		
		
		// 1.2 testing average
		System.out.println("Output of average(1, 2, 2):");
		System.out.println(average(1, 2, 2));
		System.out.println();
		
		// 1.3 testing fitsInByte
		System.out.println("Output of fitsInByte(127): " + fitsInByte(127));
		System.out.println("Output of fitsInByte(128): " + fitsInByte(128));
		System.out.println("Output of fitsInByte(-129): " + fitsInByte(-129));
		System.out.println();
		
		// 2.1 addTexts
		System.out.println("Output of addTexts(\"123\", \"456\"): " + addTexts("123", "456"));
		System.out.println();
		
		// 2.2 boxTwice
		System.out.println("Output of boxTwice(21): " + boxTwice(21));
		System.out.println();
		
		// 2.3 describe
		System.out.println("Output of describe(10):");
		describe(10);
		System.out.println();
		
		// 2.4 sameValue(Integer a, Integer b)
		System.out.println("Output of sameValue(127, 127): ");
		System.out.println("Return: " + sameValue(127, 127) + '\n');
		
		// 3.1 
	}

}
