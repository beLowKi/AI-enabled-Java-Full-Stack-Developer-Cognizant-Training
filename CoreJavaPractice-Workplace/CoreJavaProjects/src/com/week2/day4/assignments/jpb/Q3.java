package com.jpb;

public class Q3 {

	public static final char[] VOWELS = {
			'a', 'e', 'i', 'o', 'u', 'y'
	};
	
	public static void main(String[] args) {
		
		final String aStr = "Programming";
		int vowelCount = 0, consCount = 0;
		
		// Looping through characters to count vowels
		for (int i = 0; i < aStr.length(); i++) {
			char c = aStr.toLowerCase().charAt(i);
			
			for (char c2 : VOWELS) {
				if (c == c2) {
					vowelCount++;
					break;
				}
			}
		}
		
		// All non-vowels are consonants
		consCount = aStr.length() - vowelCount;
		
		System.out.println("Output:");
		System.out.println("Vowels: " + vowelCount);
		System.out.println("Consonants: " + consCount);
	}

}
