package classes;

import java.util.ArrayList;

public class Data {

	public Admin admin = null;
	public UserName adminfullname = null;
	public static ArrayList<NewUser> newusers = new ArrayList<NewUser>();
	public ArrayList<VisaRequest> visarequests = new ArrayList<VisaRequest>();

	public Data() {
		adminfullname = new UserName();
		adminfullname.setFirstName("ahmed");
		adminfullname.setLastName("alqanatri");
		admin = new Admin("alqanatriahmed@gmail.com", "admin", "admin", adminfullname, "M");

	}

//	public static void main(String [] args) {
//		
//		//Data d = new Data();
//	}
//	
}
