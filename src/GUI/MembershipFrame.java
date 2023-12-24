package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class MembershipFrame extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @param user 
	 */
	public MembershipFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton infoBtn = new JButton("My Information");
		infoBtn.setBounds(10, 48, 120, 21);
		contentPane.add(infoBtn);
		
		JButton myCarsBtn = new JButton("My Cars");
		myCarsBtn.setBounds(10, 79, 120, 21);
		contentPane.add(myCarsBtn);
		
		JButton notificationsBtn = new JButton("Notifications");
		notificationsBtn.setBounds(152, 48, 120, 21);
		contentPane.add(notificationsBtn);
		
		JButton balanceBtn = new JButton("Balance");
		balanceBtn.setBounds(150, 79, 120, 21);
		contentPane.add(balanceBtn);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 193, 520, 220);
		contentPane.add(textArea);
		
		JButton buyLocationBtn = new JButton("Buy Location");
		buyLocationBtn.setBounds(10, 110, 123, 21);
		contentPane.add(buyLocationBtn);
		
		JButton myLocationsBtn = new JButton("My Locaitons");
		myLocationsBtn.setBounds(152, 110, 120, 21);
		contentPane.add(myLocationsBtn);
		
		JButton AddBtn = new JButton("Add Car");
		AddBtn.setBounds(364, 48, 113, 21);
		contentPane.add(AddBtn);
		
		JButton WashBtn = new JButton("Wash Car");
		WashBtn.setBounds(364, 79, 113, 21);
		contentPane.add(WashBtn);
		
		JButton reportBtn = new JButton("Report Crash");
		reportBtn.setBounds(364, 110, 113, 21);
		contentPane.add(reportBtn);
	}
}