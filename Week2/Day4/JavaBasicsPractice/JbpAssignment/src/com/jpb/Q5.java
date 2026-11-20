package com.jpb;

public class Q5 {
	
	public static int charCount(String s, char c) {
		int count = 0;
		
		for (final char c2 : s.toCharArray()) {
			if (c == c2) count++;
		}
		
		return count;
	}
	
	
	public static boolean isAnagram(String s1, String s2) {
		
		char[] charsSeen = {};
		
		for (final char c : s1.toCharArray()) {
			boolean seen = false;
			
			for (final char c2 : charsSeen) {
				if (c == c2) {
					seen = true;
					break;
				}
			}
			
			if (seen) break;
			
			final int s1Count = charCount(s1, c);
			final int s2Count = charCount(s2, c);
			if (s1Count != s2Count) return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "silent";
		System.out.println(s1 + " and " + s2 + " are anagrams: " + isAnagram(s1, s2));
		
		String s3 = "hello";
		String s4 = "world";
		System.out.println(s3 + " and " + s4 + " are anagrams: " + isAnagram(s3, s4));
	}

}
