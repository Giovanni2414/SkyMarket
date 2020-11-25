package Model;

import java.time.LocalDate;

public class UserBuyer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article basket;
	private Article history;
	
	/*
	name: UserBuyer
	Its the constructor of UserBuyer
	@param: name
	@param: lastName
	@param: identification
	@param: password
	@param: username
	@param: picture
	**/
	public UserBuyer(String name, String lastName, String identification,String email, String password, String username, String picture, LocalDate birthday) {
		super(name,lastName,identification,email,password,username,picture,birthday);
		basket = null;
		history = null;
	}
	
	/*
	name: getBasket
	allows to obtain the basket of the user buyer
	<b>pre:</b>The UserBuyer object must be created
	<b>post:</b>obtain the basket of the user buyer saved in variable "basket"
	**/
	public Article getBasket() {
		return basket;
	}
	
	/*
	name: setBasket
	allows entering a new basket for the user buyer
	<b>pre:</b>The UserBuyer object must be created
	<b>post:</b>the basket will be saved in the variable "basket"
	@param: basket
	**/
	public void setBasket(Article basket) {
		this.basket = basket;
	}
	
	/*
	name: getHistory
	allows to obtain the history sales of the user buyer
	<b>pre:</b>The UserBuyer object must be created
	<b>post:</b>obtain the history sales of the user buyer saved in variable "history"
	**/
	public Article getHistory() {
		return history; 
	}
	
	/*
	name: setHistory
	allows entering a new history sales for the user buyer
	<b>pre:</b>The UserBuyer object must be created
	<b>post:</b>the history sales will be saved in the variable "history"
	@param: history
	**/
	public void setHistory(Article history) {
		this.history = history;
	}
}
