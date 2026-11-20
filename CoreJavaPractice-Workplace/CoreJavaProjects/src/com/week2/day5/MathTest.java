package com.day5;

public class MathTest {

	public static int[] digitsOf(int num) {
		
		final int numDigits = (int)Math.log10((double)num) + 1;
		int[] digits = new int[numDigits];
		
		for ( int i = 0; i < numDigits; i++ ) {
			final int d = Math.floorMod(num, 10);
			digits[i] = d;
			num /= 10;
		}
		
		return digits;
	}
	
	
	public static void main(String[] args) {
		final int[] digits = digitsOf(12345);

		for ( final int d : digits ) {
			System.out.println(d);
		}
		
	}

}
