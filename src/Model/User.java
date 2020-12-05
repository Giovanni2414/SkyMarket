package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable{
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The user mainly name
	 */
	private String name;
	
	/**
	 * The user lastname
	 */
	private String lastName;
	
	/**
	 * The user identification
	 */
	private String identification;
	
	/**
	 * The user email
	 */
	private String email;
	
	/**
	 * The user password
	 */
	private String password;
	
	/**
	 * The unique username to enter into the application
	 */
	private String username;
	
	/**
	 * The path of the profile picture
	 */
	private String picture;
	
	/**
	 * The birthday of the user
	 */
	private LocalDate birthday;

	/**
	* Its the constructor of User
	* <br><b>Pre:</b> 
	* <br><b>Post: All variables will be initializated</b> 
	* @param name The user mainly name
	* @param lastName The user lastname 
	* @param identification The user identification
	* @param email The user email
	* @param password The user password
	* @param username The unique username for this user to enter into the application
	* @param picture The path of profile picture
	* @param birthday The birthday of this user
	**/
	public User(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) {
		this.name = name;
		this.lastName = lastName;
		this.identification = identification;
		this.email = email;
		this.password = password;
		this.username = username;
		this.picture = picture;
		this.birthday = birthday;
	}
	
	/**
	* Allows to obtain the name of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the name of the user saved in variable "name"</b> 
	* @return The user mainly name
	**/
	public String getName() {
		return name;
	}
	
	/**
	* Allows entering a new name for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the name will be saved in the variable "name"</b> 
	* @param name The new user mainly name to set
	**/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Allows to obtain the last name of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the last name of the user saved in variable "lastName"</b> 
	* @return The user lastname
	**/
	public String getLastName() {
		return lastName;
	}
	
	/**
	* Allows entering a new last name for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the last name will be saved in the variable "lastName"</b> 
	* @param lastName The new user lastname to set
	**/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	* Allows to obtain the identification of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the identification of the user saved in variable "identification"</b> 
	* @return The identification of this user
	**/
	public String getIdentification() {
		return identification;
	}
	
	/**
	* Allows entering a new identification for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the identification will be saved in the variable "identification"</b> 
	* @param identification The new identification to set
	**/
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	/**
	* Allows to obtain the email of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the email of the user saved in variable "email"</b> 
	* @return The user email
	**/
	public String getEmail() {
		return email;
	}

	/**
	* Allows entering a new email for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the email will be saved in the variable "email"</b> 
	* @param email The new user email to set
	**/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	* Allows to obtain the password of the User
	* <br><b>Pre: The user object must be created</b>
	* <br><b>Post: obtain the password of the user saved in variable "password"</b>
	* @return The user password
	**/
	public String getPassword() {
		return password;
	}
	
	/**
	* Allows entering a new password for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the password will be saved in the variable "password"</b> 
	* @param password The new user password to set
	**/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	* Allows to obtain the username of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the username of the user saved in variable "username"</b>
	* @return The unique username to login into the application
	**/
	public String getUsername() {
		return username;
	}
	
	/**
	* Allows entering a new username for the User
	* <br><b>Pre:The user object must be created</b> 
	* <br><b>Post:the username will be saved in the variable "username"</b> 
	* @param username The new username unique to set
	**/
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	* Allows to obtain the path picture of the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: obtain the path picture of the user saved in variable "picture"</b> 
	* @return Return the path of profile picture for this user
	**/
	public String getPicture() {
		return picture;
	}
	
	/**
	* allows entering a new path picture for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the path picture will be saved in the variable "picture"</b> 
	* @param picture The new path of profile picture
	**/
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	* Allows to obtain the birthday of the User
	* <br><b>Pre: The user object must be created </b> 
	* <br><b>Post: obtain the birthday of the user saved in variable "birthday"</b> 
	* @return The birthday of this user
	**/
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	* Allows entering a new birthday for the User
	* <br><b>Pre: The user object must be created</b> 
	* <br><b>Post: the birthday will be saved in the variable "birthday"</b> 
	* @param birthday The new birthday date to ser for this user
	**/
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
