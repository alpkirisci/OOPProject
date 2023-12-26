package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.MembershipUser;
import Inheritance.StandardUser;
import Inheritance.User;
import MainAndSys.SysAutoPark;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AddFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public void setUserId() {
		textField.setText(String.format("%d", User.getNumberOfUsers() + 1));
	}
	/**
	 * Create the frame.
	 */
	public AddFrame(Login login) {
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 84, 84, 15);
		contentPane.add(lblPassword);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(37, 121, 70, 15);
		contentPane.add(lblAge);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(37, 159, 115, 15);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(37, 15, 70, 15);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(186, 13, 185, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 48, 185, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 82, 185, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 119, 185, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(186, 157, 185, 19);
		contentPane.add(textField_4);
		
		JRadioButton rdbtnStandard = new JRadioButton("Standard User");
		rdbtnStandard.setSelected(true);
		buttonGroup.add(rdbtnStandard);
		rdbtnStandard.setBounds(37, 196, 149, 23);
		contentPane.add(rdbtnStandard);
		
		JLabel lbl = new JLabel("");
		lbl.setBounds(40, 237, 334, 15);
		contentPane.add(lbl);
		
		JRadioButton rdbtnMembershipUser = new JRadioButton("Membership User");
		buttonGroup.add(rdbtnMembershipUser);
		rdbtnMembershipUser.setBounds(222, 196, 149, 23);
		contentPane.add(rdbtnMembershipUser);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty() ||textField_2.getText().isEmpty() ||textField_3.getText().isEmpty() ||textField_4.getText().isEmpty())
					lbl.setText("Please fill the fields");
				else {
					User temp;
					String name = textField_1.getText();
					String password = textField_2.getText();
					int age = Integer.parseInt(textField_3.getText());
					String phoneNumber = textField_4.getText();
					if (rdbtnMembershipUser.isSelected())
						temp = new MembershipUser(name, password, age, phoneNumber);
					else
						temp = new StandardUser(name, password, age, phoneNumber);
					SysAutoPark.addUser(temp);
					login.getLblFeed().setText("User has been added");
					dispose();
					login.setVisible(true);
				}
					
			}
		});
		btnAddUser.setBounds(47, 275, 117, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(270, 275, 117, 25);
		contentPane.add(btnCancel);
		
		JLabel lblNameSurname = new JLabel("Name Surname:");
		lblNameSurname.setBounds(37, 50, 127, 15);
		contentPane.add(lblNameSurname);
		

	}
}
