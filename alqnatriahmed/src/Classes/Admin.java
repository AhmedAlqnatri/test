package Classes;

import interfaces.SuperAdmin;

public class Admin extends Person implements SuperAdmin {

	public Admin(String email , String adminName , String password ,UserName adminFullName , String Gender)
	{
		super.Email = email;
		super.UserName = adminName;
		super.Password = password;
		super.setFullName(adminFullName);
		super.Gender = Gender;	
	}

	@Override
	public boolean BlockUser(User user) {
		return true;
	}
	
}
