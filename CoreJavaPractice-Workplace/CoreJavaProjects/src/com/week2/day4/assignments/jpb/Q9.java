package com.jpb;

public class Q9 {
	
	public static void deleteAll(StringBuilder sb, char c) {
		while (true) {
			final int index = sb.indexOf(String.valueOf(c));
			if (index <= -1) return;
			
			sb.deleteCharAt(index);
		}
	}
	
	
	public static Character firstNonRepeating(String s) {
		
		StringBuilder queue = new StringBuilder(s);
		
		while ( !queue.isEmpty() ) {
			final char c = queue.charAt(0);
			
			// Single-character queue means it's unique
			if (queue.length() == 1) {
				return c;
			}
			
			// Non-duplicate found
			if ( queue.indexOf(String.valueOf(c), 1) == -1 ) {
				return c;
			}
			
			// Removing all occurrances of the character
			deleteAll(queue, c);
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		String s = "swiss";
		Character nonRepeating = firstNonRepeating(s);
		System.out.println(
				(nonRepeating != null) 
					? s + ": " + nonRepeating 
							: s + ": No non-repeating character"
			);
		
		s = "aabbcc";
		nonRepeating = firstNonRepeating(s);
		System.out.println(
				(nonRepeating != null) 
					? s + ": " + nonRepeating 
							: s + ": No non-repeating character"
			);
	}

}
