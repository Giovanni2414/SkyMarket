package Model;

import java.io.Serializable;

public class Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private double price;
	private String description;
	private String picture;
	private int quantity;
	private Article nextArticle;
	private Article prevArticle;
	private String nameSeller;
	
	/*
	name: Article
	Its the constructor of Article 
	@param: name
	@param: code
	@param: price
	@param: description
	@param: picture
	@param: quantity
	**/
	public Article(String name,String code,double price, String description, String picture, int quantity) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.quantity = quantity;
		this.nameSeller = null;
		nextArticle = null;
		prevArticle = null;
	}

	/*
	name: getName
	allows to obtain the name of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the name of the article saved in variable "name"
	**/
	public String getName() {
		return name;
	}
	
	/*
	name: setName
	allows entering a new name for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the name will be saved in the variable "name"
	@param: name
	**/
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	name: getCode
	allows to obtain the code of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the code of the article saved in variable "code"
	**/
	public String getCode() {
		return code;
	}
	
	/*
	name: setCode
	allows entering a new code for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the code will be saved in the variable "code"
	@param: code
	**/
	public void setCode(String code) {
		this.code = code;
	}
	
	/*
	name: getPrice
	allows to obtain the price of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the price of the article saved in variable "price"
	**/
	public double getPrice() {
		return price;
	}
	
	/*
	name: setPrice
	allows entering a new price for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the price will be saved in the variable "price"
	@param: price
	**/
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	name: getDescription
	allows to obtain the description of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the description of the article saved in variable "description"
	**/
	public String getDescription() {
		return description;
	}
	
	/*
	name: setDescription
	allows entering a new description for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the description will be saved in the variable "description"
	@param: description
	**/
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	name: getPicture
	allows to obtain the path picture of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the path picture of the article saved in variable "picture"
	**/
	public String getPicture() {
		return picture;
	}
	
	/*
	name: setPicture
	allows entering a new path picture for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the path picture will be saved in the variable "picture"
	@param: picture
	**/
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/*
	name: getQuantity
	allows to obtain the quantity of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the quantity of the article saved in variable "quantity"
	**/
	public int getQuantity() {
		return quantity;
	}
	
	/*
	name: setQuantity
	allows entering a new quantity for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the quantity will be saved in the variable "quantity"
	@param: quantity
	**/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/*
	name: getNextArticle
	allows to obtain the next article of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the next article of the article saved in variable "nextArticle"
	**/
	public Article getNextArticle() {
		return nextArticle;
	}
	
	/*
	name: setNextArticle
	allows entering a new next article for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the next article will be saved in the variable "nextArticle"
	@param: nextArticle
	**/
	public void setNextArticle(Article nextArticle) {
		this.nextArticle = nextArticle;
	}

	/*
	name: getPrevArticle
	allows to obtain the prev article of the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>obtain the prev article of the article saved in variable "prevArticle"
	**/
	public Article getPrevArticle() {
		return prevArticle;
	}

	/*
	name: setPrevArticle
	allows entering a new prev article for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the prev article will be saved in the variable "prevArticle"
	@param: prevArticle
	**/
	public void setPrevArticle(Article prevArticle) {
		this.prevArticle = prevArticle;
	}

	public String getNameSeller() {
		return nameSeller;
	}

	public void setNameSeller(String nameSeller) {
		this.nameSeller = nameSeller;
	}
	
	
}
