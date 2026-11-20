
This file contains the prompts sent to GitHub Copilot during this lab.
The class(es) and method(s) involved will be listed next to each prompt.

## Exercise 2: Generate Java Code with Copilot

### Prompt

You are an experienced Java developer.

Develop a simple Java billing application for a retail store named SmartStore.
The class must be named BillingApplication in package week2.day5.smartstore.billing.

Requirements:
1. Accept customer name, product name, product price and quantity.
2. Calculate the total purchase amount (price x quantity).
3. Apply a 5% discount if the purchase amount is between Rs. 1,000 and Rs. 4,999.
4. Apply a 10% discount if the purchase amount is Rs. 5,000 or above.
5. No discount below Rs. 1,000.
6. Display customer details, total amount, discount percentage, discount amount
   and final amount, with amounts shown to 2 decimal places.

Constraints:
- Use Java fundamentals only: variables, data types, if-else and arithmetic operators.
- Use Scanner for user input.
- Do not use advanced Java features.
- Write readable, beginner-friendly code.
- Include comments explaining important logic.

Generate a complete executable Java program with a main() method.

### Requirements Check

| Requirement                                        | Met? (Yes / No) | Where in the code?   |
| -------------------------------------------------- | --------------- | -------------------- |
| Reads customer name, product, price, quantity      | Yes             | Lines 11-21          |
| Total = price × quantity                           | Yes             | Line 24              |
| 0% below ₹1,000                                    | Yes             | Line 29              |
| 5% from ₹1,000 to ₹4,999                           | Yes             | Lines 29-30          |
| 10% at ₹5,000 and above                            | Yes             | Lines 31-32          |
| Shows discount %, discount amount and final amount | Yes             | Lines 43-45          |
| Comments explain the discount logic                | Yes             | Lines 10, 23, 26, 38 |

## Exercise 3: Explain the generated code with AI

### Prompt

**Act as a Java programming instructor.  
  
Explain the following code. 
  
For each important statement:  
1. Explain what it does.  
2. Explain why it is required.  
3. Identify the Java concept being used.  
4. Give a simple example where applicable.  
  
Pay special attention to:  
- Scanner and user input  
- Variables and data types  
- Arithmetic calculations  
- If-else conditions  
- Discount calculation  
- Output statements  
  
Explain everything in beginner-friendly language. Here is the code:

~~~java
package week2.day5.smartstore.billing;

import java.util.Scanner;

public class BillingApplication {

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
~~~

### Follow-up Question

What would happen if the user inputs multiple numbers when prompted? If, after being asked to give a price, they entered "1.99 9.99", how, if at all, does the program handle the extra value?

### Code understanding worksheet

#### Which variables does the program use, and what data type is each?


| Variable           | Type    |
| ------------------ | ------- |
| scanner            | Scanner |
| customerName       | String  |
| productName        | String  |
| productPrice       | double  |
| quantity           | int     |
| totalAmount        | double  |
| discountPercentage | double  |
| discountAmount     | double  |
| finalAmount        | double  |

#### Which if-else conditions decide the discount? Write them out.

~~~java
if (totalAmount >= 1000.0 && totalAmount < 5000.0) {
	discountPercentage = 5.0;
} else if (totalAmount >= 5000.0) {
	discountPercentage = 10.0;
}
~~~

#### How is the discount amount calculated?

totalAmount is multiplied by a percentage calculated from discountPercentage.

#### How is the final amount calculated?

discountAmount is subtracted from totalAmount.

#### Which line would you change if the 10% threshold moved to ₹6,000?

Line 34

~~~java
... 
} else if (totalAmount >= 5000.0) {
...
~~~

Would become

~~~java
... 
} else if (totalAmount >= 6000.0) {
...
~~~

## Exercise 4: Refactor the code with AI

### Before

----- SmartStore Bill -----
Customer Name: Rahul
Product Name: Laptop Bag
Total Amount: Rs. 6000.00
Discount: 10.00%
Discount Amount: Rs. 600.00
Final Amount: Rs. 5400.00

### Refactor Prompt

**Review the existing SmartStore billing application.  
  
Refactor the code using these requirements:  
1. Move discount calculation into a separate method:  
  public static double calculateDiscount(double totalAmount)  
  It must return the discount amount in rupees (not the percentage).  
2. Move bill printing into a separate method named printBill().  
3. Use meaningful variable and method names.  
4. Remove unnecessary code.  
5. Improve readability and maintainability.  
6. Do not change the existing business rules or the output format.  
7. Do not introduce advanced Java concepts.  
  
Explain the changes you made and why they improve the code.

### After

----- SmartStore Bill -----
Customer Name: Rahul
Product Name: Laptop Bag
Total Amount: Rs. 6000.00
Discount: 10.00%
Discount Amount: Rs. 600.00
Final Amount: Rs. 5400.00

### Refactoring review

#### Which new methods were created, and what does each do?

calculateDiscount(double totalAmount) -> returns a double representing the discount matching the given total amount.

printBill() -> prints bill information

#### What parameters and return type does calculateDiscount() have?

Return type: double
Parameters: ( double totalAmount )

#### Did any discount threshold or comparison (<, >=) change?

No, everything is the same

#### Is the before output identical to the after output?

Yes

#### Which change improves readability the most, and why?

Adding "printBill" removes all the print statements from "main" which makes its function clearer.

## Example 5: Generate test scenarios with AI

### Prompt

Act as a Java software tester.

Analyze the SmartStore billing application and generate test cases.

Include:
1. Purchase amount below Rs. 1,000.
2. Purchase amount exactly Rs. 1,000.
3. Purchase amount Rs. 4,999.
4. Purchase amount exactly Rs. 5,000.
5. Purchase amount above Rs. 5,000.
6. Quantity greater than one.

For each test case provide:
- Test input (price and quantity)
- Expected discount percentage
- Expected discount amount
- Expected final amount

Identify any additional edge cases that should be tested.

### Test cases

| Test case                 | Test input (price × quantity) | Purchase amount | Expected discount percentage | Expected discount amount | Expected final amount | Actual final (₹) | Pass? (Y/N) |
| ------------------------- | ----------------------------: | --------------: | ---------------------------: | -----------------------: | --------------------: | :--------------: | :---------: |
| Below Rs. 1,000           |                   Rs. 100 × 9 |      Rs. 900.00 |                           0% |                 Rs. 0.00 |            Rs. 900.00 |       900        |      Y      |
| Exactly Rs. 1,000         |                   Rs. 500 × 2 |    Rs. 1,000.00 |                           5% |                Rs. 50.00 |            Rs. 950.00 |       950        |      Y      |
| Rs. 4,999                 |                 Rs. 4,999 × 1 |    Rs. 4,999.00 |                           5% |               Rs. 249.95 |          Rs. 4,749.05 |     4749.05      |      Y      |
| Exactly Rs. 5,000         |                 Rs. 1,250 × 4 |    Rs. 5,000.00 |                          10% |               Rs. 500.00 |          Rs. 4,500.00 |       4500       |      Y      |
| Above Rs. 5,000           |                 Rs. 2,000 × 3 |    Rs. 6,000.00 |                          10% |               Rs. 600.00 |          Rs. 5,400.00 |       5400       |      Y      |
| Quantity greater than one |                   Rs. 300 × 4 |    Rs. 1,200.00 |                           5% |                Rs. 60.00 |          Rs. 1,140.00 |       1140       |      Y      |

### Edge Cases

| Test case                   |      Test input | Expected discount percentage | Expected discount amount | Expected final amount | Actual final (₹) | Pass? (Y/N) |
| --------------------------- | --------------: | ---------------------------: | -----------------------: | --------------------: | :--------------: | :---------: |
| Amount just below Rs. 1,000 |  Rs. 999.99 × 1 |                           0% |                 Rs. 0.00 |            Rs. 999.99 |      999.99      |      Y      |
| Amount just above Rs. 1,000 |  Rs. 250.50 × 4 |                           5% |                Rs. 50.10 |          Rs. 951.90\* |      951.9       |      Y      |
| Amount just below Rs. 5,000 | Rs. 4999.99 × 1 |                           5% |             Rs. 249.9995 |      Rs. 4,749.9905\* |     4749.99      |      Y      |
| Amount just above Rs. 5,000 | Rs. 5000.01 × 1 |                          10% |              Rs. 500.001 |          Rs. 4500.009 |     4500.01      |      Y      |
| Zero price or quantity      |      Rs. 0 × 10 |                           0% |                 Rs. 0.00 |              Rs. 0.00 |       0.00       |      Y      |
| Negative price or quantity  |    Rs. -100 × 2 |                Invalid input |            Invalid input |         Invalid input |       -200       |      N      |
| Invalid numeric input       |   abc for price |                Invalid input |            Invalid input |         Invalid input | Exception Thrown |      N      |

\* Model gave incorrect number here for some reason. I hand-calculated the expected values and checked against that instead. I guess GitHub Copilot isn't great at math.

## Exercise 6: Generate JUnit 5 tests with AI

### Prompt

I have a Java billing application with this method:

public static double calculateDiscount(double totalAmount)

It returns the discount amount in rupees.
Generate beginner-friendly JUnit 5 test methods for it.

Test the following:
- Amount below Rs. 1,000 (800)
- Amount exactly Rs. 1,000
- Amount Rs. 4,999
- Amount exactly Rs. 5,000
- Amount above Rs. 5,000 (7,000)

Use assertEquals(expected, actual, 0.001) for double values.
Explain each test case and how the assertion verifies the expected result.
Do not modify the business requirements.

## Test Results

| Test  | Expected discount (₹) | Pass / fail | If failed: cause and fix |
| ----- | --------------------- | ----------- | ------------------------ |
| 800   | 0.00                  | Pass        |                          |
| 1,000 | 50.00                 | Pass        |                          |
| 4,999 | 249.95                | Pass        |                          |
| 5,000 | 500.00                | Pass        |                          |
| 7,000 | 700.00                | Pass        |                          |

## Exercise 7: Responsible AI review and prompt engineering

### Part A - Review the AI-generated code

#### Prompt

Review the SmartStore billing application.

Identify:
1. Possible logical errors.
2. Incorrect discount calculations.
3. Potential invalid user inputs.
4. Possible security or reliability issues.
5. Improvements required before deploying this application.

Explain which suggestions are critical and which are optional.

#### Feedback Review

|             Finding from Copilot              | Critical or optional | Do you agree? Why?                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| :-------------------------------------------: | :------------------: | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|         Negative values are accepted          |       Critical       | Yes, an edge case for negative values sent to product price or quantity revealed that the program calculates as normal even when given negative numbers. This would be a critical flaw in a real app.                                                                                                                                                                                                                                                                                                                                                                                     |
|        Decimal quantity is not allowed        |       Critical       | No. This statement confuses me. The model stated:<br><br>Decimal quantity is not allowed. The quantity is stored as int, which is appropriate for ordinary item counts and consistent with the input prompt.<br><br>It affirms that an int quantity is correct for the app in its own response but still labeled it as a critical logical error. I believe the intent was to address whether "potential" errors were present, but the inclusion is demonstrably excess and confusing. The prompt did instruct to give possible errors, but solved ones like these should not be included. |
|          Scanner and input mismatch           |       Critical       | Yes, copilot correctly found that string inputs to produce price or quantity will throw an exception and crash the program.                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
|           Duplicate discount logic            |       Critical       | Slight No. The code to calculate discount percentage is present in both calculateDiscount (to find amount to subtract) and printBill (to display said percentage), which is inefficient, but it isn't a critical issue. The program's main functions aren't effected.                                                                                                                                                                                                                                                                                                                     |
| Different rounding in calculations and output |       Optional       | No. Calculated values aren't rounded to 2 decimal points like the output, but this allows calculations to be as precise as possible while simplifying print statements.                                                                                                                                                                                                                                                                                                                                                                                                                   |
|       Zero quantity or price is allowed       |       Optional       | Yes, price and/or quantity of 0 makes little business sense, but, assuming they're accurate to the product, there's no reason to change that base on current software requirements                                                                                                                                                                                                                                                                                                                                                                                                        |
|                NaN or infinity                |       Optional       | NO. This is an issue, but it's a critical one. Entering "NaN" or "Infinity" to product price breaks future calculations, leading to unexpected behavior like a final amount of infinity.                                                                                                                                                                                                                                                                                                                                                                                                  |
|               double precision                |       Optional       | Yes, copilot recommended using BigDecimal for a billing system like this program for added precision, and I agree that it would be the safer option for production software.                                                                                                                                                                                                                                                                                                                                                                                                              |
|              Blank string input               |       Optional       | Yes. Copilot said the problem of empty strings being treated as valid input is optional so long as business operations don't rely on non-empty product and customer names. I think it makes sense to base the priority of this issue on business requirements.                                                                                                                                                                                                                                                                                                                            |
|            Misshapen string input             |       Optional       | Yes. String inputs aren't normalized, so unexpected whitespace, lengths, and characters may cause customer and product names to be store in an unexpected way. Again, if this wouldn't match business requirements, then I'd say it's an issue worth fixing.                                                                                                                                                                                                                                                                                                                              |

### Part B - Prompt engineering: the R-T-C-C-O framework

#### Test Weak Prompt

Write Java billing code.

#### Test Stronger Prompt

Act as an experienced Java developer. Develop a billing application for a retail store using Java fundamentals. Accept customer name, product price and quantity. Calculate the total and apply discounts based on purchase amount. Use if-else statements and methods. Provide executable code with comments and sample output.

#### Comparison

Copilot actually refused to generate code using the first prompt. I asked a couple times and got responses like this:

Please clarify what billing behavior you need, for example:

- Read the billable items and calculate totals
- Apply a discount or tax
- Refactored implementation of an existing class
- Console or Swing/JavaFX interface
- Return JSON or connect to a database

As for the better prompt, it actually generated the full, working implementation (O) with commented methods (T). After testing, it's eerily similar to the the BillingApplication it made before--even after starting a new chat--and still has some of the same bugs and errors like not handling empty strings or negative numeric values (R).

## Final challenge: Employee Salary Calculator

### Prompt

Act as a Java developer. Create an employee salary calculator for a retail store following these instructions:

=== Business Requirements ===
1. Accept employee ID, employee name and basic salary.
2. Calculate HRA (House Rent Allowance) as 20% of basic salary.
3. Calculate DA (Dearness Allowance) as 10% of basic salary.
4. Calculate gross salary: basic + HRA + DA.
5. Deduct professional tax of ₹200 if gross salary is above ₹20,000.
6. Display the employee details and net salary.

=== Constraints === 
1. Use beginner-friendly Java fundamentals; no advanced concepts
2. Implement strong input validations; e.g., checking if strings are empty, numbers are negative, or doubles are NaN, or Infinity
3. Utilize control-flow statements (if-else) and methods to keep code readable and efficient
4. Include comments explaining important operations and methods

Provide a single file of executable Java code.

### Test Results

|  #  |    Basic (₹)     |  HRA (₹)  |  DA (₹)  | Gross (₹) | Tax (₹) | Expected net (₹) | Actual net (₹) | Pass? (Y/N) |
| :-: | :--------------: | :-------: | :------: | :-------: | :-----: | :--------------: | :------------: | :---------: |
|  1  |      10,000      | 2,000.00  | 1,000.00 | 13,000.00 |  0.00   |    13,000.00     |   13,000.00    |      Y      |
|  2  |      15,000      | 3,000.00  | 1,500.00 | 19,500.00 |  0.00   |    19,500.00     |   19,500.00    |      Y      |
|  3  |      16,000      | 3,200.00  | 1,600.00 | 20,800.00 | 200.00  |    20,600.00     |   20,600.00    |      Y      |
|  4  |      50,000      | 10,000.00 | 5,000.00 | 65,000.00 | 200.00  |    64,800.00     |    64800.00    |      Y      |
|  5  | 15,384.6153846\* | 3,076.92  | 1,538.46 | 20,000.00 |  0.00   |    20,000.00     |   20,000.00    |             |

\* I know Rupees don't have more than 2 decimal places, but in order for the gross salary to be calculated as exactly 20,000, and not 20,000.01, I used extra precision.