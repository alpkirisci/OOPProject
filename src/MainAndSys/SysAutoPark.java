package MainAndSys;

import HasA.Car;
import HasA.Location;
import Inheritance.User;

import java.util.HashMap;

public class SysAutoPark {
	private static HashMap<String,Location> locations = new HashMap<String,Location>();
	private static HashMap<Integer,User> users = new HashMap<Integer,User>();
	
	public static void createLocations() {
		int[] nos = {1,2,3,4,5,6,7,8,9};
		String[] sections = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
		int[] floors = {1,2,3};
		Location temp;
		for (int f:floors)
			for(String s:sections)
				for(int no:nos) {
					temp = new Location(no,s,f);
					locations.put(temp.generateKey(), temp);
				}
					
	}
	
	public static void addUser(User user) {
		users.put(user.getId(), user);
	}
	
	public static boolean removeUser(int id) {
		if (!users.containsKey(id))
			return false;
		users.remove(id);
		return true;
	}
	
	public static User login(int id, String password) {
		if (users.containsKey(id))
			return users.get(id);
		return null;

	}
	
	public static String displayAllUsers() {
		String temp = "";
		for (User i:users.values())
			temp+=i.toString();
		return temp;
	}
	
	public static void parkCar(Car car) {
		Location cur;
		for (String loc:locations.keySet()) {
			cur = locations.get(loc); 
			if (cur.getReserved() == false && cur.getPlate().isBlank()) {
				cur.setPlate(car.getPlate());
				car.setLocation(loc);
			}
		}
	}
	
	public static void takeCar() {
		
	}

}
