package Classes;

public class Admin extends Person {

	public Admin(String email , String adminName , String password ,UserName adminFullName , String Gender)
	{
		super.Email = email;
		super.UserName = adminName;
		super.Password = password;
		super.setFullName(adminFullName);
		super.Gender = Gender;	
	}
	
}