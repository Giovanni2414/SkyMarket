package Model;

import java.time.LocalDate;

public class UserBuyer extends User {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The first node of the basket to buy
	 */
	private Article basket;
	
	/**
	 * The first node of article history buys
	 */
	private Article history;
	
	/**
	* Its the constructor of UserBuyer
	* <br><b>Pre:</b> 
	* <br><b>Post: All the variables will be initializated</b> 
	* @param name The user mainly name
	* @param lastName the user lastname
	* @param identification The user identification
	* @param password The user password
	* @param username The user unique username to enter into the application
	* @param picture The user profile picture path
	**/
	public UserBuyer(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) {
		super(name,lastName,identification,email,password,username,picture,birthday);
		basket = null;
		history = null;
	}
	
	/**
	* allows to obtain the basket of the user buyer
	* <br><b>Pre: The UserBuyer object must be created</b> 
	* <br><b>Post: obtain the basket of the user buyer saved in variable "basket"</b> 
	* @return The first node of the basket buys
	**/
	public Article getBasket() {
		return basket;
	}
	
	/**
	* Allows entering a new basket for the user buyer
	* <br><b>Pre: The UserBuyer object must be created</b> 
	* <br><b>Post: the basket will be saved in the variable "basket"</b> 
	* @param basket
	**/
	public void setBasket(Article basket) {
		this.basket = basket;
	}
	
	/**
	* Allows to obtain the history sales of the user buyer
	* <br><b>Pre: The UserBuyer object must be created</b> 
	* <br><b>Post: obtain the history sales of the user buyer saved in variable "history"</b> 
	* @return The first node of the history buys
	**/
	public Article getHistory() {
		return history; 
	}
	
	/**
	* Allows entering a new history sales for the user buyer
	* <br><b>Pre: The UserBuyer object must be created</b> 
	* <br><b>Post: the history sales will be saved in the variable "history"</b> 
	* @param history The new first node of the history buys
	**/
	public void setHistory(Article history) {
		this.history = history;
	}
	
<<<<<<< HEAD
	public void addArticleToHistory(Article newArticle) {
=======
	/**
	 * Method to add a new article to the bastek adding a new node
	 * <br><b>Pre:</b>
	 * <br><b>Post: A new node has been added to the history buys</b>
	 * @param newArticle
	 */
	public void addArticleToBasket(Article newArticle) {
>>>>>>> 1fb2da4d68b0fa3314ee7f1e71c7ce1d013b7993
		if(history == null) {
			history = newArticle;
		}else {
			addArticleToHistory(history.getNextArticle(), newArticle);
		}
	}
	
<<<<<<< HEAD
	public void addArticleToHistory(Article current, Article newArticle) {
		if(current==null) {
			current=newArticle;
=======
	/**
	 * Recursive method to add a new node into the basket history buys
	 * <br><b>Pre:</b> First node of article must be initializated
	 * <br><b>Post:</b> A new node has been added to the history
	 * @param current The current node to value
	 * @param newArticle The new article node to add
	 */
	public void addArticleToBasket(Article current, Article newArticle) {
		if(current.getNextArticle()==null) {
			current.setNextArticle(newArticle);
>>>>>>> 1fb2da4d68b0fa3314ee7f1e71c7ce1d013b7993
		}else {
			addArticleToHistory(current.getNextArticle(), newArticle);
		}
	}
}
