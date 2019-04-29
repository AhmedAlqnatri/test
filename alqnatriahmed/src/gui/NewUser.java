package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import classes.Data;
import classes.User;
import classes.UserName;
import classes.Validation;
import gui.MainFrame.NewUserlListener;

import javax.imageio.ImageIO;

public class NewUser extends javax.swing.JFrame {

	private JTextField txtFname, txtLname, txtUsername1;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtAddress, txtPassport, txtDateOfIssue, txtDateOfexpired;
	private JTextField txtEmail;
	BufferedImage image;
	JFrame frame;
	JComboBox<String> gender;
	JComboBox<String> country;
	//Data data = new Data();

	private String[] genders = new String[] { "Male", "Female" };
	// private JComboBox gender;

	public void initComponents() {
		frame = new JFrame();
		//
		try {
			image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 500);
		frame.setTitle("E-visa New User");
		frame.getContentPane().setLayout(null);

		// User Register info
		JLabel hRegister = new JLabel("User Register info");
		hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(500, 11, 132, 20);
		frame.getContentPane().add(hRegister);

		// UserName
		JLabel hUsername = new JLabel("UserName :");
		hUsername.setBounds(500, 54, 89, 14);
		frame.getContentPane().add(hUsername);
		// CustomerID
		txtUsername1 = new JTextField("");
		txtUsername1.setBounds(620, 54, 102, 20);
		frame.getContentPane().add(txtUsername1);

		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(500, 82, 89, 14);
		frame.getContentPane().add(hPassword);
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(620, 77, 102, 20);
		frame.getContentPane().add(txtPassword);

		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(500, 110, 160, 14);
		frame.getContentPane().add(hConfirmPassword);
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(620, 110, 102, 20);
		frame.getContentPane().add(txtConfirmPassword);

		// End User Info

		// User Data
		JLabel huserdata = new JLabel("User Data");
		huserdata.setFont(new Font("Tahoma", Font.BOLD, 13));
		huserdata.setHorizontalAlignment(SwingConstants.CENTER);
		huserdata.setBounds(121, 11, 132, 20);
		frame.getContentPane().add(huserdata);

		// *** Header ***//
		JLabel hFName = new JLabel("First Name :");
		hFName.setBounds(78, 52, 89, 14);
		frame.getContentPane().add(hFName);

		JLabel hLName = new JLabel("Last Name :");
		hLName.setBounds(78, 84, 89, 14);
		frame.getContentPane().add(hLName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 112, 89, 14);
		frame.getContentPane().add(hEmail);

		JLabel hGender = new JLabel("gender :");
		hGender.setBounds(80, 142, 89, 14);
		frame.getContentPane().add(hGender);

		JLabel hAdress = new JLabel("Address :");
		hAdress.setBounds(80, 172, 89, 14);
		frame.getContentPane().add(hAdress);

		JLabel hPassNo = new JLabel("Passport No. :");
		hPassNo.setBounds(80, 202, 89, 14);
		frame.getContentPane().add(hPassNo);

		JLabel hDateofissue = new JLabel("Date of issue :");
		hDateofissue.setBounds(80, 232, 89, 14);
		frame.getContentPane().add(hDateofissue);

		JLabel hDateofexpired = new JLabel("Date of expired :");
		hDateofexpired.setBounds(80, 262, 92, 14);
		frame.getContentPane().add(hDateofexpired);

		JLabel hCountry = new JLabel("Country :");
		hCountry.setBounds(80, 292, 92, 14);
		frame.getContentPane().add(hCountry);

		// FirstName
		txtFname = new JTextField("");
		txtFname.setBounds(217, 47, 176, 20);
		frame.getContentPane().add(txtFname);

		// LastName
		txtLname = new JTextField("");
		txtLname.setBounds(217, 78, 176, 20);
		frame.getContentPane().add(txtLname);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 110, 176, 20);
		frame.getContentPane().add(txtEmail);

		// gender
		gender = new JComboBox<>(genders);
		gender.setBounds(217, 140, 176, 20);
		frame.getContentPane().add(gender);

		// Address
		txtAddress = new JTextField("");
		txtAddress.setBounds(217, 170, 176, 20);
		frame.getContentPane().add(txtAddress);

		// Passport
		txtPassport = new JTextField("");
		txtPassport.setBounds(217, 200, 176, 20);
		frame.getContentPane().add(txtPassport);

		// DateOfIssue
		txtDateOfIssue = new JTextField("");
		txtDateOfIssue.setBounds(217, 230, 176, 20);
		frame.getContentPane().add(txtDateOfIssue);

		// DateOfExpire
		txtDateOfexpired = new JTextField("");
		txtDateOfexpired.setBounds(217, 260, 176, 20);
		frame.getContentPane().add(txtDateOfexpired);

		// Countries
		ArrayList<String> countries = new ArrayList<String>();

		String[] countryCodes = Locale.getISOCountries();
		for (String countryCode : countryCodes) {

			Locale locale = new Locale("", countryCode);
			String name = locale.getDisplayCountry();
			countries.add(name);
		}

		String str[] = new String[countries.size()];
		// ArrayList to Array Conversion
		for (int j = 0; j < countries.size(); j++) {
			// Assign each value to String array
			str[j] = countries.get(j);
		}

		country = new JComboBox<>(str);
		country.setBounds(217, 290, 176, 20);
		frame.getContentPane().add(country);

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(500, 200, 200, 30);
		frame.getContentPane().add(btnSave);
		btnSave.addActionListener(new NewUserRegListener());

		frame.setVisible(true);
		
		try {
			Image image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}

	public class NewUserRegListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			ArrayList<String> str = new ArrayList<String>();

			classes.UserName fullname = new classes.UserName();
			fullname.setFirstName(txtFname.getText());
			fullname.setLastName(txtLname.getText());

			User newuser = new User();

			if (Validation.checkUniqeUserName(txtUsername1.getText(), Data.newusers))
				newuser.setUserName(txtUsername1.getText());
			else
				str.add("UserName Must be unique");

			newuser.setAddress(txtAddress.getText());

			if (Validation.isValidDate(txtDateOfIssue.getText()))
				newuser.setDateOfIssue(txtDateOfIssue.getText());
			else
				str.add("check Date of Issue Format(/dd/mm/yyyy)");

			if (Validation.isValidDate(txtDateOfexpired.getText()))
				newuser.setValidTo(txtDateOfexpired.getText());
			else
				str.add("check Date of expired Format(/dd/mm/yyyy)");

			newuser.setGender(gender.getSelectedItem().toString());
			newuser.setFullName(fullname);

			if (Validation.isValidEmail(txtEmail.getText()))
				newuser.setEmail(txtEmail.getText());
			else
				str.add("email must be like (example@example.com)");

			newuser.setPassportNo(txtPassport.getText());
			newuser.setCountry(country.getSelectedItem().toString());

			if (Validation.checkPassword(txtPassword.getText(), txtConfirmPassword.getText()))
				newuser.setPassword(txtPassword.getText());
			else
				str.add("Password & Confirmation Password must be same");

			if (str.size() == 0) {
				Data.newusers.add(newuser);
				System.out.println(newuser.getUserName());
				System.out.println(newuser.getPassword());
				JOptionPane.showMessageDialog(null, "Successfully User Added");
				frame.setVisible(false);
			} else {
				String result = "";
				for (String string : str) {
					result += "- " + string + "\n";
				}
				JOptionPane.showMessageDialog(null, result);
			}

		}

	}

}
