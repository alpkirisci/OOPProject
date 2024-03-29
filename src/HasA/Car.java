
package HasA;

public class Car {
	private String brand;
	private String model;
	private String plate;
	private int year;
	private String status; //Registered, Being Washed, Towed, Parked
	private String location;
	
	public Car() {
		brand = "noBrand";
		model = "noModel";
		plate = "noPlate";
		year = 0;
		status = "noStatus";
		location = "";
	}
	
	public Car(String brand, String model, String plate, int year) {
		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.year = year;
		this.status = "Registered";
		location = "";
	}
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlate() {
		return plate;
	}
	
	public String toString() {
		return "Brand : "+brand+
				"\nModel : " + model +
				"\nPlate : " + plate +
				"\nYear : " + year +
				"\nStatus : " + status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
