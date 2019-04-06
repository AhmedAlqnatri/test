package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewUser extends javax.swing.JFrame {

	JLabel l1;
	JTextField tf1;
	JFrame frame = null;
	JPanel panel = null;

	public void initComponents() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setTitle("E-visa NewUser");
		panel = new JPanel();
		frame.setResizable(false);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
		frame.setSize(400, 600);
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3,
				Toolkit.getDefaultToolkit().getScreenSize().height / frame.getSize().height);

		l1 = new JLabel("Name:");
		tf1 = new JTextField(20);

		panel.add(l1);
		panel.add(tf1);

	}

}
