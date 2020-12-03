package Model;

public class Fridge extends HomeAppliances{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean smart;
	private boolean frost;
	
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
	* @param: frost
	**/
	public Fridge(String name,String code,double price, String description, String picture, int quantity, double weight, double capacity, double wattsConsum, double height ,double widht, boolean smart, boolean frost) {
		super(name,code,price,description,picture,quantity,weight,capacity,wattsConsum,height,widht);
		this.smart = smart;
		this.frost = frost;
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
	 * name: isFrost
	 * allows to obtain the boolean frost of the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>obtain the frost boolean of the Fridge saved in variable "frost"</b>
	 * @return frost boolean;
	 */
	public boolean isFrost() {
		return frost;
	}

	/**
	 * name: setFrost
	 * allows entering a new frost boolean for the Fridge
	 * <br>Pre:<b>The Fridge object must be created</b>
	 * <br>Post:<b>the frost boolean will be saved in the variable "frost"</b>
	 * @param frost boolean
	 */
	public void setFrost(boolean noFridge) {
		this.frost = noFridge;
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
	 * name: isFrostString
	 * allows to obtain the String frost of the Fridge
	 * <br>Pre:<b>The Fridge object must be created and noFridge must be entered</b>
	 * <br>Post:<b>obtain the frost String of the Fridge saved in variable "answer"</b>
	 * @return answer;
	 */
	public String isFrostString() {
		String answer;
		answer = (frost)?"SI":"NO";
		return answer;
	}
}
