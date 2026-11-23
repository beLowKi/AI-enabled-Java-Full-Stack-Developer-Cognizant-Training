package com.myinterface;

public interface Payment {
	
	public double minPayment = 100.0;
	
	public void makePayment(double amount);
	
	public void pay(double amount);
	
}
