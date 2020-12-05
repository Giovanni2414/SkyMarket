package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Administraitor extends User{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ArrayList to save and show all users in the app
	 */
	private ArrayList<User> users;
	
	/**
	 * ArrayList to save and show all articles in the app
	 */
	private ArrayList<Article> articles;
	
	/**
	* Its the constructor of Administraitor
	* @param: name 
	* @param: lastName 
	* @param: identification 
	* @param: password 
	* @param: username 
	* @param: picture 
	**/
	public Administraitor(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday,LinkedList<User> users) {
		super(name,lastName,identification,email,password,username,picture,birthday);
		this.users = new ArrayList<>(users);
		//duda con cambio de LinkedList a ArrayList
	}
	
	/**
	 * Getter of ArrayList users
	 * <br><b>Pre:<b> ArrayList users must be initializated
	 * <br><b>Post:<b>
	 * @return The ArrayList with the users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * Setter of users ArrayList
	 * <br><b>Pre:<b> 
	 * <br><b>Post:<b> A new list of users has been setted
	 * @param users 
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * Getter of articles ArrayList
	 * <br><b>Pre:<b> ArrayList articles must be initializated
	 * <br><b>Post:<b>
	 * @return Return the ArrayList with articles
	 */
	public ArrayList<Article> getArticles() {
		return articles;
	}

	/**
	 * Setter of Articles ArrayList
	 * <br><b>Pre:<b>
	 * <br><b>Post:<b> A new ArrayList with articles has been setted
	 * @param articles The new ArrayList with articles
	 */
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

}
