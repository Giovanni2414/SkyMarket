package Model;

public class Computer extends Technology {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean touch;
	private int numberOfPorts;
	
	/**
	 * Constructor of computer class
	 * <b>pre:</b> 
	 * <b>post:</b> Attributes of computer has been initializated
	 * @param name
	 * @param code
	 * @param price
	 * @param description
	 * @param picture
	 * @param quantity
	 * @param batteryWatts
	 * @param screenSize
	 * @param ram
	 * @param processor
	 * @param numberOfPorts
	 * @param touch
	 */
	public Computer(String name,String code,double price, String description, String picture, int quantity,double batteryWatts, int screenSize, int ram, String processor, int numberOfPorts, boolean touch) {
		super(name,code,price,description,picture,quantity,batteryWatts,screenSize,ram,processor);
		this.touch = touch;
		this.numberOfPorts = numberOfPorts;
	}

	/**
	 * Getter of touch
	 * <b>pre:</b> Variable touch must be initializated
	 * <b>post:</b>
	 * @return A boolean with the touch information
	 */
	public boolean getTouch() {
		return touch;
	}

	/**
	 * Setter of touch variable
	 * <b>pre:</b> 
	 * <b>post:</b> New touch has been setted
	 * @param touch The new tocuh
	 */
	public void setToch(boolean touch) {
		this.touch = touch;
	}
	
	/**
	 * name: isTouchString
	 * allows to obtain the String touch of the computer
	 * <br>Pre:<b>The Computer object must be created and touch must be entered</b>
	 * <br>Post:<b>obtain the smart String of the Computer saved in variable "answer"</b>
	 * @return answer;
	 */
	public String isTouchString() {
		String answer;
		answer = (touch)?"SI":"NO";
		return answer;
	}

	/**
	 * Getter of numberOfPorts
	 * <b>pre:</b> Variable numberOfPorts must be initializated
	 * <b>post:</b>
	 * @return The number of ports
	 */
	public int getNumberOfPorts() {
		return numberOfPorts;
	}

	/**
	 * Setter of numberOfPorts
	 * <b>pre:</b> 
	 * <b>post:</b> A new number of ports has been setted
	 * @param numberOfPorts, the new number of ports
	 */
	public void setNumberOfPorts(int numberOfPorts) {
		this.numberOfPorts = numberOfPorts;
	}
	
}
