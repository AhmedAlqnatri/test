package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class NewUser extends javax.swing.JFrame {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName, txtAddress , txtPassport;
	private JTextField txtEmail;
	BufferedImage image;
	JFrame frame;
	private String[] genders = new String[] { "Male", "Female" };
	// private JComboBox gender;

	public void initComponents() {
		frame = new JFrame();

		try {
			image = ImageIO.read(new File("./fei_800.png"));
			frame.setIconImage(image);
			//
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setTitle("E-visa New User");
		frame.getContentPane().setLayout(null);

		//

		// Header Title
		JLabel hRegister = new JLabel("Register Data");
		hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(121, 11, 132, 20);
		frame.getContentPane().add(hRegister);

		// *** Header ***//
		JLabel hUsername = new JLabel("First Name :");
		hUsername.setBounds(78, 52, 89, 14);
		frame.getContentPane().add(hUsername);

		JLabel hName = new JLabel("Last Name :");
		hName.setBounds(78, 84, 89, 14);

		frame.getContentPane().add(hName);

		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(77, 113, 130, 14);
		frame.getContentPane().add(hConfirmPassword);

		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(78, 148, 89, 14);
		frame.getContentPane().add(hPassword);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 176, 89, 14);
		frame.getContentPane().add(hEmail);

		JLabel hGender = new JLabel("gender :");
		hGender.setBounds(80, 206, 89, 14);
		frame.getContentPane().add(hGender);

		JLabel hAdress = new JLabel("Address :");
		hAdress.setBounds(80, 236, 89, 14);
		frame.getContentPane().add(hAdress);

		JLabel hPassNo = new JLabel("Passport No. :");
		hPassNo.setBounds(80, 263, 89, 14);
		frame.getContentPane().add(hPassNo);

		JLabel hDateBirth = new JLabel("DateBirth :");
		hDateBirth.setBounds(80, 290, 89, 14);
		frame.getContentPane().add(hDateBirth);

		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 47, 99, 20);
		frame.getContentPane().add(txtUsername);

		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 77, 102, 20);
		frame.getContentPane().add(txtPassword);

		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 112, 102, 20);
		frame.getContentPane().add(txtConfirmPassword);

		// Name
		txtName = new JTextField("");
		txtName.setBounds(217, 140, 176, 20);
		frame.getContentPane().add(txtName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 172, 176, 20);
		frame.getContentPane().add(txtEmail);

		// gender
		JComboBox<String> gender = new JComboBox<>(genders);
		gender.setBounds(217, 200, 176, 20);
		frame.getContentPane().add(gender);

		// Address
		txtAddress = new JTextField("");
		txtAddress.setBounds(217, 230, 176, 20);
		frame.getContentPane().add(txtAddress);

		// Address
		txtPassport = new JTextField("");
		txtPassport.setBounds(217, 260, 176, 20);
		frame.getContentPane().add(txtPassport);
		// Address
		txtAddress = new JTextField("");
		txtAddress.setBounds(217, 230, 176, 20);
		frame.getContentPane().add(txtAddress);
		// Save Button
		JButton btnSave = new JButton("Save");
		frame.setVisible(true);

	}

}
