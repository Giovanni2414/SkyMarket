package Model;

public class Stove extends HomeAppliances{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfNozzles;
	private String typeStove;
	
	/**
	* name: Stove
	* Its the constructor of Stove 
	* @param: name
	* @param: code
	* @param: price
	* @param: description
	* @param: picture
	* @param: quantity
	* @param: weight
	* @param: capacity
	* @param: wattsConsum
	* @param: height
	* @param: widht
	* @param: numberOfNozzles
	* @param: typeStove
	**/
	public Stove(String name,String code,double price, String description, String picture, int quantity, double weight, double capacity, double wattsConsum, double height ,double widht, int numberOfNozzles, String typeStove) {
		super(name,code,price,description,picture,quantity,weight,capacity,wattsConsum,height,widht);
		this.numberOfNozzles = numberOfNozzles;
		this.typeStove = typeStove;
	}

	/**
	 * name: getNumberOfNozzles
	 * allows to obtain the number of nozzles of the Stove
	 * <br>Pre:<b>The Stove object must be created</b>
	 * <br>Post:<b>obtain the number of nozzles of the Stove saved in variable "numberOfNozzles"</b>
	 * @return numberOfNozzles;
	 */
	public int getNumberOfNozzles() {
		return numberOfNozzles;
	}

	/**
	 * name: setNumberOfNozzles
	 * allows entering a new number of nozzles for the Stove
	 * <br>Pre:<b>The Stove object must be created</b>
	 * <br>Post:<b>the number of nozzles will be saved in the variable "numberOfNozzles"</b>
	 * @param numberOfNozzles
	 */
	public void setNumberOfNozzles(int numberOfNozzles) {
		this.numberOfNozzles = numberOfNozzles;
	}

	/**
	 * name: getTypeStove
	 * allows to obtain the type of stove of the Stove
	 * <br>Pre:<b>The Stove object must be created</b>
	 * <br>Post:<b>obtain the type of stove of the Stove saved in variable "typeStove"</b>
	 * @return typeStove;
	 */
	public String getTypeStove() {
		return typeStove;
	}

	/**
	 * name: setTypeStove
	 * allows entering a new type stove for the Stove
	 * <br>Pre:<b>The Stove object must be created</b>
	 * <br>Post:<b>the type of stove will be saved in the variable "numberOfNozzles"</b>
	 * @param typeStove
	 */
	public void setTypeStove(String typeStove) {
		this.typeStove = typeStove;
	}
}
