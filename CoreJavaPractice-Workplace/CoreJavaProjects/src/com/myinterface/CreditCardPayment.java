package com.myinterface;

public class CreditCardPayment implements Payment {
	
	public void makePayment(double amount) {
		System.out.println("Made a credict card payment of $" + amount);
	}
	
}
