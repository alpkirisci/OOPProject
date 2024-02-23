package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasA.Car;
import Inheritance.User;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	StandardFrame stanF = null;
	MembershipFrame memF = null;
	
	/**
	 * Create the frame.
	 */
	public AddCar(User user, Object obj) {
		setTitle("Add Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(37, 84, 84, 15);
		contentPane.add(lblModel);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(37, 121, 70, 15);
		contentPane.add(lblYear);
		
		JLabel lblPlate = new JLabel("Plate:");
		lblPlate.setBounds(37, 159, 115, 15);
		contentPane.add(lblPlate);
		
		JLabel lblId = new JLabel("User ID:");
		lblId.setBounds(37, 15, 70, 15);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(186, 13, 185, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(user.getId() + "");
		
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
		
		JLabel lbl = new JLabel("");
		lbl.setBounds(37, 196, 334, 15);
		contentPane.add(lbl);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty() ||textField_2.getText().isEmpty() ||textField_3.getText().isEmpty() ||textField_4.getText().isEmpty())
					lbl.setText("Please fill the fields");
				else {
					Car temp;
					String brand = textField_1.getText();
					String model = textField_2.getText();
					int year = Integer.parseInt(textField_3.getText());
					String plate = textField_4.getText();
					temp = new Car(brand, model, plate, year);
					user.addCar(temp);
					dispose();
					if (obj instanceof StandardFrame) {
						stanF = (StandardFrame) obj;
						stanF.fillBox(temp);
					}
					else if (obj instanceof MembershipFrame) {
						memF = (MembershipFrame) obj;
						memF.fillBox(temp);
					}
					
					
				}
					
			}
		});
		btnAddCar.setBounds(35, 226, 117, 25);
		contentPane.add(btnAddCar);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(254, 226, 117, 25);
		contentPane.add(btnCancel);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(37, 50, 127, 15);
		contentPane.add(lblBrand);
		

	}
}
