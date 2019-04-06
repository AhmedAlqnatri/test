package classes;

public class User {

	
	
	private String Email;
	private String UserName; 
	private String Password;
	private UserName FullName;
	private String Gender;
	private String Address;
	private long PassportNo;
	private String DateOfIssue;
	private String ValidTo;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public UserName getFullName() {
		return FullName;
	}
	public void setFullName(UserName fullName) {
		FullName = fullName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
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
