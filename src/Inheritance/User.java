package Inheritance;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import HasA.Car;
import Interfaces.UserInterface;

public abstract class User implements UserInterface{
	protected int id;
	protected String password;
	protected String name;
	protected ArrayList<Car> carList;
	protected int age;
	protected String phoneNumber;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getDuePayment() {
		return duePayment;
	}

	public void setDuePayment(double duePayment) {
		this.duePayment = duePayment;
	}

	protected String notification;
	protected double duePayment;
	protected boolean banned;
	static protected int numberOfUsers = 1000;
	
	public User(String name, String password, int age, String phoneNumber){
		numberOfUsers++;
		this.id = numberOfUsers;
		this.password = password;
		this.name = name;
		carList = new ArrayList<Car>();
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.duePayment = 0;
		notification = "";
		banned = false;
	}
	
	public void addCar(Car car) {
		carList.add(car);
	}
	
	
	
	public String toString() {
		String cars = ""; 
		for (Car i:carList)
			cars += "Car " + (carList.indexOf(i) + 1) + ")\n" + i.toString() + "\n";
		
		return "Id : " + id +
				"\nName : " + name +
				"\nCars:\n" + cars +
				"\nAge : " + age +
				"\nPhone Number : " + phoneNumber + "\n";
	}
	
	public void addNotification(String notification) {
		this.notification += notification;
	}
	
	public String getNotification() {
		return notification;
	}
	
	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	public void setBanned(boolean banned) {
		this.banned= banned;
	}
	
	public boolean getBanned() {
		return banned;
	}
	
	//MOVE TO SYS
	public void washCar(Car car) {
		if (car.getStatus().equalsIgnoreCase("towed") || banned)
			notification += "\nCar could not be washed\n";
		else {
			notification += "\nCar is being washed";
			duePayment += (double)50;
			car.setStatus("Being Washed");
			car.setTimer(car.getTimer() + 1);
		}
	}
	
	public void reportCrash(String plate) {
		this.duePayment += 200;
		notification += "\nThank you for reporting the crash\nThe other user will be notified.\n";
	}

	public int getId() {
		return id;
	}

	public static int getNumberOfUsers() {
		return numberOfUsers;
	}
	
	
	
}
