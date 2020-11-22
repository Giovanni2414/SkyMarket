package Model;

public class Fridge extends HomeAppliances{

	private boolean smart;
	private boolean noFridge;
	
	/**
	* name: Fridge
	* Its the constructor of Fridge 
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
	* @param: smart
	* @param: noFridge
	**/
	public Fridge(String name,String code,double price, String description, String picture, int quantity, double weight, double capacity, double wattsConsum, double height ,double widht, boolean smart, boolean noFridge) {
		super(name,code,price,description,picture,quantity,weight,capacity,wattsConsum,height,widht);
		this.smart = smart;
		this.noFridge = noFridge;
	}

	/**
	 * name: isSmart
	 * allows to obtain the boolean smart of the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>obtain the smart boolean of the Fridge saved in variable "smart"</b>
	 * @return smart boolean;
	 */
	public boolean isSmart() {
		return smart;
	}

	/**
	 * name: setSmart
	 * allows entering a new smart boolean for the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>the smart boolean will be saved in the variable "smart"</b>
	 * @param smart boolean
	 */
	public void setSmart(boolean smart) {
		this.smart = smart;
	}

	/**
	 * name: isNoFridge
	 * allows to obtain the boolean noFridge of the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>obtain the noFridge boolean of the Fridge saved in variable "noFridge"</b>
	 * @return smart boolean;
	 */
	public boolean isNoFridge() {
		return noFridge;
	}

	/**
	 * name: setNoFridge
	 * allows entering a new noFridge boolean for the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>the noFridge boolean will be saved in the variable "noFridge"</b>
	 * @param noFridge boolean
	 */
	public void setNoFridge(boolean noFridge) {
		this.noFridge = noFridge;
	}
	
	/**
	 * name: isSmartString
	 * allows to obtain the String smart of the Fridge
	 * <br>Pre:<b>The Fridge object must be created and smart must be entered</b>
	 * <br>Post:<b>obtain the smart String of the Fridge saved in variable "answer"</b>
	 * @return answer;
	 */
	public String isSmartString() {
		String answer;
		answer = (smart)?"SI":"NO";
		return answer;
	}
	
	/**
	 * name: isNoFridgeString
	 * allows to obtain the String noFridge of the Fridge
	 * <br>Pre:<b>The Fridge object must be created and noFridge must be entered</b>
	 * <br>Post:<b>obtain the noFridge String of the Fridge saved in variable "noFridge"</b>
	 * @return answer;
	 */
	public String isNoFridgeString() {
		String answer;
		answer = (noFridge)?"Si":"NO";
		return answer;
	}
}
