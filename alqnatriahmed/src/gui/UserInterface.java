package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserInterface {

	private JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserInterface window = new UserInterface();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 30, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 129, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -107, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JButton button = new JButton("Create Visa Application");
		sl_panel_1.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, button, 20, SpringLayout.WEST, panel_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(button);

		JButton btnCheckVisaStatus = new JButton("Check Visa Status");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnCheckVisaStatus, 6, SpringLayout.SOUTH, button);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnCheckVisaStatus, 0, SpringLayout.WEST, button);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnCheckVisaStatus, 0, SpringLayout.EAST, button);
		panel_1.add(btnCheckVisaStatus);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -83, SpringLayout.NORTH, panel_2);
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, -58, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_2, -152, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JButton btnBack = new JButton("Back");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnBack, 39, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, panel_2);
		panel_2.add(btnBack);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		try {
			Image image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}
}
