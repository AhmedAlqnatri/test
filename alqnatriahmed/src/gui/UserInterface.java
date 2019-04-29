package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import classes.Data;
import classes.UserName;
import gui.MainFrame.LoginListener;
import gui.MainFrame.NewUserlListener;
import gui.NewUser.NewUserRegListener;

public class UserInterface extends javax.swing.JFrame {
	JFrame frame = null;
	JPanel panel, panel2;
	JLabel lbltitle;
	JButton btnCreateVisaRequest;
	JButton btnCheckVisaStatus;
	JButton btnBack;

	public void initComponents() {

		frame = new JFrame();
		frame.setTitle("E-visa LogIn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		panel2 = new JPanel();
		
		frame.getContentPane().add(BorderLayout.NORTH, panel2);
		lbltitle = new JLabel("User Services");
		panel2.setPreferredSize(new Dimension(50, 50));
		frame.add(panel2);

		panel = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		// Create Visa Button with Listener
		btnCreateVisaRequest = new JButton("Create Visa Request");
		btnCreateVisaRequest.addActionListener(new CreateVisaRequestListener());
		btnCreateVisaRequest.setBounds(50, 50, 100, 20);
		
		// Create Check Visa Button Status with Listener
		btnCheckVisaStatus = new JButton("Check Visa Status");
		btnCheckVisaStatus.setBounds(50, 100, 100, 20);
		btnCheckVisaStatus.addActionListener(new CheckVisaStatusListener());

		panel.add(btnCreateVisaRequest);
		panel.add(btnCheckVisaStatus);
		
		
		frame.setSize(350, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public class CreateVisaRequestListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		}
	}

	public class CheckVisaStatusListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		}
	}

}
