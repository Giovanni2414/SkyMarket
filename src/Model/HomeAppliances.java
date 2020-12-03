package Model;

public class HomeAppliances extends Article{

	private static final long serialVersionUID = 1L;
	private double weight;
	private double capacity;
	private double wattsConsum;
	private double height;
	private double width;
	
	/**
	name: HomeAppliaces
	Its the constructor of HomeAppliaces.java 
	@param: name
	@param: code
	@param: price
	@param: description
	@param: picture
	@param: quantity
	@param: weight
	@param: capacity
	@param: wattsConsum
	@param: height
	@param: widht
	**/
	public HomeAppliances(String name,String code,double price, String description, String picture, int quantity, double weight, double capacity, double wattsConsum, double height ,double widht) {
		super(name,code,price,description,picture,quantity);
		this.weight = weight;
		this.capacity = capacity;
		this.wattsConsum = wattsConsum;
		this.height = height;
		this.width = widht;
	}

	/**
	name: getWeght
	allows to obtain the weight of the HomeAppliances
	<b>pre:</b>The HomeAppliances object must be created
	<b>post:</b>obtain the weight of the HomeAppliances saved in variable "weight"
	**/
	public double getWeight() {
		return weight;
	}

	/**
	name: setWeight
	allows entering a new weight for the HomeAppliances
	<b>pre:</b>The HomeAppliences object must be created
	<b>post:</b>the weight will be saved in the variable "weight"
	@param: weight
	**/
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	name: getCapacity
	allows to obtain the capacity of the HomeAppliances
	<b>pre:</b>The HomeAppliances object must be created
	<b>post:</b>obtain the capacity of the HomeAppliances saved in variable "capacity"
	**/
	public double getCapacity() {
		return capacity;
	}

	/**
	name: setCapacity
	allows entering a new capacity for the HomeAppliances
	<b>pre:</b>The HomeAppliences object must be created
	<b>post:</b>the capacity will be saved in the variable "capacity"
	@param: capacity
	**/
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	/**
	name: getWattsConsum
	allows to obtain the wattsConsum of the HomeAppliances
	<b>pre:</b>The HomeAppliances object must be created
	<b>post:</b>obtain the wattsConsum of the HomeAppliances saved in variable "wattsConsum"
	**/
	public double getWattsConsum() {
		return wattsConsum;
	}

	/**
	name: setWattsConsum
	allows entering a new wattsConsum for the HomeAppliances
	<b>pre:</b>The HomeAppliences object must be created
	<b>post:</b>the wattsConsum will be saved in the variable "wattsConsum"
	@param: wattsConsum
	**/
	public void setWattsConsum(double wattsConsum) {
		this.wattsConsum = wattsConsum;
	}

	/*
	name: getHeight
	allows to obtain the height of the HomeAppliances
	<b>pre:</b>The HomeAppliances object must be created
	<b>post:</b>obtain the height of the HomeAppliances saved in variable "height"
	**/
	public double getHeight() {
		return height;
	}
	
	/*
	name: setHeight
	allows entering a new height for the HomeAppliances
	<b>pre:</b>The HomeAppliences object must be created
	<b>post:</b>the height will be saved in the variable "height"
	@param: height
	**/
	public void setHeight(double height) {
		this.height = height;
	}

	/*
	name: getWidht
	allows to obtain the width of the HomeAppliances
	<b>pre:</b>The HomeAppliances object must be created
	<b>post:</b>obtain the width of the HomeAppliances saved in variable "width"
	**/
	public double getWidth() {
		return width;
	}

	/*
	name: setWidht
	allows entering a new width for the HomeAppliances
	<b>pre:</b>The HomeAppliences object must be created
	<b>post:</b>the width will be saved in the variable "width"
	@param: width
	**/
	public void setWidth(double width) {
		this.width = width;
	}

}
