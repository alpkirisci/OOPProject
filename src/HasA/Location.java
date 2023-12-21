package HasA;

import java.time.LocalDateTime;

public class Location {
	private int no;
	private String section;
	private int floor;
	private String plate;
	private LocalDateTime parkTime;
	
	public Location(int no, String section, int floor) {
		super();
		this.no = no;
		this.section = section;
		this.floor = floor;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public LocalDateTime getParkTime() {
		return parkTime;
	}

	public void setParkTime(LocalDateTime parkTime) {
		this.parkTime = parkTime;
	}
	
	public String generateKey() {
		return String.format("%d", floor) + section + String.format("%d", no);
	}

	@Override
	public String toString() {
		return "Location\nno=" + no + "\nsection=" + section + "\nfloor=" + floor + "\nplate=" + plate + "\nparkTime="
				+ parkTime + "\n\n";
	}
	
	
}
