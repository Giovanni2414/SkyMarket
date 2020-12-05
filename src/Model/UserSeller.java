package Model;

import java.time.LocalDate;

public class UserSeller extends User{
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The calification of the seller based on their sales
	 */
	private double calification;
	
	/**
	 * The first node of the history of sales
	 */
	private Article history; 
	
	/**
	 * The first node of articles to sell
	 */
	private Article sellArticles;
	
	/**
	 * If the Seller has been banned or not from the application
	 */
	private boolean ban;
	
	/***
	* Its the constructor of UserSeller
	* <br><b>Pre:</b> 
	* <br><b>Post: All variables will be initializated</b> 
	* @param: name The name of the user
	* @param: lastName The user lastname
	* @param: identification The user identification
	* @param: email The user email
	* @param: password The user password
	* @param: username The user username unique to enter into the application
	* @param: picture The path of profile picture
	* @param: birthday The user birthday
	*/
	public UserSeller(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) {
		super(name,lastName,identification,email,password,username,picture,birthday);
		calification = 0;
		history = null;
		sellArticles = null;
		ban = false;
	}
	
	/***
	* Allows to obtain the ban of the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: obtain the ban of the user seller saved in variable "ban"</b>
	* @return If the user is banned or not
	**/
	public boolean isBan() {
		return ban;
	}
	
	/**
	* Allows entering a new ban for the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: the ban will be saved in the variable "ban"</b>
	* @param ban New status of banner of the user
	*/
	public void setBan(boolean ban) {
		this.ban = ban;
	}

	/**
	* Allows to obtain the calification of the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: obtain the calification of the user seller saved in variable "calification"</b>
	* @return The calification of the seller
	*/
	public double getCalification() {
		return calification;
	}

	/**
	* Allows entering a new calification for the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: the calification will be saved in the variable "calification"</b>
	* @param calification The new calification for the seller
	**/
	public void setCalification(double calification) {
		this.calification = calification;
	}

	/*
	name: getHistory
	allows to obtain the history of the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>obtain the history of the user seller saved in variable "history"
	**/
	public Article getHistory() {
		return history;
	}

	/**
	* Allows entering a new history for the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: the history will be saved in the variable "history"</b>
	* @param history The new first node about history tree to set
	**/
	public void setHistory(Article history) {
		this.history = history;
	}

	/**
	* Allows to obtain the items sold of the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: obtain the items sold of the user seller saved in the linked list "sellArticles"</b>
	* @return The first node of sellArticles binary tree
	**/
	public Article getSellArticles() {
		return sellArticles;
	}

	/**
	* Allows entering a items sold for the user seller
	* <br><b>Pre: The UserSeller object must be created</b>
	* <br><b>Post: the items sold will be saved in the linked list "sellArticles"</b>
	* @param sellArticles The new first node of binary tree sell Articles
	**/
	public void setSellArticles(Article sellArticles) {
		this.sellArticles = sellArticles;
	}
	
	/**
	 * Method to add a primary node into sell Articles
	 * <br><b>Pre:</b> 
	 * <br><b>Post:</b> A new first node has been setted into sell Articles
	 * @param newArticle The new article to set how root
	 */
	public void addArticleToArticlesSeller(Article newArticle) {
		if(sellArticles == null) {
			sellArticles = newArticle;
		}else {
			addArticleToSellArticles(sellArticles, newArticle);
		}
	}
	
	/**
	 * Recursive method to add a new node into sell articles list
	 * <br><b>Pre:</b> The first node must be initializated
	 * <br><b>Post:</b> A new node has been added into sell articles list
	 * @param current The current article to value
	 * @param newArticle The new article to add
	 */
	public void addArticleToSellArticles(Article current,Article newArticle) {
		if(current.getNextArticle() == null) {
			current.setNextArticle(newArticle);
		}else {
			addArticleToSellArticles(current.getNextArticle(), newArticle);
		}
	}
	
	/**
	 * Method to modify the available quantity of an article
	 * <br><b>Pre:</b> The article target and list must be initializated
	 * <br><b>Post:</b> The available quantity of the articles has been changed
	 * @param codeProduct The code of product to modify the quantity
	 * @param quantity The new quantity to set
	 */
	public void modifyQuantity(String codeProduct, int quantity) {
		if(sellArticles.getCode().equals(codeProduct)) {
			sellArticles.setQuantity(sellArticles.getQuantity()-quantity);
		}else {
			modifyQuantity(sellArticles.getNextArticle(), codeProduct, quantity);
		}
	}
	
	/**
	 * Recursive method to modify the available of a product
	 * <br><b>Pre: The node of this article must be initializated</b>
	 * <br><b>Post: The quantity of this article has been changed</b>
	 * @param current The current node to value
	 * @param codeProduct The code of product to change de quantity
	 * @param quantity The new available quantity to set
	 */
	public void modifyQuantity(Article current, String codeProduct, int quantity) {
		if(current.getCode().equals(codeProduct)) {
			current.setQuantity(current.getQuantity()-quantity);
		}else {
			modifyQuantity(current.getNextArticle(), codeProduct, quantity);
		}
	}
	
	/**
	 * Method to set a new root of the history of sales
	 * <br><b>Pre:</b>
	 * <br><b>Post: A new root has been setted</b>
	 * @param newArticle
	 */
	public void addArticleToHistory(Article newArticle) {
		if(history == null) {
			history = newArticle;
		}else {
			addArticleToHistory(history, newArticle);
		}
	}
	
	/**
	 * Method helper of addArticleToHistory  with the function of add a new node into the history
	 * <br><b>Pre: A principal root must be initializated</b>
	 * <br><b>Post: A new node has been added</b>
	 * @param current The current node to value
	 * @param newArticle The new node to add into the list
	 */
	public void addArticleToHistory(Article current, Article newArticle) {
		if(current.getNextArticle() == null) {
			current.setNextArticle(newArticle);
		}else {
			addArticleToHistory(current.getNextArticle(), newArticle);
		}
	}
}
