package Gui;

import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import AssistanceClasses.VisaServices;
import Classes.Data;
import Classes.User;
import Classes.VisaRequest;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewVisaRequest extends VisaServices {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public ViewVisaRequest(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle(username + " Infromation");
		frame.setBounds(100, 100, 368, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 341, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblFullName = new JLabel("Full Name");
		sl_panel.putConstraint(SpringLayout.WEST, lblFullName, 12, SpringLayout.WEST, panel);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblFullName);

		JLabel lblVisaType = new JLabel("Visa Type");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFullName, -20, SpringLayout.NORTH, lblVisaType);
		sl_panel.putConstraint(SpringLayout.WEST, lblVisaType, 10, SpringLayout.WEST, panel);
		lblVisaType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblVisaType);

		JLabel lblPassportNo = new JLabel("Passport No:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblVisaType, -17, SpringLayout.NORTH, lblPassportNo);
		sl_panel.putConstraint(SpringLayout.WEST, lblPassportNo, 11, SpringLayout.WEST, panel);
		lblPassportNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblPassportNo);

		JLabel lblIssueDate = new JLabel("Issue Date");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPassportNo, -12, SpringLayout.NORTH, lblIssueDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblIssueDate, 11, SpringLayout.WEST, panel);
		lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblIssueDate);

		JLabel lblExpireDate = new JLabel("Expire Date");
		sl_panel.putConstraint(SpringLayout.NORTH, lblExpireDate, 166, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblIssueDate, -16, SpringLayout.NORTH, lblExpireDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblExpireDate, 12, SpringLayout.WEST, panel);
		lblExpireDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblExpireDate);

		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField, 32, SpringLayout.EAST, lblFullName);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -57, SpringLayout.EAST, panel);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);

		if (getUserByUsername(username) != null)
			textField.setText(getUserByUsername(username).getFullName().getFirstName() + " "
					+ getUserByUsername(username).getFullName().getLastName());

		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -17, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);

		if (getUserByUsername(username) != null) {
			textField_1.setText(getVisaRequestByUserName(username).getVisaType());
		}

		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -12, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 13, SpringLayout.EAST, lblPassportNo);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -57, SpringLayout.EAST, panel);
		textField_2.setEditable(false);
		panel.add(textField_2);
		textField_2.setColumns(10);
		if (getUserByUsername(username) != null) {
			textField_2.setText(getUserByUsername(username).getPassportNo());
		}

		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, -11, SpringLayout.NORTH, textField_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 132, SpringLayout.NORTH, panel);
		textField_3.setEditable(false);
		panel.add(textField_3);
		textField_3.setColumns(10);

		if (getUserByUsername(username) != null) {
			textField_3.setText(getUserByUsername(username).getDateOfIssue());
		}

		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 14, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		textField_4.setEditable(false);
		panel.add(textField_4);
		textField_4.setColumns(10);
		if (getUserByUsername(username) != null) {
			textField_4.setText(getUserByUsername(username).getValidTo());
		}

		JButton btnNewButton = new JButton("Open Attched Files");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().open(new File(System.getProperty("user.dir") + "\\" + username));
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Invaild User");
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 28, SpringLayout.SOUTH, textField_4);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, textField);
		panel.add(btnNewButton);

		JButton btnAccept = new JButton("Accept");
		sl_panel.putConstraint(SpringLayout.WEST, btnAccept, 0, SpringLayout.WEST, textField);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (VisaRequest vr : Data.visarequests) {
					if (vr.getUserName().equalsIgnoreCase(username)) {
						vr.setStatus(true);
						JOptionPane.showMessageDialog(null, "Set status Successfully");
					}
				}
			}
		});
		panel.add(btnAccept);

		JButton btnNewButton_1 = new JButton("Reject");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 45, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAccept, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnAccept, -14, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 195, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, textField);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reason = JOptionPane.showInputDialog(null, "Please Write the reason");
				if (getVisaRequestByUserName(username) != null) {
					getVisaRequestByUserName(username).setDescription(reason);

				}
			}
		});
		panel.add(btnNewButton_1);
	}

}
