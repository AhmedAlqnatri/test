package interfaces;

import java.util.ArrayList;

import Classes.User;

/**
 * 
 * @author ahmed alqntari
 *
 */

public interface Validation {

	/**
	 * this function determines if the entered Date Is matching a DD/MM/YYYY
	 * expression or not.
	 * 
	 * @param date the entered date.
	 * @return boolean value.
	 */
	public boolean isValidDate(String date);

	/**
	 * this function determines if the entered Email Is matching a
	 * example@example.com expression or not.
	 * 
	 * @param email the entered email.
	 * @return boolean value.
	 */

	public boolean isValidEmail(String email);

	/**
	 * this function determines if the entered username is unique in the list of
	 * existed users or not.
	 * 
	 * @param usernaem the entered username.
	 * @param users    List of the existed users.
	 * @return boolean value
	 */

	public boolean checkUniqeUserName(String usernaem, ArrayList<User> users);

	/**
	 * this function determines if the password value and confirmation password value
	 * entered is matched.
	 * 
	 * @param password the entered Password.
	 * @param Confpass the entered Confirmation password.
	 * @return boolean value
	 */
	public boolean checkPassword(String password, String Confpass);

}
