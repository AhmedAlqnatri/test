package Classes;

import java.util.ArrayList;

public class Data {

	public Person admin = null;
	//aggregation
	public UserName adminfullname = null;
	//aggregation
	public static ArrayList<User> newusers = new ArrayList<User>();
	//aggregation
	public static ArrayList<VisaRequest> visarequests = new ArrayList<VisaRequest>();

	public Data() {
		adminfullname = new UserName();
		adminfullname.setFirstName("ahmed");
		adminfullname.setLastName("alqanatri");
		
		
		admin = new Admin("alqanatriahmed@gmail.com", "admin", "admin", adminfullname, "M");
		
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
		vr.setStatus(false);
		vr.setToCountry("Syria");
		vr.setApplyDate("12/12/2018");
		visarequests.add(vr);
	}

}
