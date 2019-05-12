package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.border.LineBorder;

import Classes.Data;
import Classes.VisaRequest;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 330);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		// set visa requests in admin panel
		String visarequestsnumbers[] = new String[Data.visarequests.size()];
		for (int i = 0; i < Data.visarequests.size(); i++) {
			visarequestsnumbers[i] = Data.visarequests.get(i).getVisaId() + " : "
					+ Data.visarequests.get(i).getUserName();
		}
		JComboBox comboBox = new JComboBox(visarequestsnumbers);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -211, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("New Visa Requests");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 56, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 18, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Users");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 26, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1);

		// Countries
		String users[] = new String[Data.newusers.size()];
		for (int i = 0; i < Data.newusers.size(); i++) {
			users[i] = Data.newusers.get(i).getUserName();
		}
		JComboBox comboBox_1 = new JComboBox(users);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 88, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(comboBox_1);

		JButton btnBlockUser = new JButton("Block User");
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -31, SpringLayout.WEST, btnBlockUser);
		springLayout.putConstraint(SpringLayout.WEST, btnBlockUser, 275, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnBlockUser);

		JButton btnCheckVisaRequest = new JButton("Check Visa Request");
		btnCheckVisaRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str[] = comboBox.getSelectedItem().toString().split(":");
				new ViewVisaRequest(str[1].trim());
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCheckVisaRequest, 31, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, btnBlockUser, 0, SpringLayout.EAST, btnCheckVisaRequest);
		springLayout.putConstraint(SpringLayout.NORTH, btnCheckVisaRequest, 55, SpringLayout.NORTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnBlockUser, 21, SpringLayout.SOUTH, btnCheckVisaRequest);
		frame.getContentPane().add(btnCheckVisaRequest);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogOut, -46, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogOut, 0, SpringLayout.EAST, btnBlockUser);
		frame.getContentPane().add(btnLogOut);
	}
}
