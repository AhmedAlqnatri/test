package gui;

import javax.swing.*;

import classes.Data;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame {

	JTextField txtUsername = null;
	JTextField txtPassword = null;
	JFrame frame = null;
	JPanel panel, panel2;
	JLabel lblUsername;
	JLabel lblPassword;
	JButton btnLogin;
	JButton btnRegisterNewUser;

	public void initcomponents() {
		Data data = new Data();
		frame = new JFrame();
		frame.setTitle("E-visa LogIn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		panel = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		panel2 = new JPanel();
		frame.getContentPane().add(BorderLayout.PAGE_END, panel2);
		lblUsername = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		txtUsername = new JTextField(20);
		txtPassword = new JTextField(20);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new LoginListener());
		btnRegisterNewUser = new JButton("New User");
		btnRegisterNewUser.addActionListener(new NewUserlListener());
		txtUsername = new JTextField(20);
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel2.add(btnLogin);
		panel2.add(btnRegisterNewUser);

		frame.setSize(350, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public static ArrayList<String> login(String username, String password, ArrayList<classes.NewUser> users) {
		ArrayList<String> errorlogindeatils = new ArrayList<String>();

		for (classes.NewUser newUser : users) {
			if (username.equalsIgnoreCase(newUser.getUserName())) {
				if (password.equalsIgnoreCase(newUser.getPassword())) {
					return errorlogindeatils;
				} else {
					errorlogindeatils.add("Password is inCorrect");
					return errorlogindeatils;
				}
			} else {
				errorlogindeatils.add("User isn't existed");
				return errorlogindeatils;
			}
		}
		return errorlogindeatils;

	}

	public class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ArrayList<String> result = login(txtUsername.getText(), txtPassword.getText(), Data.newusers);
		//	System.out.println(Data.newusers);
			if (result.size() == 0 && Data.newusers.size() !=0) {
				new UserInterface().initComponents(txtUsername.getText());	
			} else {
				JOptionPane.showMessageDialog(null, result);

			}
		}
	}

	public class NewUserlListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			new NewUser().initComponents();
		}
	}

	public static void main(String[] args) {
		MainFrame gui = new MainFrame();
		gui.initcomponents();
	}

}