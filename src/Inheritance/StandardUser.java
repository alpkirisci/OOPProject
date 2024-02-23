package Inheritance;

import HasA.Car;

public class StandardUser extends User {
	private double duePayment;
	private double totalPayment = 0;
	
//	public upgradeToMembership() {
//		
//	}

	public StandardUser(String name, String password, int age, String phoneNumber) {
	super(name, password, age, phoneNumber);
	}
	
	@Override
	public double calculatePrice(int hours) {
		double price = 30;
		return price + 15 * hours;
	}



	public double getDuePayment() {
		return duePayment;
	}
	
	public void addDuePayment(double add) {
		duePayment += add;
	}

	@Override
	public void pay(double payment) {
		duePayment -= payment;
		
	}

	public void washCar() {
		duePayment += (double)50;


	}
}
