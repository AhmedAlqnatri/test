package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import Classes.Data;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame {

	JTextField txtUsername = null;
	JTextField txtPassword = null;
	JFrame frame = null;
	JPanel panel, panel2, panelTitle;
	JLabel lblUsername;
	JLabel lblPassword;
	JLabel lbltitle;
	JButton btnLogin;
	JButton btnRegisterNewUser;
	static MainFrame gui;

	/**
	 * this function initializes the components of the frame
	 * 
	 */
	public void initcomponents() {
		// Data is the initial data we have when we start the application
		// (DatabaseLater)
		Data data = new Data();

		frame = new JFrame();
		frame.setTitle("E-visa LogIn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		panelTitle = new JPanel();
		frame.getContentPane().add(BorderLayout.NORTH, panelTitle);
		lbltitle = new JLabel("Welcome To E-Visa App");
		panelTitle.setPreferredSize(new Dimension(50, 50));
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
		// set application icon
		try {
			Image image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);

		} catch (IOException e) {
		}

	}

	/**
	 * this function check the entered user information (username , password) if it
	 * is correct or not.
	 * 
	 * @param username the unique username
	 * @param password the password of useraccount
	 * @return boolean value
	 */
	public static boolean login(String username, String password) {
		for (Classes.User newUser : Data.newusers) {
			if (username.equalsIgnoreCase(newUser.getUserName())) {
				if (password.equalsIgnoreCase(newUser.getPassword()))
					return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @author ahmed this is nested class which creates listener for Login Button it
	 *         has actionPerformed method which is responsible of invoking Login
	 *         method
	 */
	public class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (txtUsername.getText().equalsIgnoreCase("admin")) {
				if (txtPassword.getText().equalsIgnoreCase("admin"))
					new AdminPanel();
			} else {
				if (login(txtUsername.getText(), txtPassword.getText())) {
					new UserGui(txtUsername.getText());
					gui.frame.setVisible(false);
				} else {
					txtUsername.setText(null);
					txtPassword.setText(null);
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * 
	 * @author ahmed this is nested class which creates listener for newUser Button
	 *         it has actionPerformed method which is responsible of initiates
	 *         RegisterNewUser Gui
	 */
	public class NewUserlListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			new RegisterNewUser().initComponents();
		}
	}

	public static void main(String[] args) {
		gui = new MainFrame();
		gui.initcomponents();
	}

}