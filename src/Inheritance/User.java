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
	static protected int numberOfUsers = 1000;
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



	
	public User(String name, String password, int age, String phoneNumber){
		numberOfUsers++;
		this.id = numberOfUsers;
		this.password = password;
		this.name = name;
		carList = new HashMap<String,Car>();
		this.age = age;
		this.phoneNumber = phoneNumber;
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
	
	

	


	public int getId() {
		return id;
	}

	public static int getNumberOfUsers() {
		return numberOfUsers;
	}
	
	
	
}
