package Model;

public class Technology extends Article{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double batteryWatts;
	private double screenSize;
	private int ram;
	private String processor; 
	
	/*
	name: Technology
	Its the constructor of Technology 
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
	**/
	public Technology(String name,String code,double price, String description, String picture, int quantity,double batteryWatts, double screenSize, int ram, String processor) {
		super(name,code,price,description,picture,quantity);
		this.batteryWatts = batteryWatts;
		this.screenSize = screenSize;
		this.ram = ram;
		this.processor = processor;
	}

	/*
	name: getBatteryWhatts
	allows to obtain the batteryWatts of the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>obtain the watts to the batery of the technology saved in variable "batteryWatts"
	**/
	public double getBatteryWatts() {
		return batteryWatts;
	}

	/*
	name: setBatteryWatts
	allows entering a new batteryWatts for the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>the watts of battery will be saved in the variable "batteryWatts"
	@param: batteryWatts
	**/
	public void setBatteryWatts(double batteryWatts) {
		this.batteryWatts = batteryWatts;
	}

	/*
	name: getScreenSize
	allows to obtain the size screen of the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>obtain the size to the screen of the technology saved in variable "screenTechnology"
	**/
	public double getScreenSize() {
		return screenSize;
	}

	/*
	name: setScreenSize
	allows entering a new size screen for the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>the screen size will be saved in the variable "screenSize"
	@param: screenSize
	**/
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	/*
	name: getRam
	allows to obtain the ram of the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>obtain the ram of the technology saved in variable "ram"
	**/
	public int getRam() {
		return ram;
	}

	/*
	name: setRam
	allows entering a new ram for the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>the ram will be saved in the variable "ram"
	@param: ram
	**/
	public void setRam(int ram) {
		this.ram = ram;
	}

	/*
	name: getProcessor
	allows to obtain the proccesor of the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>obtain the proccesor of the technology saved in variable "processor"
	**/
	public String getProcessor() {
		return processor;
	}

	/*
	name: setProcessor
	allows entering a new processor for the technology
	<b>pre:</b>The Technology object must be created
	<b>post:</b>the processor will be saved in the variable "processor"
	@param: processor
	**/
	public void setProcessor(String processor) {
		this.processor = processor;
	}
}
