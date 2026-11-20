package com.jpb;

public class Q11 {

	// Returns the longest substring inside a String
	// that has no repeating characters
	/**
	 * @param s
	 * @return
	 */
	public static String longestSubsNoRepeats(String s) {
		
		// Catches empty strings
		if ( s.isEmpty() ) return s;
		
		// Longest known substr
		String longest = "";
		
		// In-progress substr
		StringBuilder substr = new StringBuilder();
		
		// Loops through the string's characters just 
		// once for O(n) runtime complexity. 
		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			final int index = substr.indexOf(String.valueOf(c));
			
			// Duplicate found, current substring ends
			if ( index != -1 ) {
				
				// Replacing longest string
				if (substr.length() > longest.length()) {
					longest = substr.toString();
				}
				
				substr = new StringBuilder(
						( index < substr.length() - 1 )
							// Duplicate wasn't last character, so
							// remaining substr can be continue
							? substr.substring(index + 1)
							
							// Starting from new character
							// This can happen on strings like "happen";
							// the second p would trigger a new substr
							// without inheriting any of the previous one
							: ""
						);
			}
			
			substr.append(c);
		}
		
		// Final check of ending substring
		return ( substr.length() > longest.length() )
				? substr.toString()
				: longest;
	}
	
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		String substr = longestSubsNoRepeats(s);
		System.out.println("Longest Substring:");
		System.out.println('\t' + s + " -> " + substr);
		System.out.println('\t' + "Length: " + substr.length());
		
		s = "pwwkew";
		substr = longestSubsNoRepeats(s);
		System.out.println("\nLongest Substring:");
		System.out.println('\t' + s + " -> " + substr);
		System.out.println('\t' + "Length: " + substr.length());
		
		s = "hadoooooooooooooop";
		substr = longestSubsNoRepeats(s);
		System.out.println("\nLongest Substring:");
		System.out.println('\t' + s + " -> " + substr);
		System.out.println('\t' + "Length: " + substr.length());
	}

}
