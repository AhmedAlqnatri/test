package Gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VisaTypes {

	private JFrame frame;

	private static volatile VisaTypes sSoleInstance;

	public synchronized static VisaTypes getInstance(String username) {
		if (sSoleInstance == null) { 
			// if there is no instance available... create new one
			sSoleInstance = new VisaTypes(username);
			return sSoleInstance;
		} else {
			throw new RuntimeException("You can't open two visa applications ALERT !!");
		}

	}

	/**
	 * Create the application.
	 */
	private VisaTypes(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void setDefalutFrameSettings() {
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Visa Types");
		// Set Icon
		try {
			Image image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);
		} catch (IOException e) {
			System.exit(0);
		}

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sSoleInstance = null;
				e.getWindow().dispose();
			}
		});

	}

	private void initialize(String username) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 36, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 120, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 193, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -125, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("Job Visa");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 47, SpringLayout.WEST, panel);
		// job visa listener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JobVisa(username);
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 23, SpringLayout.NORTH, panel);
		panel.add(btnNewButton);
		// study visa listener
		JButton btnNewButton_1 = new JButton("Study Visa");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 16, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 47, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -41, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
		panel.add(btnNewButton_1);

		// Tourist visa listener
		JButton btnNewButton_2 = new JButton("Tourist Visa");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 20, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton);
		panel.add(btnNewButton_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sSoleInstance = null;
				frame.dispose();
				
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -28, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnBack);
		
		
		//set Default Frame Settings
		setDefalutFrameSettings();
	}
}
