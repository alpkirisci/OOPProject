package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.User;
import GUI.MainFrame;
import GUI.AddFrame;
import MainAndSys.SysAutoPark;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblFeed;

	MainFrame mainF;
	AddFrame addF = new AddFrame(this);
	
	public JLabel getLblFeed() {
		return lblFeed;
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 407, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(50, 59, 88, 15);
		panel.add(lblID);
		
		textField = new JTextField();
		textField.setBounds(156, 57, 211, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 88, 88, 15);
		panel.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 86, 211, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblFeed = new JLabel("");
		lblFeed.setBounds(50, 115, 317, 15);
		panel.add(lblFeed);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isBlank() || textField_1.getText().isBlank())
					lblFeed.setText("Please fill the fields");
				else {
					int id = Integer.parseInt(textField.getText());
					String password = textField_1.getText();
					User user = SysAutoPark.login(id, password);
					if (user == null)
						lblFeed.setText("Wrong id or password");
					else {
						mainF = new MainFrame(user);
						mainF.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		btnEnter.setBounds(50, 161, 117, 25);
		panel.add(btnEnter);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addF.setVisible(true);
				setVisible(false);
				addF.setUserId();
			}
		});
		btnAddUser.setBounds(250, 161, 117, 25);
		panel.add(btnAddUser);
		
		JLabel lblWelcomeToCyberpark = new JLabel("Welcome to CyberPark Autopark");
		lblWelcomeToCyberpark.setBounds(50, 12, 248, 15);
		panel.add(lblWelcomeToCyberpark);
		
	}


}
