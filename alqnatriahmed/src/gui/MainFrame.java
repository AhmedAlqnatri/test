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
	JPanel panel, panel2 , panelTitle;
	JLabel lblUsername;
	JLabel lblPassword;
	JLabel lbltitle;
	JButton btnLogin;
	JButton btnRegisterNewUser;

	public void initcomponents() {
		Data data = new Data();
		frame = new JFrame();
		frame.setTitle("E-visa LogIn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panelTitle = new JPanel();
		frame.getContentPane().add(BorderLayout.NORTH, panelTitle);
		lbltitle = new JLabel("Welcome To E-Visa App");
		panelTitle.setPreferredSize(new Dimension(50,50));
		panelTitle.add(lbltitle);
		
		
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
	

	public static boolean login(String username, String password) {
		for (classes.User newUser : Data.newusers) {
			if (username.equalsIgnoreCase(newUser.getUserName())) {
				if (password.equalsIgnoreCase(newUser.getPassword()))
					return true;
			}
		}
		return false;
	}

	public class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println(Data.newusers);
			// System.out.println(Data.newusers);
			if (login(txtUsername.getText(), txtPassword.getText())) {
				new UserInterface().initComponents();
				frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Cred");

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