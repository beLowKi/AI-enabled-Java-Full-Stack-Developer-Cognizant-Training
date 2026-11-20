package com.day5;

// Learning control flow
public class TestControlFlowCondition {

	public static void main(String[] args) {
		int marks = 82;
		int day = 3;
		int age = 25;
		
		if (marks > 60) {
			System.out.println("Pass");
		}
		
		if (age > 18) {
			System.out.println("Eligible for voting");
		} else {
			System.out.println("Ineligible for voting");
		}
		
		if (marks >= 90)
			System.out.println("A");
		else if (marks >= 75)
			System.out.println("B");
		else if (marks >= 60)
			System.out.println("C");
		else
			System.out.println("Fail");
		
		
	}

}
