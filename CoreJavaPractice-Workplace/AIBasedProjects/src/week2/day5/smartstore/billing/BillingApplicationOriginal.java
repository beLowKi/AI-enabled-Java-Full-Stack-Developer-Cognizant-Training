package week2.day5.smartstore.billing;

import java.util.Scanner;

public class BillingApplicationOriginal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Accept customer and product details
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();

		System.out.print("Enter product name: ");
		String productName = scanner.nextLine();

		System.out.print("Enter product price: ");
		double productPrice = scanner.nextDouble();

		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		// Calculate the original purchase amount
		double totalAmount = productPrice * quantity;

		// Apply discount based on the purchase amount
		double discountPercentage = 0.0;

		if (totalAmount >= 1000.0 && totalAmount < 5000.0) {
			discountPercentage = 5.0;
		} else if (totalAmount >= 5000.0) {
			discountPercentage = 10.0;
		}

		double discountAmount = totalAmount * discountPercentage / 100.0;
		double finalAmount = totalAmount - discountAmount;

		// Display the billing details
		System.out.println("\n----- SmartStore Bill -----");
		System.out.println("Customer Name: " + customerName);
		System.out.println("Product Name: " + productName);
		System.out.printf("Total Amount: Rs. %.2f%n", totalAmount);
		System.out.printf("Discount: %.2f%%%n", discountPercentage);
		System.out.printf("Discount Amount: Rs. %.2f%n", discountAmount);
		System.out.printf("Final Amount: Rs. %.2f%n", finalAmount);

		scanner.close();
	}
}
