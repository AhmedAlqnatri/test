package classes;

import java.util.ArrayList;

public class Data {
	
	private Admin admin = null;
	private UserName adminfullname = null;
	private ArrayList<NewUser> newusers = null;
	private ArrayList<VisaRequest> visarequests = null;
	
	public Data() {
		newusers = new ArrayList<NewUser>();
		visarequests = new ArrayList<VisaRequest>();
		adminfullname = new UserName();
		adminfullname.setFirstName("ahmed");
		adminfullname.setLastName("alqanatri");				
		admin = new Admin("alqanatriahmed@gmail.com", "admin", "admin", adminfullname, "M");
	
	
	}
	
}
