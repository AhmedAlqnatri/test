package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.awt.event.ActionEvent;

public class JopVisa {
	private JFrame frame;
	JLabel label,lblNewLabel;
	private int progress;
	public BufferedImage bImage = null;
	public Image scaledImage = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JopVisa window = new JopVisa();
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
	public JopVisa() {
		initialize();
	}

	// Initialize new folder for the user application
	private void createApplicationFolder(String username) {
		Path path1 = Paths.get(System.getProperty("user.dir") + "\\" + username);
		if (!Files.exists(path1)) {
			try {
				Files.createDirectory(path1);
			} catch (IOException e) {
				throw new RuntimeException("Unexpected Error");
			}
		} else {
			// create new application folder ( next update )
		}
	}

	// -- Upload image to the user folder
	private void uploadPicture(File file, String imageSection, String username) {
		try {
			bImage = ImageIO.read(file);
			String extention = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			ImageIO.write(bImage, extention, new File(System.getProperty("user.dir") + "\\" + username + "\\"
					+ imageSection + "_" + username + "." + extention));
		} catch (IOException e) {
			// throw exception when we coudn't create upload the image
			throw new RuntimeException("Unexpected Error");
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		createApplicationFolder("abdo");

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 229, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -37, SpringLayout.EAST, frame.getContentPane());
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frame.getContentPane().add(panel);

		JLabel lblProfilePicture = new JLabel("Profile Picture");
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblProfilePicture);
		springLayout.putConstraint(SpringLayout.WEST, panel, -20, SpringLayout.WEST, lblProfilePicture);
		springLayout.putConstraint(SpringLayout.WEST, lblProfilePicture, 383, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblProfilePicture, -511, SpringLayout.SOUTH,
				frame.getContentPane());
		lblProfilePicture.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblProfilePicture);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 56, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 41, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -197, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 299, SpringLayout.WEST, frame.getContentPane());
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		JLabel lblNewLabel_3 = new JLabel();
		panel.add(lblNewLabel_3);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JProgressBar progressBar = new JProgressBar();
		sl_panel_1.putConstraint(SpringLayout.NORTH, progressBar, -33, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, progressBar, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, progressBar, -10, SpringLayout.EAST, panel_1);
		panel_1.add(progressBar);

		JButton btnImagePassport = new JButton("Upload Passport Image");
		btnImagePassport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new gui.ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// upload PassportImage
					uploadPicture(file, "PassportImage", "abdo");
					// Set profilePicture on panel;
					if (lblNewLabel.getText() == "") {
						progress += 25;
						lblNewLabel.setText(file.getName());
					} else {
						lblNewLabel.setText(file.getName());
					}
				} else {
					lblNewLabel.setText("");
				}
				progressBar.setValue(progress);
			}
		});
		panel_1.add(btnImagePassport);

		JButton btnProfilePicture = new JButton("Upload Profile Picture");
		btnProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new gui.ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// upload profilePicture
					uploadPicture(file, "PP", "abdo");

					// Set profilePicture on panel;
					if (scaledImage != null)
						lblNewLabel_3.setIcon(new ImageIcon(scaledImage));
					if (label.getText() == "") {
						progress += 25;
						label.setText(file.getName());
					} else {
						label.setText(file.getName());
					}
				} else {
					label.setText("");
				}
				progressBar.setValue(progress);
			}
		});
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnProfilePicture, -35, SpringLayout.NORTH, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnImagePassport, 0, SpringLayout.WEST, btnProfilePicture);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnImagePassport, 0, SpringLayout.EAST, btnProfilePicture);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnProfilePicture, 20, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnProfilePicture, -57, SpringLayout.EAST, panel_1);
		panel_1.add(btnProfilePicture);

		JButton btnImageJobContract = new JButton("Upload Job Contract");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnImagePassport, -39, SpringLayout.NORTH, btnImageJobContract);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnImageJobContract, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnImageJobContract, 0, SpringLayout.EAST, btnImagePassport);
		panel_1.add(btnImageJobContract);

		JButton btnImageAccomdation = new JButton("Upload Accomdation Conrtact");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnImageAccomdation, -42, SpringLayout.NORTH, progressBar);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnImageJobContract, -33, SpringLayout.NORTH, btnImageAccomdation);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnImageAccomdation, 20, SpringLayout.WEST, panel_1);
		panel_1.add(btnImageAccomdation);

		label = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, label, 9, SpringLayout.SOUTH, btnProfilePicture);
		sl_panel_1.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, label, 23, SpringLayout.SOUTH, btnProfilePicture);
		sl_panel_1.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, btnImagePassport);
		panel_1.add(label);

		lblNewLabel = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -3, SpringLayout.EAST, btnImagePassport);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, btnImageJobContract);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -3, SpringLayout.EAST, btnImagePassport);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, btnImageAccomdation);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -3, SpringLayout.EAST, btnImagePassport);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 25, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -37, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JButton btnSaveApplication = new JButton("Send Application");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnSaveApplication, 19, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnSaveApplication, 163, SpringLayout.WEST, panel_2);
		panel_2.add(btnSaveApplication);

		JButton btnCheckUserInformation = new JButton("Check User Information");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnCheckUserInformation, 44, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnSaveApplication, -8, SpringLayout.NORTH,
				btnCheckUserInformation);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnCheckUserInformation, -19, SpringLayout.EAST, panel_2);
		panel_2.add(btnCheckUserInformation);

		JButton btnBack = new JButton("Back");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnBack, 6, SpringLayout.SOUTH, btnCheckUserInformation);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnBack, 21, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnBack, 165, SpringLayout.WEST, panel_2);
		panel_2.add(btnBack);
	}
}
