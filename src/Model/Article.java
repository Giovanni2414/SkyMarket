package Model;

import java.io.Serializable;

public class Article implements Serializable, Cloneable{
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of the article
	 */
	private String name;
	
	/**
	 * Code of the article
	 */
	private String code;
	
	/**
	 * Price of the article
	 */
	private double price;
	
	/**
	 * Description of the article
	 */
	private String description;
	
	/**
	 * Representative picture of the article
	 */
	private String picture;
	
	/**
	 * Quantity of the article
	 */
	private int quantity;
	
	/**
	 * Next node of article to enlaced list
	 */
	private Article nextArticle;
	
	/**
	 * Previous node of article to enlaced list
	 */
	private Article prevArticle;
	
	/**
	 * The owner seller of the product
	 */
	private String nameSeller;
	
	/**
	* Its the constructor of Article 
	* <br><b>Pre:<b> 
	* <br><b>Post:<b> All variables initializated
	* @param: name
	* @param: code
	* @param: price
	* @param: description
	* @param: picture
	* @param: quantity
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

	/**
	* Allows to obtain the name of the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>obtain the name of the article saved in variable "name"
	* @return The name of the article
	**/
	public String getName() {
		return name;
	}
	
	/**
	* Allows entering a new name for the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>the name will be saved in the variable "name"
	* @param name The new name to set
	**/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Allows to obtain the code of the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>obtain the code of the article saved in variable "code"
	* @return Return the article code
	**/
	public String getCode() {
		return code;
	}
	
	/**
	* Allows entering a new code for the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>the code will be saved in the variable "code"
	* @param code The new article to set
	**/
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	* Allows to obtain the price of the article
	* <br><b>Pre:<b> The Article object must be created
	* <br><b>Post:<b> Obtain the price of the article saved in variable "price"
	* @return
	**/
	public double getPrice() {
		return price;
	}
	
	/**
	* Allows entering a new price for the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>the price will be saved in the variable "price"
	* @param price The new article price to set
	**/
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	* allows to obtain the description of the article
	* <br><b>Pre:<b>The Article object must be created
	* <br><b>Post:<b>Obtain the description of the article saved in variable "description"
	* @return Return the article description
	**/
	public String getDescription() {
		return description;
	}
	
	/**
	name: setDescription
	allows entering a new description for the article
	<b>pre:</b>The Article object must be created
	<b>post:</b>the description will be saved in the variable "description"
	@param: description
	**/
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	* Allows to obtain the path picture of the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>obtain the path picture of the article saved in variable "picture"
	* @return Return the path picture
	**/
	public String getPicture() {
		return picture;
	}
	
	/**
	* Allows entering a new path picture for the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>the path picture will be saved in the variable "picture"
	* @param picture The new path of picture to set
	**/
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	* allows to obtain the quantity of the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>obtain the quantity of the article saved in variable "quantity"
	* @return Return the actual quantity of this product
	**/
	public int getQuantity() {
		return quantity;
	}
	
	/**
	* Allows entering a new quantity for the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>the quantity will be saved in the variable "quantity"
	* @param quantity The new quantity to set
	**/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	* Allows to obtain the next article of the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>obtain the next article of the article saved in variable "nextArticle"
	* @return Return the next node of enlaced list
	**/
	public Article getNextArticle() {
		return nextArticle;
	}
	
	/**
	* Allows entering a new next article for the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>the next article will be saved in the variable "nextArticle"
	* @param nextArticle The new next node to set in the enlaced list
	**/
	public void setNextArticle(Article nextArticle) {
		this.nextArticle = nextArticle;
	}

	/**
	* Allows to obtain the prev article of the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>obtain the prev article of the article saved in variable "prevArticle"
	* @return Return the prev node in the enlaced list
	**/
	public Article getPrevArticle() {
		return prevArticle;
	}

	/**
	* Allows entering a new prev article for the article
	* <b>pre:</b>The Article object must be created
	* <b>post:</b>the prev article will be saved in the variable "prevArticle"
	* @param prevArticle The new previous node to set in the enlaced list
	**/
	public void setPrevArticle(Article prevArticle) {
		this.prevArticle = prevArticle;
	}

	/**
	 * Getter of name seller
	 * <br><b>Pre:<b> The variable must be initializated
	 * <br><b>Post:<b> 
	 * @return The name seller of this article
	 */
	public String getNameSeller() {
		return nameSeller;
	}

	/**
	 * Setter of name seller
	 * <br><b>Pre:<b> 
	 * <br><b>Post:<b> New name seller setted
	 * @param nameSeller The new name seller to set
	 */
	public void setNameSeller(String nameSeller) {
		this.nameSeller = nameSeller;
	}
	
	public Article clone() throws CloneNotSupportedException {
		Article articleToClone = (Article)super.clone();
		return articleToClone;
	}
}
