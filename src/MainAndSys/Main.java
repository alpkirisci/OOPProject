package MainAndSys;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.Timer;

import GUI.Login;

public class Main {
	public static LocalDateTime time;


	public static void main(String[] args) {
		time = LocalDateTime.now();
		Login login = new Login();
		login.setVisible(true);
		

	}
}
