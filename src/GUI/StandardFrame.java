package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class StandardFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textDue;


	/**
	 * Create the frame.
	 */
	public StandardFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton carsBtn = new JButton("My Cars");
		carsBtn.setBounds(610, 12, 146, 47);
		contentPane.add(carsBtn);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.setBounds(610, 314, 146, 47);
		contentPane.add(returnBtn);
		
		JButton duePaymentBtn = new JButton("Pay Debt");
		duePaymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		duePaymentBtn.setBounds(382, 141, 146, 31);
		contentPane.add(duePaymentBtn);
		
		JButton addBtn = new JButton("Add Car");
		addBtn.setBounds(610, 163, 146, 47);
		contentPane.add(addBtn);
		
		JButton washBtn = new JButton("Wash Car");
		washBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		washBtn.setBounds(610, 85, 146, 47);
		contentPane.add(washBtn);
		
		JButton reportBtn = new JButton("Report Crash");
		reportBtn.setBounds(382, 93, 146, 31);
		contentPane.add(reportBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 574, 187);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 44, 117, 15);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Phone No:");
		lblNewLabel.setBounds(10, 114, 117, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblDebt = new JLabel("Due Payment:");
		lblDebt.setBounds(12, 153, 115, 15);
		contentPane.add(lblDebt);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(382, 9, 146, 21);
		contentPane.add(comboBox);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 77, 117, 15);
		contentPane.add(lblAge);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 12, 117, 15);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(145, 12, 146, 19);
		contentPane.add(textId);
		textId.setColumns(10);
		textId.setText(String.format("%d", user.getId()));
		
		textName = new JTextField();
		textName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setName(textName.getText());
			}
		});
		textName.setColumns(10);
		textName.setBounds(145, 42, 146, 19);
		contentPane.add(textName);
		textName.setText(user.getName());

		
		textAge = new JTextField();
		textAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setAge(Integer.parseInt(textAge.getText()));
			}
		});
		textAge.setColumns(10);
		textAge.setBounds(145, 75, 146, 19);
		contentPane.add(textAge);
		textAge.setText(String.format("%d", user.getAge()));

		
		
		textPhone = new JTextField();
		textPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setPhoneNumber(textPhone.getText());

			}
		});
		textPhone.setColumns(10);
		textPhone.setBounds(145, 112, 146, 19);
		contentPane.add(textPhone);
		textPhone.setText(user.getPhoneNumber());

		
		
		textDue = new JTextField();
		textDue.setEditable(false);
		textDue.setColumns(10);
		textDue.setBounds(145, 149, 146, 19);
		contentPane.add(textDue);
		textDue.setText(String.format("%.2f", user.getDuePayment()));
		
		JButton notificationBtn = new JButton("Notifications");
		notificationBtn.setBounds(382, 44, 146, 31);
		contentPane.add(notificationBtn);
		
		JButton btnRemoveCar = new JButton("Remove Car");
		btnRemoveCar.setBounds(610, 236, 146, 47);
		contentPane.add(btnRemoveCar);

	}
}