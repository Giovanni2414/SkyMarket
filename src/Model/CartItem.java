package Model;

public class CartItem {
	
	
	/**
	 * Name of the Cart Item
	 */
	private String name;
	
	/**
	 * Code of the Cart Item
	 */
	private String code;
	
	/**
	 * Price of the Cart Item
	 */
	private double price;
	
	/**
	 * Description of the Cart Item
	 */
	private String description;
	

	/**
	 * Quantity of the Cart Item
	 */
	private int quantity;
	/**
	 * Right node to use in binary tree
	 */

	private CartItem right;

	/**
	 * Left node to use in binary tree
	 */
	private CartItem  left;
	
	/**
	 * Father node to c in binary tree
	 */
	private CartItem  father;
	
	
	private Article article;
	

	
	
	
	
	public CartItem(Article article, int quantity) {
		this.article = article;
		this.quantity = quantity;
		
		name=article.getName();
		code=article.getCode();
		price=article.getPrice();
		description=article.getDescription();
		right=null;
		left=null;
		father=null;
		
	}

	public CartItem getRight() {
		return right;
	}

	public void setRight(CartItem right) {
		this.right = right;
	}

	public CartItem getLeft() {
		return left;
	}

	public void setLeft(CartItem left) {
		this.left = left;
	}

	public CartItem getFather() {
		return father;
	}

	public void setFather(CartItem father) {
		this.father = father;
	}

	public Article getArticle() {
		return article;
	}


	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

	
}
