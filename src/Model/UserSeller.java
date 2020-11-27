package Model;

import java.time.LocalDate;

public class UserSeller extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double calification;
	private Article history; 
	private Article sellArticles;
	
	/*
	name: UserSeller
	Its the constructor of UserSeller
	@param: name
	@param: lastName
	@param: identification
	@param: email
	@param: password
	@param: username
	@param: picture
	@param: bithday
	**/
	public UserSeller(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) {
		super(name,lastName,identification,email,password,username,picture,birthday);
		calification = 0;
		history = null;
		sellArticles = null;
	}

	/*
	name: getCalification
	allows to obtain the calification of the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>obtain the calification of the user seller saved in variable "calification"
	**/
	public double getCalification() {
		return calification;
	}

	/*
	name: setCalification
	allows entering a new calification for the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>the calification will be saved in the variable "calification"
	@param: calification
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

	/*
	name: setHistory
	allows entering a new history for the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>the history will be saved in the variable "history"
	@param: history
	**/
	public void setHistory(Article history) {
		this.history = history;
	}

	/*
	name: getSellArticles
	allows to obtain the items sold of the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>obtain the items sold of the user seller saved in the linked list "sellArticles"
	**/
	public Article getSellArticles() {
		return sellArticles;
	}

	/*
	name: setSellArticles
	allows entering a items sold for the user seller
	<b>pre:</b>The UserSeller object must be created
	<b>post:</b>the items sold will be saved in the linked list "sellArticles"
	@param: sellArticles
	**/
	public void setSellArticles(Article sellArticles) {
		this.sellArticles = sellArticles;
	}
	
	public void addArticleToArticlesSeller(Article newArticle) {
		if(sellArticles == null) {
			sellArticles = newArticle;
		}else {
			addArticleToSellArticles(history, newArticle);
		}
	}
	
	public void addArticleToSellArticles(Article current,Article newArticle) {
		if(current.getNextArticle() == null) {
			current.setNextArticle(newArticle);
		}else {
			addArticleToSellArticles(current.getNextArticle(), newArticle);
		}
	}
	
	public void addArticleToHistory(Article newArticle) {
		if(history == null) {
			history = newArticle;
		}else {
			addArticleToHistory(history, newArticle);
		}
	}
	
	public void addArticleToHistory(Article current, Article newArticle) {
		if(current.getNextArticle() == null) {
			current.setNextArticle(newArticle);
		}else {
			addArticleToHistory(current.getNextArticle(), newArticle);
		}
	}
}
