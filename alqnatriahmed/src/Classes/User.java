package Classes;

import java.util.ArrayList;

public class User extends Person {

	private String Address;
	private String PassportNo;
	private String DateOfIssue;
	private String ValidTo;
	private String Country;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassportNo() {
		return PassportNo;
	}

	public void setPassportNo(String passportNo) {
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

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
