package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;

import Classes.Data;
import Classes.VisaRequest;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import AssistanceClasses.*;

public class JobVisa {
	private JFrame frame;
	JLabel label, lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3;
	private int progress;
	public BufferedImage bImage = null;
	public Image scaledImage = null;
	private Map<String, String> visafilesPaths = new HashMap<String, String>();
	public Map<String, String> visafiles = new HashMap<String, String>();

	/**
	 * Create the application.
	 */
	public JobVisa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
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
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -124, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 299, SpringLayout.WEST, frame.getContentPane());
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar);

		JButton btnImagePassport = new JButton("Upload Passport Image");
		btnImagePassport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// prepare PassportImage
					visafilesPaths.put("PassportImage", file.getAbsolutePath());
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
				fileChooser.addChoosableFileFilter(new ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// prepare ProfileImage
					visafilesPaths.put("ProfilePicture", file.getAbsolutePath());
					// Set profilePicture on panel;
					try {
						bImage = ImageIO.read(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					scaledImage = bImage.getScaledInstance(panel.getWidth() - 10, panel.getHeight() - 10,
							Image.SCALE_SMOOTH);
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
		// upload image Button Job Contract Listener
		btnImageJobContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// prepare Job Contract
					visafilesPaths.put("JobContract", file.getAbsolutePath());
//					imageTypes.add("JobContract");
					if (lblNewLabel_1.getText() == "") {
						progress += 25;
						lblNewLabel_1.setText(file.getName());
					} else {
						lblNewLabel_1.setText(file.getName());
					}
				} else {
					lblNewLabel_1.setText("");
				}
				progressBar.setValue(progress);

			}
		});
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnImagePassport, -39, SpringLayout.NORTH, btnImageJobContract);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnImageJobContract, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnImageJobContract, 0, SpringLayout.EAST, btnImagePassport);
		panel_1.add(btnImageJobContract);

		JButton btnImageAccomdation = new JButton("Upload Accomdation Conrtact");
		sl_panel_1.putConstraint(SpringLayout.NORTH, progressBar, 85, SpringLayout.SOUTH, btnImageAccomdation);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnImageAccomdation, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnImageAccomdation, 0, SpringLayout.EAST, btnImagePassport);

		// upload image Button accomdation Listener
		btnImageAccomdation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new ImageFilter());
				fileChooser.setAcceptAllFileFilterUsed(false);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					// prepare AccomdationContract
					visafilesPaths.put("AccomdationContract", file.getAbsolutePath());
//					imageTypes.add("AccomdationContract");
					if (lblNewLabel_2.getText() == "") {
						progress += 25;
						lblNewLabel_2.setText(file.getName());
					} else {
						lblNewLabel_2.setText(file.getName());
					}
				} else {
					lblNewLabel_2.setText("");
				}
				progressBar.setValue(progress);

			}
		});
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

		lblNewLabel_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnImageAccomdation, 27, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 177, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnImageJobContract, -6, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -3, SpringLayout.EAST, btnImagePassport);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, btnImageAccomdation);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 3, SpringLayout.WEST, btnImagePassport);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, btnImagePassport);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 28, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, -6, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -194, SpringLayout.SOUTH, frame.getContentPane());

		JButton btnReset = new JButton("reset");
		sl_panel_1.putConstraint(SpringLayout.WEST, progressBar, 6, SpringLayout.EAST, btnReset);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, progressBar, 0, SpringLayout.SOUTH, btnReset);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnReset, 0, SpringLayout.WEST, btnImagePassport);
		// upload image Button reset Listener
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visafilesPaths.clear();
				label.setText("");
				lblNewLabel.setText("");
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
				progress = 0;
				progressBar.setValue(progress);

			}
		});
		panel_1.add(btnReset);

		JLabel lblCountry = new JLabel("Country :");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnReset, 42, SpringLayout.SOUTH, lblCountry);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblCountry, 20, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblCountry, 0, SpringLayout.WEST, btnImagePassport);
		panel_1.add(lblCountry);

		// Countries
		ArrayList<String> countries = new ArrayList<String>();

		String[] countryCodes = Locale.getISOCountries();
		for (String countryCode : countryCodes) {

			Locale locale = new Locale("", countryCode);
			String name = locale.getDisplayCountry();
			countries.add(name);
		}

		String str[] = new String[countries.size()];
		// ArrayList to Array Conversion
		for (int j = 0; j < countries.size(); j++) {
			// Assign each value to String array
			str[j] = countries.get(j);
		}

		JComboBox comboBox = new JComboBox(str);

		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblCountry);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 21, SpringLayout.EAST, lblCountry);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, label);
		panel_1.add(comboBox);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -27, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		// upload image Button Send Application Listener
		JButton btnSaveApplication = new JButton("Send Application");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnSaveApplication, 13, SpringLayout.NORTH, panel_2);
		btnSaveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (label.getText().equalsIgnoreCase("") || lblNewLabel.getText().equalsIgnoreCase("")
						|| lblNewLabel_1.getText().equalsIgnoreCase("")
						|| lblNewLabel_2.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Complete Please !!");
				} else {
					createApplicationFolder("ahmed");
					for (Map.Entry<String, String> entry : visafilesPaths.entrySet()) {
						uploadPicture((String) entry.getValue(), (String) entry.getKey(), "ahmed");
					}

					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					VisaRequest visarequest = new VisaRequest();
					visarequest.setVisaId(Data.visarequests.size());
					visarequest.setUserName("ahmed");
					visarequest.setToCountry(comboBox.getSelectedItem().toString());
					visarequest.setApplyDate(dateFormat.format(date));
					visarequest.setVisaFiles(visafiles);
					Data.visarequests.add(visarequest);
					JOptionPane.showMessageDialog(null,
							"Successfully added your request and this is your application id :"
									+ Data.visarequests.size());

				}
			}
		});
		sl_panel_2.putConstraint(SpringLayout.WEST, btnSaveApplication, 21, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnSaveApplication, -19, SpringLayout.EAST, panel_2);
		panel_2.add(btnSaveApplication);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnBack, 38, SpringLayout.SOUTH, btnSaveApplication);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnBack, 23, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnBack, -19, SpringLayout.EAST, panel_2);
		panel_2.add(btnBack);
	}

	/**
	 * this function create folder for user's files
	 * 
	 * @param username
	 */
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

	/**
	 * this function upload photo to a specific given path (in our case to @usernaem
	 * folder)
	 * 
	 * @param filepath  the path which the photo should upload in.
	 * @param imageType the image type.
	 * @param username
	 */
	private void uploadPicture(String filepath, String imageType, String username) {
		try {
			File file = new File(filepath);
			bImage = ImageIO.read(file);
			String extention = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			String path = System.getProperty("user.dir") + "\\" + username + "\\" + imageType + "_" + username + "."
					+ extention;
			ImageIO.write(bImage, extention, new File(path));
			visafiles.put(imageType, path);

		} catch (IOException e) {
			// throw exception when it's not possible to upload the image
			throw new RuntimeException("Unexpected Error");
		}

	}

}
