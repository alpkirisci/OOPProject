package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.StandardUser;
import Inheritance.User;
import MainAndSys.Main;
import MainAndSys.SysAutoPark;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import HasA.Car;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class StandardFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textDue;

	public static JLabel clock;
	private JTextField textField;
	private JTextArea textArea;
	private AddCar addCarF;
	private StandardFrame stanF = this;
	private JComboBox comboBox;
	private Car curCar;
	private int curHour;
	
	private void message(String mes) {
		textArea.setText("\n"+ mes + "\n\n***********************************************************************************\n" + textArea.getText());
		textArea.setCaretPosition(0);
	}
	
	public void fillBox(Car car) {
		comboBox.addItem(car.getPlate());
	}
	
	/**
	 * Create the frame.
	 */
	public StandardFrame(StandardUser user, Login logF) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(167, 32, 146, 19);
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
		textName.setBounds(167, 62, 146, 19);
		contentPane.add(textName);
		textName.setText(user.getName());

		
		textAge = new JTextField();
		textAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setAge(Integer.parseInt(textAge.getText()));
			}
		});
		textAge.setColumns(10);
		textAge.setBounds(167, 95, 146, 19);
		contentPane.add(textAge);
		textAge.setText(String.format("%d", user.getAge()));

		
		
		textPhone = new JTextField();
		textPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setPhoneNumber(textPhone.getText());

			}
		});
		textPhone.setColumns(10);
		textPhone.setBounds(167, 132, 146, 19);
		contentPane.add(textPhone);
		textPhone.setText(user.getPhoneNumber());

		
		
		textDue = new JTextField();
		textDue.setEditable(false);
		textDue.setColumns(10);
		textDue.setBounds(167, 169, 146, 19);
		contentPane.add(textDue);
		textDue.setText(String.format("%.2f", user.getDuePayment()));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(25, 240, 503, 208);
		contentPane.add(scrollPane);
		
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(440, 145, 74, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(368, 146, 70, 15);
		contentPane.add(lblAmount);
		
		
		
		JButton duePaymentBtn = new JButton("Pay");
		duePaymentBtn.setBounds(368, 100, 146, 31);
		duePaymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isBlank())
					message("Please enter an amount.");
				else if (user.getDuePayment() < Double.parseDouble(textField.getText()))
					message("You have tried to pay more than your due payment, please reduce the amount.");
				else {
					user.pay(Double.parseDouble(textField.getText()));
					message("Your payment has been made from your registered card.\nThank you for your patronage.");
					textDue.setText(String.format("%.2f", user.getDuePayment()));
				}
				
			}
		});
		contentPane.add(duePaymentBtn);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(32, 64, 117, 15);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Phone No:");
		lblNewLabel.setBounds(32, 134, 117, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblDebt = new JLabel("Due Payment:");
		lblDebt.setBounds(34, 173, 115, 15);
		contentPane.add(lblDebt);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(32, 97, 117, 15);
		contentPane.add(lblAge);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(32, 32, 117, 15);
		contentPane.add(lblId);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 0, 310, 214);
		contentPane.add(panel);
		

		
		clock = new JLabel("Clock");
		clock.setFont(new Font("Dialog", Font.BOLD, 15));
		clock.setBounds(590, 12, 104, 15);
		contentPane.add(clock);
		
		JButton timeBtn = new JButton("Forward 1 Hour");
		timeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.time = Main.time.plusHours(1);
			}
		});
		timeBtn.setBounds(394, 4, 146, 31);
		contentPane.add(timeBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(356, 88, 172, 86);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cars", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(540, 82, 200, 366);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getCar((String)comboBox.getSelectedItem()) != null)
					message(user.getCar((String)comboBox.getSelectedItem()).toString());
				
			}
		});
		comboBox.setBounds(25, 24, 148, 24);
		panel_2.add(comboBox);
		
		JButton parkBtn = new JButton("Park/Take Car");
		parkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curCar = user.getCar((String)comboBox.getSelectedItem());
				if (curCar != null) {
					if (curCar.getLocation().isBlank()) {
						SysAutoPark.parkCar(curCar);
						curCar.setStatus("Parked at " + curCar.getLocation());
						message(curCar.getStatus());
					}
					
					else {
						curHour = SysAutoPark.takeCar(curCar);
						user.addDuePayment(user.calculatePrice(curHour));
						curCar.setStatus("Registered");
						textDue.setText(String.format("%.2f", user.getDuePayment()));
						message("You have taken your car.");
					}
				}
				else
					message("Please add a car.");
			}
		});
		parkBtn.setBounds(25, 71, 148, 36);
		panel_2.add(parkBtn);
		
		JButton washBtn = new JButton("Wash Car");
		washBtn.setBounds(25, 130, 148, 36);
		panel_2.add(washBtn);
		
		JButton addBtn = new JButton("Add Car");
		addBtn.setBounds(25, 189, 148, 36);
		panel_2.add(addBtn);
		
		JButton btnRemoveCar = new JButton("Remove Car");
		btnRemoveCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.removeCar((String)comboBox.getSelectedItem());
				comboBox.removeItem(comboBox.getSelectedItem());
			}
		});
		btnRemoveCar.setBounds(25, 248, 148, 36);
		panel_2.add(btnRemoveCar);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.setBounds(25, 307, 148, 36);
		panel_2.add(returnBtn);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logF.setVisible(true);
				dispose();
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCarF = new AddCar(user, stanF);
				addCarF.setVisible(true);
			}
		});
		washBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getCar((String)comboBox.getSelectedItem()) != null) {
					user.washCar();
					message("Your car has been washed.");
				}
			}
		});
		


		
		

	}
}