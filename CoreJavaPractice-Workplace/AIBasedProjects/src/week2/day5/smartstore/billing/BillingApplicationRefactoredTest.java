package week2.day5.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BillingApplicationRefactoredTest {

	@Test
	void testDiscountBelow1000() {
		double result = BillingApplicationRefactored.calculateDiscount(800);

		assertEquals(0.0, result, 0.001);
	}

	@Test
	void testDiscountAt1000() {
		double result = BillingApplicationRefactored.calculateDiscount(1000);

		assertEquals(50.0, result, 0.001);
	}

	@Test
	void testDiscountFor4999() {
		double result = BillingApplicationRefactored.calculateDiscount(4999);

		assertEquals(249.95, result, 0.001);
	}

	@Test
	void testDiscountAt5000() {
		double result = BillingApplicationRefactored.calculateDiscount(5000);

		assertEquals(500.0, result, 0.001);
	}

	@Test
	void testDiscountAbove5000() {
		double result = BillingApplicationRefactored.calculateDiscount(7000);

		assertEquals(700.0, result, 0.001);
	}


}
