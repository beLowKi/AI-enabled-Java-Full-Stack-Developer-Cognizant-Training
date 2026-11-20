package week2.day5.smartstore.billing;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String employeeId = readNonEmptyString(scanner, "Enter Employee ID: ");
        String employeeName = readNonEmptyString(scanner, "Enter Employee Name: ");
        double basicSalary = readValidSalary(scanner, "Enter Basic Salary: ");

        double hra = calculateHRA(basicSalary);
        double da = calculateDA(basicSalary);
        double grossSalary = basicSalary + hra + da;
        double professionalTax = calculateProfessionalTax(grossSalary);
        double netSalary = grossSalary - professionalTax;

        displayEmployeeDetails(employeeId, employeeName, basicSalary,
                hra, da, grossSalary, professionalTax, netSalary);

        scanner.close();
    }

    // Reads a string and ensures it is not empty or blank.
    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Error: This field cannot be empty.");
            } else {
                return value;
            }
        }
    }

    // Reads and validates a positive basic salary.
    public static double readValidSalary(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
            } else {
                double salary = scanner.nextDouble();
                scanner.nextLine();

                if (Double.isNaN(salary) || Double.isInfinite(salary)) {
                    System.out.println("Error: Salary cannot be NaN or Infinity.");
                } else if (salary < 0) {
                    System.out.println("Error: Salary cannot be negative.");
                } else {
                    return salary;
                }
            }
        }
    }

    // HRA is 20% of the basic salary.
    public static double calculateHRA(double basicSalary) {
        return basicSalary * 0.20;
    }

    // DA is 10% of the basic salary.
    public static double calculateDA(double basicSalary) {
        return basicSalary * 0.10;
    }

    // ₹200 professional tax is deducted only when gross salary exceeds ₹20,000.
    public static double calculateProfessionalTax(double grossSalary) {
        if (grossSalary > 20000) {
            return 200;
        }
        return 0;
    }

    // Displays all employee and salary details.
    public static void displayEmployeeDetails(String employeeId, String employeeName,
                                              double basicSalary, double hra,
                                              double da, double grossSalary,
                                              double professionalTax, double netSalary) {
        System.out.println("\n===== Employee Salary Details =====");
        System.out.printf("Employee ID: %s%n", employeeId);
        System.out.printf("Employee Name: %s%n", employeeName);
        System.out.printf("Basic Salary: ₹%.2f%n", basicSalary);
        System.out.printf("HRA (20%%): ₹%.2f%n", hra);
        System.out.printf("DA (10%%): ₹%.2f%n", da);
        System.out.printf("Gross Salary: ₹%.2f%n", grossSalary);
        System.out.printf("Professional Tax: ₹%.2f%n", professionalTax);
        System.out.printf("Net Salary: ₹%.2f%n", netSalary);
    }
}
