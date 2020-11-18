package Model;

public class Order {

	private int orderCode;
	private Article articles;
	
	/*
	name: Order
	Its the constructor of Order 
	@param: codeOrder
	@param: articles
	**/
	public Order(int orderCode, Article articles) {
		this.orderCode = orderCode;
		this.articles = articles;
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
