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
	public Administraitor(String name, String lastName, String identification,String email, String password, String username, String picture, LinkedList<User> users) {
		super(name,lastName,identification,email,password,username,picture);
		//duda con cambio de LinkedList a ArrayList
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

}
