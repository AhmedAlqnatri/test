package Gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AdminPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.setBounds(100, 100, 428, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -168, SpringLayout.EAST, frame.getContentPane());
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
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 88, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnBlockUser = new JButton("Block User");
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -31, SpringLayout.WEST, btnBlockUser);
		frame.getContentPane().add(btnBlockUser);
		
		JButton btnCheckVisaRequest = new JButton("Check Visa Request");
		springLayout.putConstraint(SpringLayout.NORTH, btnBlockUser, 23, SpringLayout.SOUTH, btnCheckVisaRequest);
		springLayout.putConstraint(SpringLayout.WEST, btnBlockUser, 0, SpringLayout.WEST, btnCheckVisaRequest);
		springLayout.putConstraint(SpringLayout.EAST, btnBlockUser, 0, SpringLayout.EAST, btnCheckVisaRequest);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheckVisaRequest, -215, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCheckVisaRequest, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnCheckVisaRequest);
	}
}
