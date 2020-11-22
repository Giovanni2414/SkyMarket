package Model;

public class TV extends Technology{

	private boolean smart;
	private int numberOfPorts; 
	
	/*
	name: TV
	Its the constructor of TV 
	@param: name
	@param: code
	@param: price
	@param: description
	@param: picture
	@param: quantity
	@param: bateryWatts
	@param: screenSize
	@param: ram
	@param: processor
	@param: smart
	@param: numberOfPorts
	**/
	public TV(String name,String code,double price, String description, String picture, int quantity,double batteryWatts, int screenSize, int ram, String processor, boolean smart, int numberOfPorts) {
		super(name,code,price,description,picture,quantity,batteryWatts,screenSize,ram,processor);
		this.smart = smart;
		this.numberOfPorts = numberOfPorts;
	}

	/*
	name: isSmart
	allows to obtain the smart boolean of the TV
	<b>pre:</b>The TV object must be created
	<b>post:</b>obtain the smart boolean of the TV saved in variable "smart"
	return smart boolean;
	**/
	public boolean isSmart() {
		return smart;
	}

	/*
	name: setSmart
	allows entering a new smart boolean for the TV
	<b>pre:</b>The TV object must be created
	<b>post:</b>the smart boolean will be saved in the variable "smart"
	@param: smart
	**/
	public void setSmart(boolean smart) {
		this.smart = smart;
	}

	/*
	name: getNumberOfPorts
	allows to obtain the number o ports of the TV
	<b>pre:</b>The TV object must be created
	<b>post:</b>obtain the number of ports of the TV saved in variable "numberOfPorts"
	return numberOfPort
	**/
	public int getNumberOfPorts() {
		return numberOfPorts;
	}

	/*
	name: setNumberOfPorts
	allows entering a new number of ports for the TV
	<b>pre:</b>The TV object must be created
	<b>post:</b>the number of ports will be saved in the variable "numberOfPorts"
	@param: numberOfPorts
	**/
	public void setNumberOfPorts(int numberOfPorts) {
		this.numberOfPorts = numberOfPorts;
	}
	
	/*
	name: isSmart
	allows to obtain the smart boolean of the TV
	<b>pre:</b>The TV object must be created
	<b>post:</b>obtain the smart boolean of the TV saved in variable "smart"
	@return Return Yes or No according to the boolean if it is true or false
	**/
	public String isSmartString() {
		String answer;
		answer = (smart)?"SI":"NO";
		return answer;
	}

}
