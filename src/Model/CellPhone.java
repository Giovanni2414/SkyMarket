package Model;

public class CellPhone extends Technology{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfSims;
	private int numberOfCameras;
	
	/*
	name: CellPhone
	Its the constructor of CellPhone 
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
	@param: numberOfSims
	@param:numberOfCameras
	**/
	public CellPhone(String name,String code,double price, String description, String picture, int quantity,double batteryWatts, double screenSize, int ram, String processor, int numberOfSims, int numberOfCameras) {
		super(name,code,price,description,picture,quantity,batteryWatts,screenSize,ram,processor);
		this.numberOfSims = numberOfSims;
		this.numberOfCameras = numberOfCameras;
	}

	/*
	name: getNumberOfSims
	allows to obtain the number of sims of the CellPhone
	<b>pre:</b>The CellPhone object must be created
	<b>post:</b>obtain the number of sims of the cell phone saved in variable "numberOfSims"
	**/
	public int getNumberOfSims() {
		return numberOfSims;
	}

	/*
	name: setNumberOfSims
	allows entering a new number of sims for the CellPhone
	<b>pre:</b>The CellPhone object must be created
	<b>post:</b>the number of sims will be saved in the variable "numberOfSims"
	@param: numberOfSims
	**/
	public void setNumberOfSims(int numberOfSims) {
		this.numberOfSims = numberOfSims;
	}

	/*
	name: getNumberOfCameras
	allows to obtain the number of cameras of the CellPhone
	<b>pre:</b>The CellPhone object must be created
	<b>post:</b>obtain the number of cameras of the cell phone saved in variable "numberOfCameras"
	**/
	public int getNumberOfCameras() {
		return numberOfCameras;
	}

	/*
	name: setNumberOfCameras
	allows entering a new number of cameras for the CellPhone
	<b>pre:</b>The CellPhone object must be created
	<b>post:</b>the number of cameras will be saved in the variable "numberOfCameras"
	@param: numberOfCameras
	**/
	public void setNumberOfCameras(int numberOfCameras) {
		this.numberOfCameras = numberOfCameras;
	}
}
