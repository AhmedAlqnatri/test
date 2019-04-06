package classes;

import java.util.ArrayList;

public class NewUser extends User {

	private String Address;
	private long PassportNo;
	private String DateOfIssue;
	private String ValidTo;
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPassportNo() {
		return PassportNo;
	}
	public void setPassportNo(long passportNo) {
		PassportNo = passportNo;
	}
	public String getDateOfIssue() {
		return DateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) {
		DateOfIssue = dateOfIssue;
	}
	public String getValidTo() {
		return ValidTo;
	}
	public void setValidTo(String validTo) {
		ValidTo = validTo;
	}
	
}
