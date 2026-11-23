package VehicleRentalSystem;

abstract public class Vehicle {

	protected String vehicleNumber;
	protected String model;
	protected double ratePerDay;
	protected int days;

	// Default constructor
	public Vehicle() {
	}
	
	@Override
	public String toString() {
		return vehicleNumber + " | " + model + " | Days: " + days;
	}
	
	/**
	 * @param vehicleNumber
	 * @param model
	 * @param ratePerDay
	 * @param days
	 */
	public Vehicle(String vehicleNumber, String model, double ratePerDay, int days) {
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.ratePerDay = ratePerDay;
		this.days = days;
	}
		
	// Returns the rent paid for this vehicle.
	public double calculateRent() {
		return ratePerDay * days;
	}
	
	// Prints Vehicle information
	public void displayDetails() {
		System.out.println(this.toString() + " | Rent: " + this.calculateRent());
	};
}
