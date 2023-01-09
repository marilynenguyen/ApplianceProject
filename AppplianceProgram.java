//-----------------------------
//Assignment #1
//Part 2
//Written by: Steven Lam(40226649) and Marilyne Nguyen(40228396)
//-----------------------------

/**
 * Program to allow the user to create his own inventory of Appliances
 * The program also allow the user to modify his inventory
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *COMP249
 *Assignment #1
 *Due Date: October 7th, 2022
 */

//import ScannerClass
import java.util.Scanner;

public class AppplianceProgram {

	public static void main(String[] args) {
		
		//Creating a Scanner object 
		Scanner input = new Scanner(System.in);
		
		//Display of the welcome message 
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to the appliances'track of the store");
		System.out.println("--------------------------------------------");
		//Prompt for the user to enter the amount of maximum appliances 
		System.out.println("Enter the amount of maximum appliances in the store:  ");
		
		//Initialization of the maximumAppliances 
		int maxAppliances = 0;
		//Initialization of the choice
		int choice = 0; 
		//Declaration of the userInput
		String userInput;
		//Initialization of the attempt 
		int attempt = 0;
		//Initialization of the password 
		final String password = "c249";
		//Initialization of the userAppliance 
		int userAppliance = 0;
		//Initialization of the serialNumber
		long serialNumber = 1000000L;
		//Initialization of the difference
		int difference = 0;
		//Initialization of the boolean value to loop the option menu until the user wants to quit 
		boolean checkOption = true; 
	
		//condition to check if the user enters a valid integer 
		//if the input is not an integer, the system will exit 
		if (input.hasNextInt()) {
			maxAppliances = input.nextInt(); //stores the user's input for maximum appliances 
		} else {
			System.out.println("Error invalid integer input. Please try again.");
			System.exit(0); //system exits 
			
		}
		
		//Initialization of the array of Appliance objects 
		//the number of space available is the number entered by the user 
		Appliance[]inventory = new Appliance[maxAppliances];
		
		/*
		While loop for the option menu and the options. The checkOption variable is initialized to true so the loop will execute until the user
		enters option 5 in which the checkOption is changed to false. (the program will end) 
		*/
		while (checkOption) {
			
			//Display of the menu for the user 
			System.out.println("What do you want to do?");
			System.out.println("\t1. Enter new appliances (password required)");
			System.out.println("\t2. Change information of an appliance (password required)");
			System.out.println("\t3. Display all appliances by a specific brand");
			System.out.println("\t4. Display all appliances under a certain price");
			System.out.println("\t5. Quit");
			System.out.println("Please enter your choice>");

			//Taking the user input for the choice 
			choice = input.nextInt();

			//if statement to check if the user input is between 1 and 5 
			if (choice >= 1 && choice <= 5) {
				
				//Depending on the choice, there is different cases 
				//the switch statement will check which choice is going to be used 
				switch (choice) {

				case 1:
					
						//Prompt for the user password 
						System.out.println("Please enter your password: ");
						//The password entered by the user will be stored in userInput 
						userInput = input.next();
						//Each time the user will enter a password, the attempt variable will increment by 1 (counter)
						attempt++;
						
						/*For loop to loop to repeat a process 2 times if the user enters a different password that c249. The condition of this for 
						* loop allows the user to re-attempt 2 times. It will still go in the for loop to verify the password at the last attempt 
						* since it is smaller or equal to 2  
						*/
						for(int i = 0; i <= 2 ; i++) {
							
							//if statement is the password is equal to c249 
							if (userInput.equals(password)) {
								//prompt the user for the amount of appliance that he wants 
								System.out.println("How many appliances do you want to enter: ");
								//stores that variable in the userAppliance
								userAppliance = input.nextInt();
								
								//if the userAppliance is smaller than the capacity of the inventory we go in this if block 
								if (userAppliance <= maxAppliances) {
									
									//for loop to store appliance objects in the inventory array
									for (int j = 0 ; j < userAppliance ; j++) {
										System.out.println("Please enter the type, brand and price of your appliance: "); 
										//user inputs for the type, brand and price 
										String type = input.next();
										String brand = input.next();
										double price = input.nextDouble();
										
										//creation appliance object that we store in the inventory array 
										inventory[j] = new Appliance (type, brand, serialNumber, price);
										//the serialNumber that we initialized to 1000000 will increment each time an object is created 
										serialNumber++;
										}
										
										//to know how many space there is left in the inventory 
										difference = maxAppliances - userAppliance;
										
										if (difference == 0) {
											System.out.println("There is no remaining spaces.");
										}
										else {
											System.out.println("There is " + difference + " places remaining.\n");
										}	
								}
								
								//if the userAppliance is bigger than the capacity of the inventory we go in this else if block 
								else if (userAppliance >= maxAppliances) {
									//message error
									System.out.println("Not enough space available");
								}
								
								//We reset the attempt variable to 0 
								attempt = 0 ;
								//We break out of the for first for loop (if the user enters the good password) 
								break;
							}
							
							//else if statement if the password is not good 
							else if (userInput!= password) {
								
									/**if the local variable i is equal to 2, we break out of the 1st for loop 
									 * so the user can only have two attempts after the first one 
									 */
									if (i == 2) {
										break;
									}
									//Prompt for the user password (when he retries) 
									System.out.println("Please re-enter your password: ");
									
									//The password entered by the user will be stored in userInput 
									userInput = input.next();
									//the variable attempt will increment by one when the user tries to enter a password 
									attempt++;
									
									//if the variable attempt gets to 12, the system will stop executing 
									if (attempt == 12) {
										//error message 
										System.out.println("Program detected suspicious activities and will terminate immediately!");
										//the system will stop to run 
										System.exit(0);
									}
							}
						}
					
				//breaking from case 1 	
				break; 
				
				//We entered this case if the user enters '2' for the variable choice
				case 2 : 
					
					//Verifies that there are Appliances in our inventory
					if(Appliance.findNumberOfCreateAppliances() >= 1) {
						//Prompt for the user password 
						System.out.println("Please enter your password: ");
						//storing user input in a variable
						userInput = input.next();	
						
						//the condition of this loop allows the user to re-attempt the password for a maximum of 2 times
						for (int i = 0; i <= 2; i++) {
							
							//if the user enters the right password
							if (userInput.equals(password)) {
								//Prompt the user to enter the serial number of the wanted Appliance
								System.out.println("Please enter the serial number of the appliance that you want : "); 
								//storing the input into a variable 
								long numberSerieUser = input.nextLong(); 
									
									//loop through our inventory array
									for (int j = 0; j < inventory.length; j++) {
										//for each appliance it checks if its serial number matches the serial number wanted by the user
										if (numberSerieUser == inventory[j].getSerialNumber()) {
											
											//Initialization of checkUpdate variable to true
											boolean checkUpdate = true;
											
											//Since checkUpdate is initialized to true, we enter this loop
											while (checkUpdate) {
												//Print the information of the object with the matching serial number
												System.out.println("Appliance Serial # " + inventory[j].getSerialNumber());
												System.out.println("Brand: " + inventory[j].getBrand());
												System.out.println("Type: " + inventory[j].getType());
												System.out.println("Price: " + inventory[j].getPrice() + "\n");
												
												//Asking the user what information about that specific appliance he would like to change
												System.out.println("What information would you like to change? ");
												System.out.println("\t1. brand");
												System.out.println("\t2. type");
												System.out.println("\t3. price");
												System.out.println("\t4. Quit");
												//prompt choice from the user
												System.out.println("Enter your choice >");
												
												//store user input between the update that the user wants to change into a variable 
												int update = input.nextInt();
												
												//Switch case to update a specific variable of an Appliance
												switch (update) {
													
													//entering this case if the user choose option 1 from the update menu
													case 1:
														//prompt the user to enter new value for the brand
														System.out.print("Enter the updated value of the brand: ");
														//storing input into a variable
														String newBrand = input.next();
														System.out.println();
														//updating the brand of the appliance
														inventory[j].setBrand(newBrand);
														//after the update is finished, we break out of this case
														break; 
													
													//entering this case if the user choose option 2 from the update menu
													case 2:
														//prompt the user to enter new value for the type
														System.out.print("Enter the updated value of the type: ");
														//storing input into a variable
														String newType = input.next();
														System.out.println();
														//updating the brand of the appliance
														inventory[j].setType(newType);
														//after the update is finished, we break out of this case
														break;
													
													//entering this case if the user choose option 3 from the update menu
													case 3:
														//prompt the user to enter new value for the price
														System.out.print("Enter the updated value of the price: ");
														//storing input into a variable
														double newPrice = input.nextDouble();
														System.out.println();
														//updating the brand of the appliance
														inventory[j].setPrice(newPrice);
														//after the update is finished, we break out of this case
														break;
														
													//entering this case if the user choose option 4 from the update menu
													case 4:
														//changing the value of checkUpdate variable to false
														checkUpdate = false;
														//after the update is finished, we break out of this case
														break;
												}
											
											}
											
											//breaks out of the for loop at line 203
											break;
										}	
									
									}
								
								//breaks out of the for loop of line 193
								break; 
							}
						
							//if the user doesn't enter the right password, we enter this loop
							else if (userInput!= password) {
								//verifies if the user has already re-attempted the password 2 times
								if (i == 2) {
									//if condition's respected, break out of the loop at line 193
									break;
								}
								//Prompt for the user password (when he tries again) 
								System.out.println("Please re-enter your password: ");
								//storing user input for the password into the userInput variable
								userInput = input.next();
							}
							
						}
					}
				
					//if there is no object in the inventory, we enter this loop
					else if (Appliance.findNumberOfCreateAppliances() == 0) {
						//message to indicate the user that there's nothing in the inventory
						System.out.println("There is no appliances available in the inventory. Please add some appliances before using this option.");
					}
				
				//Breaking out of this case 2
				break;
				
				
			//We entered this case if the user enters '3' for the variable choice
			case 3:
			
			//Verifies that there are Appliances in our inventory
			if(Appliance.findNumberOfCreateAppliances() >= 1) {
				//Prompt for the brand name that the user is looking for 
				System.out.print("Enter the brand name that you are looking for: \n");
				//Storing the user input into the searchBrand variable
				String searchBrand = input.next();
				
				//...
				Appliance[] sameBrandName = Appliance.findAppliancesBy(searchBrand, inventory);
				
				//loop that goes through all the elements of the sameBrandName array
				for(Appliance element : sameBrandName) {
					//Printing the information of each element of the inventory, which has the same brand name
					System.out.println(element + "\n");
				}
			}
			
			//we enter this loop if there is no Appliances in our inventory
			else if (Appliance.findNumberOfCreateAppliances() == 0) {
					//Message to indicate the user that the inventory is empty
					System.out.println("There is no appliances available in the inventory. Please add some appliances before using this option.");
			}
			
			//Breaking out of this case 3
			break;
			
			
			//We entered this case if the user enters '4' for the variable choice
			case 4:

			//Verifies that there are Appliances in the inventory
			if(Appliance.findNumberOfCreateAppliances() >= 1) {
				
				//Prompt for the price that the user wants to find a appliance cheaper 
				System.out.print("You want to find the items for which the price is cheaper than: ");
				//Storing user input into the searchPrice variable
				double searchPrice = input.nextDouble();
				
				// 
				Appliance[] samePriceArray = Appliance.findCheaperThan(searchPrice, inventory);
				
				//loop that goes through all the elements of the samePriceArray
				for(Appliance element : samePriceArray) {
					//Printing the information of all the Appliances which have the same price
					System.out.println(element + "\n");
				}
			}
			
			//If there are no Appliances in the inventory, we enter this branch
			else if (Appliance.findNumberOfCreateAppliances() == 0) {
					//Message to indicate the user that the inventory is empty
					System.out.println("There is no appliances available in the inventory. Please add some appliances before using this option.");
			}
				
			//Breaking out of this case 4
			break;
			
			
			//We entered this case if the user enters '5' for the variable choice
			case 5:
				//Display of the closing message 
				System.out.println("Thank you for using our program!");
				//setting the value of checkOption variable to false
				checkOption = false; 
				
			}
		}
			
			//If the user"s input for the option is not between 1 and 5 inclusively 
			else {
				//Message to indicate the user that he did not enter a valid option
				System.out.println("The option you entered is unavailable, please enter a value from the displayed menu. \n");
			}
		}
		
		//close Scanner
		input.close();
	}

}
