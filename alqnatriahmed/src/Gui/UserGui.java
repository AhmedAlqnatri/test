package Gui;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import AssistanceClasses.VisaServices;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class UserGui extends VisaServices {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public UserGui(String username) {
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
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 85, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -88, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JButton button = new JButton("Create Visa Application");
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
		sl_panel_1.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, btnCheckVisaStatus);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnCheckVisaStatus, 45, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnCheckVisaStatus, -34, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, btnCheckVisaStatus);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, button, -23, SpringLayout.NORTH, btnCheckVisaStatus);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnCheckVisaStatus, -46, SpringLayout.SOUTH, panel_1);
		btnCheckVisaStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID of the application"));
					if (CheckExistenceVisaId(Id))
						if (CheckVisaStatus(Id))
							JOptionPane.showMessageDialog(null, "Congratulations You Got the Visa");
						else if (CheckVisaStatus(Id) == false)
							JOptionPane.showInputDialog(null, "Your visa application's status is refused because of :"
									+ getVisaRequestByUserName(username).getDescription()+ " Write Your Complaining");
					else
						JOptionPane.showMessageDialog(null, "The Id enterd is incorrect ,try once more");

				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Invaild Input, Id must be numerical");
				}

			}
		});
		panel_1.add(btnCheckVisaStatus);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -29, SpringLayout.NORTH, panel_2);
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

}
