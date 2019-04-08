package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import classes.Data;
import classes.NewUser;
import classes.UserName;
import gui.NewUser.NewUserRegListener;

public class UserInterface extends javax.swing.JFrame {

	JTable table;
	BufferedImage image;
	JFrame frame;
	JPanel jpanel1;
	JPanel jpanel2;;
	public static String user ;
	public void initComponents(String username) {
		user = username;
		String column[] = { "UserName", "Request Date", "To Country", "Status" };
		String data[][] = getVisaRequest(username);
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 500);
		JTable jt = new JTable(data, column);
		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(0, 0, 800, 250);
		jpanel1 = new JPanel();
		jpanel1.setBounds(0, 0, 800, 250);
		jpanel1.add(sp);

		JButton sendrequest = new JButton("Send Requset");
		sendrequest.setBounds(50, 50, 100, 20);
		sendrequest.addActionListener(new NewUserRequestlListener());

		jpanel1.add(sendrequest);
		frame.add(jpanel1);

		frame.setVisible(true);
		try {
			image = ImageIO.read(new File("./fiit_logo.png"));
			frame.setIconImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}
	
	public class NewUserRequestlListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			new SendRequest().initcomponents(UserInterface.user);
		}
	}
	
	
	public static String[][] getVisaRequest(String username) {
		int i = 0;
		String[][] result = new String[Data.visarequests.size()][5];
		for (classes.VisaRequest visarequest : Data.visarequests) {
			if (visarequest.getUserName().equalsIgnoreCase(username)) {
				result[i][0] = visarequest.getUserName();
				result[i][1] = visarequest.getApplyDate();
				result[i][2] = visarequest.getToCountry();
				if (visarequest.getStatus().equalsIgnoreCase("True"))
					result[i][3] = "Accepted";
				else
					result[i][3] = "Rejected";

				i++;

			}

		}
		return result;
	}

	
}
