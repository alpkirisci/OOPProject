package MainAndSys;
import java.time.LocalDateTime;

import GUI.Login;

public class Main {
	public static LocalDateTime time;

	public static void main(String[] args) {
		time = LocalDateTime.now();
		Login login = new Login();
		login.setVisible(true);
	}
}
