package Inheritance;
import java.util.ArrayList;

public class MembershipUser extends User{
	private double balance = 0;
	private boolean useValet;
	private ArrayList<String> ownedParkingSpaces; // location keys will be contained
	
	

	public MembershipUser(String name, String password, int age, int phoneNumber) {
		super(name, password, age, phoneNumber);
	}


	public void buyParkingSpace() {
		balance -= 500;
	}
	
	

	@Override
	public double calculatePrice(double price, int hours) {
		if (useValet)
			return price * hours + 50;
		return price * hours;
	}


	@Override
	public void pay(double payment) {
		balance -= payment;
	}


	@Override
	public void banCondition() {
		if (balance < -500)
			super.banned = true;
	}
}
