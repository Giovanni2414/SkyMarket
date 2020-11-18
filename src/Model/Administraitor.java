package Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Administraitor extends User{

	private ArrayList<User> users;
	private ArrayList<Article> articles;
	
	/*
	name: Administraitor
	Its the constructor of Administraitor
	@param: name
	@param: lastName
	@param: identification
	@param: password
	@param: username
	@param: picture
	**/
	public Administraitor(String name, String lastName, String identification, String password, String username, String picture, LinkedList<User> users) {
		super(name,lastName,identification,password,username,picture);		
	}

}
