package Model;

import java.util.Date;

public class Order {

	private Date date; 
	private int orderCode;
	private Article articles;
	
	/*
	name: Order
	Its the constructor of Order 
	@param: date
	@param: codeOrder
	@param: articles
	**/
	public Order(int orderCode, Article articles) {
		this.date = new java.util.Date();
		this.orderCode = orderCode;
		this.articles = articles;
	}

	/*
	name: getDate
	allows to obtain the date of the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>obtain the date of the Order saved in variable "date"
	**/
	public Date getDate() {
		return date;
	}

	/*
	name: setDate
	allows entering a new date for the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>the date will be saved in the variable "date"
	@param: date
	**/
	public void setDate(Date date) {
		this.date = date;
	}
	
	/*
	name: getOrderCode
	allows to obtain the code order of the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>obtain the orderCode of the Order saved in variable "orderCode"
	**/
	public int getOrderCode() {
		return orderCode;
	}

	/*
	name: setOrderCode
	allows entering a new order code  for the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>the order code will be saved in the variable "orderCode"
	@param: orderCode
	**/
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	/*
	name: getArticles
	allows to obtain the articles of the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>obtain the articles of the Order saved in variable "articles"
	**/
	public Article getArticles() {
		return articles;
	}

	/*
	name: setArticles
	allows entering a new articles  for the Order
	<b>pre:</b>The Order object must be created
	<b>post:</b>the articles will be saved in the variable "articles"
	@param: articles
	**/
	public void setArticles(Article articles) {
		this.articles = articles;
	}
	
	

}
