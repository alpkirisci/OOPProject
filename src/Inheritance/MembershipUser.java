package Inheritance;
import java.util.ArrayList;

import MainAndSys.SysAutoPark;

public class MembershipUser extends User{
	private double balance;
	private boolean useValet;
	private ArrayList<String> ownedParkingSpaces; // location keys will be contained
	
	

	public MembershipUser(String name, String password, int age, String phoneNumber) {
		super(name, password, age, phoneNumber);
		balance = 0;
		useValet = false;
		ownedParkingSpaces = new ArrayList<String>();
	}


	public void buyParkingSpace() {
		balance -= 500;
		SysAutoPark.reserveLocation(this);
	}
	
	

	public ArrayList<String> getOwnedParkingSpaces() {
		return ownedParkingSpaces;
	}


	public void setUseValet(boolean useValet) {
		this.useValet = useValet;
	}


	public double getBalance() {
		return balance;
	}


	public void addBalance(double balance) {
		this.balance += balance;
	}
	
	public void reduceBalance(double balance) {
		this.balance -= balance;
	}


	@Override
	public double calculatePrice(int hours) {
		if (useValet)
			return 10 * hours + 50;
		return 10 * hours;
	}


	@Override
	public void pay(double payment) {
		balance -= payment;
	}
	public void washCar() {
		balance -= (double)50;


	}

}
