package VehicleRentalSystem;

public class Bike extends Vehicle {

	// Default constructor
	public Bike() {
		super();
	}

	/**
	 * @param vehicleNumber
	 * @param model
	 * @param ratePerDay
	 * @param days
	 */
	public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
		super(vehicleNumber, model, ratePerDay, days);
	}
	
	@Override
	public String toString() {
		return "Bike | " + super.toString();
	}
	
	@Override
	public double calculateRent() {
		// Bikes get a 10% discount
		return super.calculateRent() * 0.9;
	}
}
