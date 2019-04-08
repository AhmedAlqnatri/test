package classes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	// Returns true if d is in format
	// /dd/mm/yyyy
	public static boolean isValidDate(String date) {

		String regex = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) date);
		return matcher.matches();
	}

	public static boolean isValidEmail(String email) {

		Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
		Matcher matcher = regex.matcher((CharSequence) email);
		return matcher.matches();
	}

	public static boolean checkUniqeUserName(String usernaem, ArrayList<NewUser> users) {

		for (NewUser newUser : users) {
			if (usernaem.equalsIgnoreCase(newUser.UserName))
				return false;
		}
		return true;
	}

	public static boolean checkPassword(String password, String Confpass) {

		if (password.equalsIgnoreCase(Confpass))
			return true;
		return false;
	}

}
