package Classes;

import java.util.ArrayList;
import java.util.Set;

import interfaces.SuperAdmin;

public class Data {

	public static Admin admin = null;
	// aggregation
	public UserName adminfullname = null;
	// aggregation
	public static ArrayList<User> newusers = new ArrayList<User>();
	// aggregation
	public static ArrayList<VisaRequest> visarequests = new ArrayList<VisaRequest>();

	public Data() {
		adminfullname = new UserName();
		adminfullname.setFirstName("ahmed");
		adminfullname.setLastName("alqanatri");
		admin = new Admin("alqanatriahmed@gmail.com", "admin", "admin", adminfullname, "M");

//		Person person = admin;
//		SuperAdmin superadmin = admin;

		User nu = new User();
		nu.setUserName("ahmed");
		nu.setPassword("ahmed");
		nu.setFullName(adminfullname);
		nu.setEmail("ahmed@gmail.com");
		nu.setAddress("Botanicka 25 84214");
		nu.setCountry("Syria");
		nu.setPassportNo("123123123123N");
		nu.setDateOfIssue("12/12/2018");
		nu.setValidTo("12/12/2020");
		newusers.add(nu);

		VisaRequest vr = new VisaRequest();
		vr.setFullName(adminfullname);
		vr.setUserName("ahmed");
		vr.setVisaType("Jop Visa");
		vr.setStatus(false);
		vr.setDescription("Political Reasons");
		vr.setToCountry("Syria");
		vr.setApplyDate("12/12/2018");
		visarequests.add(vr);
	}

}
