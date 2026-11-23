package VehicleRentalSystem;

import java.util.Scanner;

public class RentalApp {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of vehicles: ");
		final int numVehicles = sc.nextInt();
		sc.nextLine();
		
		// Creating vehicles
		Vehicle[] vehicles = new Vehicle[numVehicles];
		
		for (int i = 0; i < numVehicles; i++) {
			
			final int type;
			final String vehicleNumber;
			final String model;
			final double ratePerDay;
			final int days;
			
			System.out.print("Enter type (1-Car, 2-Bike): ");
			type = sc.nextInt();
			if ( !(type == 1 || type == 2) ) {
				System.err.println("Invalid type: " + type);
				System.exit(1);
			}
			
			sc.nextLine();
			
			System.out.print("Enter Vehicle Number: ");
			vehicleNumber = sc.nextLine();
			
			System.out.print("Enter Model: ");
			model = sc.nextLine();
			
			System.out.print("Enter Rate per Day: ");
			ratePerDay = sc.nextDouble();
			if ( ratePerDay < 0 ) {
				System.err.println("Invalid ratePerDay; cannot be negative");
				System.exit(1);
			}
			
			sc.nextLine();
			
			System.out.print("Enter days: ");
			days = sc.nextInt();
			if ( days < 0 ) {
				System.err.println("Invalid days; cannot be negative");
				System.exit(1);
			}
			
			sc.nextLine();
			
			// Getting insurance per day for cars
			if ( type == 1 ) {
				System.out.print("Enter insurance per day: ");
				final double insurancePerDay = sc.nextDouble();
				vehicles[i] = new Car(vehicleNumber, model, ratePerDay, days, insurancePerDay);
			
			// Creating a bike
			} else {
				vehicles[i] = new Bike(vehicleNumber, model, ratePerDay, days);
			}
		}
		
		// Displaying
		System.out.println("\n--- Rental Details ---");
		
		for (final Vehicle v : vehicles) {
			v.displayDetails();
		}
	}
}
