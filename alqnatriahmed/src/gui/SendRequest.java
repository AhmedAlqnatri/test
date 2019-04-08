package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classes.Data;
import gui.NewUser.NewUserRegListener;

public class SendRequest extends javax.swing.JFrame {

	private JTextField txtFname, txtLname, txtUsername1;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtAddress, txtPassport, txtDateOfIssue, txtDateOfexpired;
	private JTextField txtEmail;
	BufferedImage image;
	JFrame frame;
	JComboBox<String> gender;
	JComboBox<String> country;
	// Data data = new Data();

	private String[] genders = new String[] { "Male", "Female" };
	// private JComboBox gender;

	public static classes.NewUser getUser(String username) {

		for (classes.NewUser user : Data.newusers) {
			if (user.getUserName().equalsIgnoreCase(username))
				return user;
		}
		return null;
	}

	public void initcomponents(String username) {
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
		JLabel hUsername = new JLabel("Upload Photo :");
		hUsername.setBounds(500, 54, 89, 14);
		frame.getContentPane().add(hUsername);

		JButton fc = new JButton("Choose File");
		fc.setBounds(620, 43, 102, 20);
		fc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
//	            fileChooser.addChoosableFileFilter(new clas);
//	            fileChooser.setAcceptAllFileFilterUsed(false);

				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					hUsername.setText("File Selected: " + file.getName());
				} else {
					hUsername.setText("Open command canceled");
				}
			}
		});

		frame.getContentPane().add(fc);

		JLabel hPassword = new JLabel("Upload Document :");
		hPassword.setBounds(500, 82, 89, 14);
		frame.getContentPane().add(hPassword);
		// Password
		JButton fc1 = new JButton("Choose File");
		fc1.setBounds(620, 77, 102, 20);
		frame.getContentPane().add(fc1);

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

//		JLabel hCountry = new JLabel("Country :");
//		hCountry.setBounds(80, 292, 92, 14);
//		frame.getContentPane().add(hCountry);

		// FirstName
		txtFname = new JTextField("");
		txtFname.setBounds(217, 47, 176, 20);
		frame.getContentPane().add(txtFname);
		txtFname.setText(getUser(username).getFullName().getFirstName());

		// LastName
		txtLname = new JTextField("");
		txtLname.setBounds(217, 78, 176, 20);
		frame.getContentPane().add(txtLname);
		txtLname.setText(getUser(username).getFullName().getLastName());

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 110, 176, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setText(getUser(username).getEmail());

		// gender
		gender = new JComboBox<>(genders);
		gender.setBounds(217, 140, 176, 20);
		frame.getContentPane().add(gender);

		// Address
		txtAddress = new JTextField("");
		txtAddress.setBounds(217, 170, 176, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setText(getUser(username).getAddress());

		// Passport
		txtPassport = new JTextField("");
		txtPassport.setBounds(217, 200, 176, 20);
		frame.getContentPane().add(txtPassport);
		txtPassport.setText(getUser(username).getPassportNo());

		// DateOfIssue
		txtDateOfIssue = new JTextField("");
		txtDateOfIssue.setBounds(217, 230, 176, 20);
		frame.getContentPane().add(txtDateOfIssue);
		txtDateOfIssue.setText(getUser(username).getDateOfIssue());

		// DateOfExpire
		txtDateOfexpired = new JTextField("");
		txtDateOfexpired.setBounds(217, 260, 176, 20);
		frame.getContentPane().add(txtDateOfexpired);

		txtDateOfexpired.setText(getUser(username).getValidTo());

		// Save Button
		JButton btnSave = new JButton("Send Now");
		btnSave.setBounds(500, 200, 200, 30);
		frame.getContentPane().add(btnSave);

		frame.setVisible(true);

	}

}