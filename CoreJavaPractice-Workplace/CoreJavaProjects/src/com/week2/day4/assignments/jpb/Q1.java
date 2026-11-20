package com.jpb;

public class Q1 {
	
	// Returns the reverse of an integer without converting to string.
	public static Integer reverseInt(int num) {
		
		// Catching 0
		if (num == 0) return 0;
		
		int out = 0;
		int sign = (num > 0) ? 1 : -1;
		
		// Total number of digits; e.g., 1234 -> 4 digits
		int numDigits = ((int)Math.log10((double)Math.abs(num))) + 1;
		
		for (int i = 1; i <= numDigits; i++) {
			int digit = Math.floorMod(Math.abs(num), 10);
			int newValue = Math.powExact(10, numDigits - i);
			
			if ( 
					( sign == 1 && ( newValue > Integer.MAX_VALUE - out ) ) ||
					( sign == -1 && ( newValue > Math.abs(Integer.MIN_VALUE) - out ) )
			) {
				System.err.println("Integer Overflow!");
				return null;
			}
					
			// This uses 10^(reversed digits place) to
			// effectively shift this digit's position in the number
			out += digit * Math.powExact(10, numDigits - i);
			
			// Removes digits after they've been handled
			num /= 10;
		}
		
		return sign * out;
	}
	
	public static void main(String[] args) {
		
		// Testing with Integer that should work
		Integer inputNumber = Integer.MAX_VALUE / 10;
		
		Integer reversed = reverseInt(inputNumber); 
		if (reversed == null) System.exit(1);
		
		System.out.println("Input: " + inputNumber);
		System.out.println("Output: " + reversed);
		
		// Testing with Integer that should cause overflow
		inputNumber = Integer.MAX_VALUE;
		
		reversed = reverseInt(inputNumber);
		System.out.println("\nInput: " + inputNumber);
		System.out.println("Output: " + reversed);
		
		System.exit(0);
	}

}
