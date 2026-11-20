package week2.day5.smartstore.billing;

import java.util.Scanner;

/**
 * BillingApplication
 *
 * Calculates a customer's bill and applies discounts based on the purchase amount.
 *
 * Discount rules:
 * - Total below 1000: No discount
 * - Total from 1000 to 4999: 5% discount
 * - Total from 5000 to 9999: 10% discount
 * - Total of 10000 or more: 15% discount
 */
public class WeekPromptTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        double totalAmount = calculateTotal(price, quantity);
        double discount = calculateDiscount(totalAmount);
        double discountAmount = totalAmount * discount / 100;
        double finalAmount = totalAmount - discountAmount;

        displayBill(customerName, quantity, totalAmount,
                    discount, discountAmount, finalAmount);

        scanner.close();
    }

    /**
     * Calculates the total purchase amount.
     */
    public static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * Determines the discount percentage using if-else statements.
     */
    public static double calculateDiscount(double totalAmount) {
        if (totalAmount >= 10000) {
            return 15;
        } else if (totalAmount >= 5000) {
            return 10;
        } else if (totalAmount >= 1000) {
            return 5;
        } else {
            return 0;
        }
    }

    /**
     * Displays the formatted billing information.
     */
    public static void displayBill(String customerName, int quantity,
                                   double totalAmount, double discount,
                                   double discountAmount, double finalAmount) {
        System.out.println("\n========== Retail Store Bill ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Quantity      : " + quantity);
        System.out.printf("Total Amount  : ₹%.2f%n", totalAmount);
        System.out.printf("Discount      : %.0f%%%n", discount);
        System.out.printf("Discount Value: ₹%.2f%n", discountAmount);
        System.out.printf("Final Amount  : ₹%.2f%n", finalAmount);
        System.out.println("=======================================");
    }
}
