package com.week2.day4;

public class StrinDemo {
	
	public static void main(String[] args) {
		StringBuffer bf = new StringBuffer("Hello");
		
		bf.append(" Java");
		
		System.out.println(bf);
		
		StringBuilder bd = new StringBuilder("Hello");
		
		bd.append(" Java");
		
		System.out.println(bd);
	}

}
