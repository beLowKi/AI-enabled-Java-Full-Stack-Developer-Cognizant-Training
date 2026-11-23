package VehicleRentalSystem;

public class Car extends Vehicle {

	private double insurancePerDay;

	// Default constructor
	public Car() {
		super();
	}

	/**
	 * @param insurancePerDay
	 */
	public Car(double insurancePerDay) {
		super();
		this.insurancePerDay = insurancePerDay;
	}

	/**
	 * @param vehicleNumber
	 * @param model
	 * @param ratePerDay
	 * @param days
	 * @param insurancePerDay
	 */
	public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
		super(vehicleNumber, model, ratePerDay, days);
		this.insurancePerDay = insurancePerDay;
	}
	
	@Override
	public String toString() {
		return "Car | " + super.toString();
	}
	
	@Override
	public double calculateRent() {
		return super.calculateRent() + ( days * insurancePerDay );
	}
}
