package com.jpb;

public class Q8 {

	public static String removeDuplicates(String s) {
		
		StringBuilder out = new StringBuilder("");
		
		for (final char c : s.toCharArray()) {			
			if (out.indexOf(String.valueOf(c)) != -1) continue;
			out.append(c);
		}
		
		return out.toString();
	}
	
	
	public static void main(String[] args) {
		String s = "programming";
		System.out.println(s + " -> " + removeDuplicates(s));
	}

}
