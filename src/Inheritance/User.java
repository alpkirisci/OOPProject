package Inheritance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import HasA.Car;
import Interfaces.UserInterface;

public abstract class User implements UserInterface{
	protected int id;
	protected String password;
	protected String name;
	protected HashMap<String,Car> carList;
	protected int age;
	protected String phoneNumber;
	public String getName() {
		return name;
	}
	
	public void removeCar(String plate) {
		carList.remove(plate);
	}
	
	public Car getCar(String plate) {
		return carList.get(plate);
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
		carList = new HashMap<String,Car>();
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.duePayment = 0;
		notification = "";
		banned = false;
	}
	
	public void addCar(Car car) {
		carList.put(car.getPlate(), car);
	}
	
	public String displayCars() {
		String cars = "";
		int n = 1;
		for (String i:carList.keySet()) {
			cars += "Car " + n + ")\n" + carList.get(i).toString() + "\n";
		}
		return cars;
	}
	
	
	public String toString() {
		return "Id : " + id +
				"\nName : " + name +
				"\nCars:\n" + displayCars() +
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
