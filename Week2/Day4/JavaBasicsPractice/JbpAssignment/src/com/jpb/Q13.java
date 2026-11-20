package com.jpb;

public class Q13 {

	public static String reverseWords(String s) {
		
		StringBuilder out = new StringBuilder();
		
		for ( int i = s.length() - 1; i >= 0; i-- ) {
			
			// Skipping spaces
			if (s.charAt(i) == ' ') continue;
			
			// Building non-reverse word
			StringBuilder word = new StringBuilder();
			
			for ( int y = i; y >= 0; y-- ) {
				final char c = s.charAt(y);
				if (c == ' ') break;
				
				word.insert(0, c);
			}
			
			// Adding space between words
			if ( out.length() > 0 ) {
				out.append(" ");
			}
			
			out.append(word);
			
			
			i -= word.length();
		}
		
		return out.toString();
	}
	
	
	public static void main(String[] args) {
		String s = "Java is easy to learn";
		String reversed = reverseWords(s);
		System.out.println(s + " -> " + reversed);
	}

}
