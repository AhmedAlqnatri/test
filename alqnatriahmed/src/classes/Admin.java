package classes;

public class Admin extends User {

	public Admin(String email , String adminName , String password ,UserName adminFullName , String Gender)
	{
		this.Email = email;
		this.UserName = adminName;
		this.Password = password;
		this.FullName.setFirstName(adminFullName.getFirstName());
		this.FullName.setLastName(adminFullName.getLastName());
		this.Gender = Gender;	
	}
	
}
