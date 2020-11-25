package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private String identification;
	private String email;
	private String password; 
	private String username;
	private String picture;
	private LocalDate birthday;

	/*
	name: User
	Its the constructor of User
	@param: name
	@param: lastName
	@param: identification
	@param: email
	@param: password
	@param: username
	@param: picture
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
	
	/*
	name: getName
	allows to obtain the name of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the name of the user saved in variable "name"
	**/
	public String getName() {
		return name;
	}
	
	/*
	name: setName
	allows entering a new name for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the name will be saved in the variable "name"
	@param: name
	**/
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	name: getLastName
	allows to obtain the last name of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the last name of the user saved in variable "lastName"
	**/
	public String getLastName() {
		return lastName;
	}
	
	/*
	name: setLastName
	allows entering a new last name for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the last name will be saved in the variable "lastName"
	@param: lastName
	**/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	name: getIdentification
	allows to obtain the identification of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the identification of the user saved in variable "identification"
	**/
	public String getIdentification() {
		return identification;
	}
	
	/*
	name: setIdentification
	allows entering a new identification for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the identification will be saved in the variable "identification"
	@param: identification
	**/
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	/*
	name: getEmail
	allows to obtain the email of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the email of the user saved in variable "email"
	**/
	public String getEmail() {
		return email;
	}

	/*
	name: setEmail
	allows entering a new email for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the email will be saved in the variable "email"
	@param: email
	**/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	name: getPassword
	allows to obtain the password of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the password of the user saved in variable "password"
	**/
	public String getPassword() {
		return password;
	}
	
	/*
	name: setPassword
	allows entering a new password for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the password will be saved in the variable "password"
	@param: password
	**/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	name: getUsername
	allows to obtain the username of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the username of the user saved in variable "username"
	**/
	public String getUsername() {
		return username;
	}
	
	/*
	name: setUsername
	allows entering a new username for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the username will be saved in the variable "username"
	@param: username
	**/
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*
	name: getPicture
	allows to obtain the path picture of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the path picture of the user saved in variable "picture"
	**/
	public String getPicture() {
		return picture;
	}
	
	/*
	name: setPicture
	allows entering a new path picture for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the path picture will be saved in the variable "picture"
	@param: picture
	**/
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/*
	name: getBirthday
	allows to obtain the birthday of the User
	<b>pre:</b>The user object must be created
	<b>post:</b>obtain the birthday of the user saved in variable "birthday"
	**/
	public LocalDate getBirthday() {
		return birthday;
	}

	/*
	name: setBirthday
	allows entering a new birthday for the User
	<b>pre:</b>The user object must be created
	<b>post:</b>the birthday will be saved in the variable "birthday"
	@param: birthday
	**/
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
