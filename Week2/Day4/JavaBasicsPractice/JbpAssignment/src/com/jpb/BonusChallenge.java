package com.jpb;

public class BonusChallenge {
	
	public static boolean isPalindrome(String s) {
		
		// Catches strings with length <= 1
		if (s.length() <= 1) return true;
		
		for ( int i = 0; i < s.length(); i++ ) {
			final char c1 = s.charAt(i);
			final char c2 = s.charAt(s.length() - i - 1);
			if (c1 != c2) return false;
		}
		
		return true;
		
	}
	
	
	public static String longestSubPalindrome(String s) {
		
		// Catches empty strings
		if ( s.isEmpty() ) return s;
		
		// Longest palindrome substring
		String longest = "";
		
		// Loops through the string's characters just 
		// once for O(n) runtime complexity. 
		for (int i = 0; i < s.length(); i++) {
			final char c1 = s.charAt(i);
			
			// Reverse-search until matching character 
			// (would be the end of a palindrome)
			for ( int y = s.length() - 1; y >= 0; y-- ) {
				final char c2 = s.charAt(y);
				if (c1 != c2) continue;
				
				// Checking for a palindrome on a matching character
				// TBD on previous lines because isPalindrome will
				// return false immediately if the first and last characters
				// aren't the same anyway?
				String slice = s.substring(i, y + 1);
				if (isPalindrome(slice)) {
					if (slice.length() > longest.length()) {
						longest = slice;
					}
					
					// Breaks regardless of if longest is replaced
					// because all future palindromes of this loop
					// will have shorter lengths
					break;
				}
			}
		}
		
		return longest;
		
	}
	
	
	public static void main(String[] args) {
		String s = "babad";
		String out = longestSubPalindrome(s);
		System.out.println(s + " -> " + out);
		
		s = "raccceescarracecarasdf";
		out = longestSubPalindrome(s);
		System.out.println(s + " -> " + out);
	}

}
