package Inheritance;

public class StandardUser extends User {
	private double duePayment;
	private String lastLogin;
	private double totalPayment = 0;
	
//	public upgradeToMembership() {
//		
//	}

	public StandardUser(String name, String password, int age, String phoneNumber) {
	super(name, password, age, phoneNumber);
	}
	
	@Override
	public double calculatePrice(double price, int hours) {
		
		return price * hours;
	}



	@Override
	public void pay(double payment) {
		duePayment -= payment;
		
	}

	@Override
	public void banCondition() {
		if(duePayment < -200)
			super.banned = true;
	}
}
