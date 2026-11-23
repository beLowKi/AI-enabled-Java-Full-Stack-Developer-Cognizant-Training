package com.myinterface;

public class UsePayment {

	public static void main(String[] args) {
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.makePayment(200);
		
		Payment p1 = new CreditCardPayment();
		p1.makePayment(300);
		
		System.out.println("Minimum payment is $" + Payment.minPayment);
	}

}
