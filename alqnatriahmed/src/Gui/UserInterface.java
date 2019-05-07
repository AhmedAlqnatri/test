package Gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import Classes.Data;
import Classes.VisaRequest;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UserInterface {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public UserInterface(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 30, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 115, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -107, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JButton button = new JButton("Create Visa Application");
		sl_panel_1.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, button, -34, SpringLayout.EAST, panel_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VisaTypes.getInstance(username);
				} catch (RuntimeException doubleTabs) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, doubleTabs.getMessage());
				}

			}
		});
		panel_1.add(button);

		JButton btnCheckVisaStatus = new JButton("Check Visa Status");
		btnCheckVisaStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID of the application"));
					if (CheckExistenceVisaId(Id))
						if (CheckVisaStatus(Id))
							JOptionPane.showMessageDialog(null, "Congratulations You Got the Visa");
						else
							JOptionPane.showMessageDialog(null, "Your visa application is refused because of :"
									+ getVisaRequestByUserName(username).getDescription());
					else
						JOptionPane.showMessageDialog(null, "The Id enterd is incorrect ,try once more");

				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Invaild Input, Id must be numerical");
				}

			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnCheckVisaStatus, 16, SpringLayout.SOUTH, button);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnCheckVisaStatus, 0, SpringLayout.WEST, button);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnCheckVisaStatus, 0, SpringLayout.EAST, button);
		panel_1.add(btnCheckVisaStatus);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -29, SpringLayout.NORTH, panel_2);

		JButton btnNewButton = new JButton("Apply a complaint");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, 18, SpringLayout.SOUTH, btnCheckVisaStatus);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, button);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, button);
		panel_1.add(btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, -58, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_2, -152, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JButton btnBack = new JButton("LogOut");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Gui.MainFrame.gui.frame.setVisible(true);
			}
		});
		sl_panel_2.putConstraint(SpringLayout.WEST, btnBack, 39, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, panel_2);
		panel_2.add(btnBack);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("User Services");
		try {
			Image image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}

	public boolean CheckVisaStatus(int id) {
		for (VisaRequest visarequest : Data.visarequests) {
			if (visarequest.getVisaId() == id)
				if (visarequest.getStatus() == true)
					return true;
		}
		return false;
	}

	public boolean CheckExistenceVisaId(int id) {
		for (VisaRequest visarequest : Data.visarequests) {
			if (visarequest.getVisaId() == id)
				return true;
		}
		return false;
	}

	public VisaRequest getVisaRequestByUserName(String username) {
		for (VisaRequest vr : Data.visarequests) {
			if (vr.getUserName().equalsIgnoreCase(username))

				return vr;
		}
		return null;
	}

}
