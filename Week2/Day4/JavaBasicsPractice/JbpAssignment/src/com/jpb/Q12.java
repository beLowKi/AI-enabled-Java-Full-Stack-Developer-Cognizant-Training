package com.jpb;

public class Q12 {

	public static String compStr(String s) {
		
		// Catching single-character strings
		if (s.length() <= 1) {
			return s;
		}
		
		// Compressed output
		StringBuilder comp = new StringBuilder();
		
		for ( int i = 0; i < s.length(); ) {
			
			final char c = s.charAt(i);
			int count = 1;
			
			// Counting how many of the same character appear afterward
			for (int y = i + 1; y < s.length(); y++) {
				final char c2 = s.charAt(y);
				if (c != c2) break;
				count++;
			}
			
			// Adds count to compression and
			// increments 'i' to skip those duplicates
			comp.append(String.valueOf(c) + count);
			i += count;
		}
		
		return comp.toString();
	}
	
	
	public static void main(String[] args) {
		
		String s = "aaabbccccd";
		String comp = compStr(s);
		System.out.println(s + " -> " + comp);
		
		s = "abc";
		comp = compStr(s);
		System.out.println(s + " -> " + comp);
		
		s = "s";
		comp = compStr(s);
		System.out.println(s + " -> " + comp);
	}

}
