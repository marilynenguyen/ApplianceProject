//-----------------------------
//Assignment #1
//Part 1
//Written by: Steven Lam(40226649) and Marilyne Nguyen(40228396)
//-----------------------------

/**
 * The Appliance class is composed of all the attributes of each object of the class 
 * It contains all the methods to create objects and that can be used on them
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *COMP249
 *Assignment #1
 *Due Date: October 7 2022
 */

public class Appliance {
	//Attributes
	private String type; 
	private String brand; 
	private long serialNumber;
	private double price; 
	private static int counter= 0;
	
	
	/**
	 * Default constructor for the Appliance class to set all the variables of an Appliance object to default values
	 */
	Appliance (){
		counter++;
	}
	
	/**
	 * Parameterized constructor for the Appliance class to set all the variables of an Appliance object to user's input
	 * @param type a String value
	 * @param brand another String value
	 * @param serialNumber a value of long data type
	 * @param price a double value
	 */
	Appliance (String type, String brand, long serialNumber, double price){
		this.type = type; 
		this.brand = brand; 
		this.serialNumber = serialNumber; 
		this.price = price; 

		counter++;
	}
	
	/**
	 * Copy constructor for the Appliance class to copy an already existing Appliance object
	 * @param object an Appliance object
	 */
	Appliance (Appliance object){
		this.type = object.type; 
		this.brand = object.brand; 
		this.serialNumber = object.serialNumber; 
		this.price = object.price; 
	}

	/**
	 * @return a String type for a specific Appliance object
	 */
	public String getType() {
		return type;
	}

	
	/**
	 * A method that verifies if the type entered by the user is within the acceptable values. It does so while ignoring the 
	 * case of the characters entered. If the value's accepted, then we set the variable type to the value entered, if not 
	 * we return the default value.
	 * @param type String 
	 */
	public void setType(String type) {
		
		if(type.equalsIgnoreCase("Fridge") || type.equalsIgnoreCase("AirConditioner") || type.equalsIgnoreCase("Washer") 
				|| type.equalsIgnoreCase("Dryer")|| type.equalsIgnoreCase("Freezer") || type.equalsIgnoreCase("Stove")
				|| type.equalsIgnoreCase("Dishwasher") || type.equalsIgnoreCase("WaterHeaters") || type.equalsIgnoreCase("Microwave")) {
			
			this.type = type;
		}
		else {
			System.out.println("Error: the appliance's type you entered does not exist.");
			this.type = getType();
		}
	}

	
	/**
	 * @return a String Brand of a specific Appliance object
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * A method to set the input from the user to the brand variable
	 * @param brand String
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return a long serialNumber of a specific Appliance object
	 */
	public  long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * A method to set the input from the user to the serialNumber variable
	 * @param serialNumber long
	 */
	public  void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return an double of a specific Appliance object
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * A method that verifies if the price entered for the appliance is within the acceptable bounds. If the price is 
	 * valid, the method sets the user input to the price variable, if else it sets it to its default value
	 * @param price double
	 */
	public void setPrice(double price) {
		
		//Verifies that the price is within acceptable bounds
		if (price >= 1) {
			//If price is accepted, then set the user input to the price variable
			this.price = price;
		}
		//If user input not accepted for price variable
		else {
			//Message to indicate to the user that the price entered isn't accepted
			System.out.println("The price that you entered is not within acceptable bounds");
			//return default value for price variable
			this.price = getPrice();
		}
	}
	
	
	/**
	 * A method that returns the information of a specific Appliance object. This method override the original toString()
	 * method from the object superclass
	 */
	public String toString() {
		//Print the information of a specific Appliance
		return 	"Appliance Serial # " + getSerialNumber() + "\nBrand: " + getBrand() + "\nType: " + getType() +
		"\nPrice: " + getPrice() + "$\n";
	}
	
	
	/**
	 * A method that verifies the amount of objects created, if it is bigger than 0, it will return the 
	 * counter's value, if not it will return 0
	 * @return an integer value that indicates the total amount of Appliance object created
	 */
	public static int findNumberOfCreateAppliances() {
		
		//Verifies that there are Appliances created
		if (counter > 0) {
			//return the total amount of Appliances created
			return counter;
		}
		//If no Appliance is created
		else {
			//Return value 0
			return 0;
		}
	}
	
	/**
	 * A method that verifies if two Appliance objects are identical by comparing the value of their variables. If they're
	 * the same return true, if not return false
	 * @param object Appliance object
	 * @return boolean
	 */
	
	//Method to find if there are similar object within our inventory
	public boolean equals(Appliance object) {
		//Verifies that the attributes of both objects are all the same
		if (this.type.equals(object.type) && this.brand.equals(object.brand) &&
		    this.price == object.price) {
			//Message to indicate the user that match has been found
			System.out.println("Both appliances are the same.");
			//if information is the same return true
			return true;
		}
		//If no match is found in the inventory
		else {
			//Message to indicate that no match has been found
			System.out.println("Both appliances are not the same.");
			//if information isn't the same return false
			return false;
		}
	}
	
	
	/**
	 * A method that verifies how many existing appliance have the same brand 
	 * @param brandName 
	 * @param ourAppliances
	 * @return 
	 */
	public static Appliance[] findAppliancesBy (String brandName, Appliance[] ourAppliances) {
		//variable that's going to be incremented every time we find an Appliance with the brand name that the user is looking for
		int counterBrand = 0;
		
		//Loop through our Appliances array to find all Appliances with the same brand name
		for (int i = 0 ; i < findNumberOfCreateAppliances() ; i++) {
			if (brandName.equals(ourAppliances[i].getBrand())) {
				//if we find match, we increment our counter for the elements of same brand
				counterBrand++;
			}
		}
		
		//If no match is found, we enter this loop
		if (counterBrand == 0) {
			//Message to indicate the user that there is no match
			System.out.println("No match found \n");
			//Returning our original array
			return ourAppliances;
		}
		
	
		//Creating a new array of length counterBrand to store all the elements of the same brandName
		Appliance[] sameBrandArray = new Appliance[counterBrand];
		
		int index = 0; 
		//Loop through our inventory array
		for (int j = 0; j < findNumberOfCreateAppliances() ; j++) {
			//If brandName are the same
			if (brandName.equals(ourAppliances[j].getBrand())) {
				//Adding that object in the sameBrandArray
				sameBrandArray[index] = ourAppliances[j];
				index++; 
			}
		}
		
		//Returning our array with all elements of same brand
		return sameBrandArray;
		
	}
	
	/**
	 * Method to find all the Appliances in the inventory for which the price is less than a specific price entered by user
	 * @param searchPrice
	 * @param ourAppliances
	 * @return
	 */
	public static Appliance[] findCheaperThan (double searchPrice, Appliance[] ourAppliances) {
		
		//Variable that keeps track of how many objects in the inventory have a price lower than  the price entered by user
		int counterPrice = 0;
		
		//Loops through our inventory
		for (int i = 0 ; i < findNumberOfCreateAppliances() ; i++) {
			//for each object, it verifies that its price is less than price entered by user 
			if (searchPrice >= ourAppliances[i].getPrice()) {
				//If condition's respected we increment our counter variable
				counterPrice++;
			}
		}
		
		//if no objects with a price lower that price entered by user is found
		if (counterPrice == 0) {
			//indicates that no object respecting the condition has been found
			System.out.println("No match found \n");
			//return our original inventory
			return ourAppliances;
		}
		
		//Creating a new array of length counterPirce to store all the elements for which the price is lower than price entered by user
		Appliance[] samePriceArray = new Appliance[counterPrice];
		
		int index = 0; 
		//Loop to loop through inventory
		for (int j = 0 ; j < findNumberOfCreateAppliances() ; j++) {
			//if object's price lower than price entered by user
			if (searchPrice >= ourAppliances[j].getPrice()) {
				//add the element to samePriceArray
				samePriceArray[index] = ourAppliances[j];
				index++; 
			}
		}
		
		//return the array with the element for which the price is lower than the price entered by the user
		return samePriceArray;
	}
	
	
}
