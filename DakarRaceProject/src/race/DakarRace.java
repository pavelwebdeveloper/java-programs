/**
 * 
 */
package race;

/** Import Scanner class from the java.util package */
import java.util.Scanner;

/** Import ArrayList class from the java.util package */
import java.util.ArrayList;
import java.util.InputMismatchException;

/** Import the necessary class to handle exceptions */
import java.io.FileNotFoundException;

/**
 * @author Pavel
 * This application program simulates Dakar Race. It shows results for the previous race, provides a few vehicles for the new race, lets the user
 * add more vehicles for the new race, simulates the race and shows results like positions and time for each vehicle that participates in the race.
 * The user can also choose to have for the race all the vehicles that participated in the previous race. It also shows the results of the winners. 
 * At the end the application saves the results into a text file. Also the application saves the information about the vehicles that participated 
 * in the current race into a separate file.
 *
 */
public class DakarRace {

	/**
	 * @param args
	 */
	static boolean resultsFromPreviousRaceExist = true;
	
	public static void main(String[] args) throws java.io.IOException {
		
		Scanner input = new Scanner(System.in); // Create a Scanner object
		
		// Create a File instance for saving race results
		java.io.File file2 = new java.io.File("race_results.txt");
		
		// Create a File instance for saving participating vehicles
				java.io.File file = new java.io.File("vehicles.txt");
				
				// Create a list to store vehicles
				ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
				
				
		
			
			System.out.println();
			System.out.println("						WELCOME TO THE DAKAR RACE PROGRAM !							");
			System.out.println();
			
			// Ask the user if he/she wants to see the results for the previous race
			System.out.println("Do you want to see the results for the previous Dakar Race?");
			// Set the boolean value that checks the necessity to continue to try to input values
					boolean tryInput = true;
					int answer;
					
					
					// Try input until valid values are entered
					while (tryInput) { 
						try {
			System.out.println();
			
			if(resultsFromPreviousRaceExist) {
				System.out.println("The options you can choose are: ");
				System.out.println();
				System.out.println("0 - to skip the results for the previous Dakar Race");
				System.out.println("1 - to see the results for the previous Dakar Race");
				System.out.println();
				System.out.print("Your choice: ");
				answer = input.nextInt();
			} else {
				answer = 0;
			}
			
			if (answer == 1) {
				// Create a Scanner for the file
				Scanner inputFromFile2 = new Scanner(file2);
				
				// Read data from the file
				String heading = inputFromFile2.nextLine();
				String space1 = inputFromFile2.nextLine();
				String distance = inputFromFile2.nextLine();
				String space2 = inputFromFile2.nextLine();
				String paragraph = inputFromFile2.nextLine();
				String space3 = inputFromFile2.nextLine();
				String positions = inputFromFile2.nextLine();
				System.out.println(heading);
				System.out.println(space1);
				System.out.println(distance);
				System.out.println(space2);
				System.out.println(paragraph);
				System.out.println(space3);
				System.out.println(positions);	
				String vehicle = "";
				while (inputFromFile2.hasNext()) {
					vehicle = inputFromFile2.nextLine();
					System.out.println(vehicle);
				}
				
				if(vehicle.length() > 0) {
					resultsFromPreviousRaceExist = true;
				}
				
				System.out.println();
				System.out.println();
				
				// Close the file
				inputFromFile2.close();
				// Change the boolean value so that it discontinues 
				// the necessity to continue to try to input values
				tryInput = false;
			} else if (answer == 0) {
				// Change the boolean value so that it discontinues 
				// the necessity to continue to try to input values
				tryInput = false;
			} else if (answer != 0 || answer != 1) {
				// Display the reason of the exception
				System.out.println();
				System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
				// Discard previous input
				input.nextLine();
			}
						} catch (InputMismatchException ex) {
							// Display the reason of the exception
							System.out.println();
							System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
							// Discard previous input
							input.nextLine();
						} catch (FileNotFoundException ex) {
							// Display the reason of the exception
							System.out.println();
							System.out.println("Sorry the results do not exist yet so try again after a race.");
							resultsFromPreviousRaceExist = false;
							// Discard previous input
							input.nextLine();
						}
					}	
			
			
			
			boolean runProgram = true;	
					
			while(runProgram) {
			
			
				
				// Ask the user if he/she wants to start a new race
				System.out.println();
				System.out.println("Do you want to start a new race?");
				// Set the boolean value that checks the necessity to continue to try to input values
				boolean tryInput2 = true;
				
				// Try input until valid values are entered
				while (tryInput2) { 
					try {
				System.out.println();
				System.out.println("The options you can choose are: ");
				System.out.println();
				System.out.println("0 - to quit the program");
				System.out.println("1 - to start a new race");
				System.out.println();
				System.out.print("Your choice: ");
				int startNewRace = input.nextInt();
				if (startNewRace == 1) {
					
					boolean tryInput3 = true;
					int vehiclesFromPreviousRace;
					
					if(resultsFromPreviousRaceExist) {
				
					System.out.println();
					System.out.println("Do you want to use the vehicles from the previous race for this new race?");
					// Set the boolean value that checks the necessity to continue to try to input values
					} else {
						vehiclesFromPreviousRace = 0;
					}
					
					// Try input until valid values are entered
					while (tryInput3) { 
						try {
							System.out.println();
							if(resultsFromPreviousRaceExist) {
								System.out.println("The options you can choose are: ");
								System.out.println();
								System.out.println("0 - to get new vehicles for this new race");
								System.out.println("1 - to use the vehicles from the previous race");
								System.out.println();
								System.out.print("Your choice: ");
								vehiclesFromPreviousRace = input.nextInt();
							} else {
								vehiclesFromPreviousRace = 0;
							}
					
					if (vehiclesFromPreviousRace == 1) {
						// Create a Scanner for the file
						Scanner inputFromFile = new Scanner(file);
						
						// Read data from the file
						String heading = inputFromFile.nextLine();
						int i = 0;
						while (inputFromFile.hasNext()) {					
							int generalPosition = Integer.parseInt(inputFromFile.next());					
							int vehicleTypePosition = Integer.parseInt(inputFromFile.next());
							String vehicleType = inputFromFile.next();
							char letter = vehicleType.charAt(0);
							if (letter == 'B') {
								vehicles.add(new Bike());
							} else if (letter == 'C') {
								vehicles.add(new Car());
							} else if (letter == 'T') {
								vehicles.add(new Truck());
							}
							
							vehicles.get(i).setGeneralPosition(generalPosition);
							vehicles.get(i).setTypeOfVehiclePosition(vehicleTypePosition);
							int vehicleNumber = Integer.parseInt(inputFromFile.next());
							if (letter == 'B') {
								vehicles.get(i).setNumber(vehicleNumber);
							} else if (letter == 'C') {
								vehicles.get(i).setNumber(vehicleNumber - 100);
							} else if (letter == 'T') {
								vehicles.get(i).setNumber(vehicleNumber - 200);
							}
							
							String word = inputFromFile.next();
							String country = inputFromFile.next();
							vehicles.get(i).setCountry(country);
							String word2 = inputFromFile.next();
							String word3 = inputFromFile.next();
							String make = inputFromFile.next();
							vehicles.get(i).setMake(make);
							String word4 = inputFromFile.next();					
							i++;
							
						}
						
						System.out.println();
						System.out.println();
						
						// Close the file
						inputFromFile.close();
						
						// Display the vehicles that are ready for the race
						displayVehiclesReadyForRace(vehicles);
					
						
						// Change the boolean value so that it discontinues 
						// the necessity to continue to try to input values
						tryInput3 = false;
						
					} else if (vehiclesFromPreviousRace == 0) {
					
						
						
						// Create an array for countries for bikes that will be chosen for the race by the program
						String[] randomCountriesForBikes = {"Austria", "Japan", "USA", "Spain", "Germany", "Japan", "Italy", 
								"England", "Sweden", "Japan"};
						// Create an array for bikes that will be chosen for the race by the program
						String[] randomMakesForBikes = {"KTM", "Yamaha", "MotoCzysz", "Sherco", "BMW", "Honda", "Ducati", 
								"Norton", "Husqvarna", "Kawasaki"};
						
						// Randomly choose 3 bikes
						int randomNumberForBike1 = 0;
						int randomNumberForBike2 = 0;
						int randomNumberForBike3 = 0;
						
						do {
							randomNumberForBike1 = (int)(Math.random() * 10);
							randomNumberForBike2 = (int)(Math.random() * 10);
							randomNumberForBike3 = (int)(Math.random() * 10);
						} while (randomNumberForBike1 == randomNumberForBike2 || randomNumberForBike2 == randomNumberForBike3 || 
								randomNumberForBike1 == randomNumberForBike3);
						
						String[] countriesForBikes = {randomCountriesForBikes[randomNumberForBike1], randomCountriesForBikes[randomNumberForBike2], 
								randomCountriesForBikes[randomNumberForBike3]};
						String[] makesForBikes = {randomMakesForBikes[randomNumberForBike1], randomMakesForBikes[randomNumberForBike2], 
								randomMakesForBikes[randomNumberForBike3]};
						
						// add the 3 chosen bikes to the list of vehicles
						do {			
							vehicles.add(new Bike());
							
						} while(Bike.quantityOfBikes < 3);
						
						
						for (int i = 0; i < 3; i++) {
							vehicles.get(i).setGeneralPosition(i + 1);
							vehicles.get(i).setTypeOfVehiclePosition(i + 1);
							vehicles.get(i).setNumber(i + 1);
							vehicles.get(i).setCountry(countriesForBikes[i]);
							vehicles.get(i).setMake(makesForBikes[i]);
						}
						
						
						// Create an array for countries for cars that will be chosen for the race by the program
						String[] randomCountriesForCars = {"Germany", "Japan", "France", "Italy", "Sweden", "England", "Spain", 
								"Korea", "USA", "Germany"};
						// Create an array for cars that will be chosen for the race by the program
						String[] randomMakesForCars = {"Mercedez", "Toyota", "Peugeot", "Fiat", "Volvo", "Jaguar", "Seat", 
								"Hundai", "Ford", "Audi"};
						
						// Randomly choose 3 cars
						int randomNumberForCar1 = 0;
						int randomNumberForCar2 = 0;
						int randomNumberForCar3 = 0;
						
						do {
							randomNumberForCar1 = (int)(Math.random() * 10);
							randomNumberForCar2 = (int)(Math.random() * 10);
							randomNumberForCar3 = (int)(Math.random() * 10);
						} while (randomNumberForCar1 == randomNumberForCar2 || randomNumberForCar2 == randomNumberForCar3 || 
								randomNumberForCar1 == randomNumberForCar3);
						
						String[] countriesForCars = {randomCountriesForCars[randomNumberForCar1], randomCountriesForCars[randomNumberForCar2], 
								randomCountriesForCars[randomNumberForCar3]};
						String[] makesForCars = {randomMakesForCars[randomNumberForCar1], randomMakesForCars[randomNumberForCar2], 
								randomMakesForCars[randomNumberForCar3]};
						
						// add the 3 chosen cars to the list of vehicles
						do {			
							vehicles.add(new Car());
							
						} while(Car.quantityOfCars < 3);
						
						for (int i = 3; i < 6; i++) {
							vehicles.get(i).setGeneralPosition(i + 1);
							vehicles.get(i).setTypeOfVehiclePosition(i - 2);
							vehicles.get(i).setNumber(i - 2);
							vehicles.get(i).setCountry(countriesForCars[i - 3]);
							vehicles.get(i).setMake(makesForCars[i - 3]);
						}
						
						
						// Create an array for countries for trucks that will be chosen for the race by the program
						String[] randomCountriesForTrucks = {"Germany", "Russia", "France", "Italy", "Sweden", "Czech_Republic", "Belorussia", 
								"Czech_Republic", "Japan", "Ukraine"};
						// Create an array for trucks that will be chosen for the race by the program
						String[] randomMakesForTrucks = {"Mercedez", "Kamaz", "Renault", "Iveco", "Volvo", "LIAZ", "MAZ", 
								"Tatra", "Hino", "Kraz"};
						
						// Randomly choose 3 trucks
						int randomNumberForTruck1 = 0;
						int randomNumberForTruck2 = 0;
						int randomNumberForTruck3 = 0;
						
						do {
							randomNumberForTruck1 = (int)(Math.random() * 10);
							randomNumberForTruck2 = (int)(Math.random() * 10);
							randomNumberForTruck3 = (int)(Math.random() * 10);
						} while (randomNumberForTruck1 == randomNumberForTruck2 || randomNumberForTruck2 == randomNumberForTruck3 || 
								randomNumberForTruck1 == randomNumberForTruck3);
						
						String[] countriesForTrucks = {randomCountriesForTrucks[randomNumberForTruck1], randomCountriesForTrucks[randomNumberForTruck2], 
								randomCountriesForTrucks[randomNumberForTruck3]};
						String[] makesForTrucks = {randomMakesForTrucks[randomNumberForTruck1], randomMakesForTrucks[randomNumberForTruck2], 
								randomMakesForTrucks[randomNumberForTruck3]};
						
						// add the 3 chosen trucks to the list of vehicles
						do {
							vehicles.add(new Truck());
							
						} while(Truck.quantityOfTrucks < 3);
						
						for (int i = 6; i < 9; i++) {
							vehicles.get(i).setGeneralPosition(i + 1);
							vehicles.get(i).setTypeOfVehiclePosition(i - 5);
							vehicles.get(i).setNumber(i - 5);
							vehicles.get(i).setCountry(countriesForTrucks[i - 6]);
							vehicles.get(i).setMake(makesForTrucks[i - 6]);
						}
						
						// Display the vehicles that are ready for the race
						displayVehiclesReadyForRace(vehicles);
						
						
						// Change the boolean value so that it discontinues 
						// the necessity to continue to try to input values
						tryInput3 = false;
						
					} else if (vehiclesFromPreviousRace != 0 || vehiclesFromPreviousRace != 1) {
						// Display the reason of the exception
						System.out.println();
						System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
						// Discard previous input
						input.nextLine();
					}
								} catch (InputMismatchException ex) {
									// Display the reason of the exception
									System.out.println();
									System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
									// Discard previous input
									input.nextLine();
								}
							}	
						
					
					
					
						int startRace = 0;
						do {
							// Ask the user if he/she wants to add more vehicles and choose the type of vehicle
						  System.out.println();
							System.out.println("Do you want to add more vehicles to the race or delete any vehicles?");
							// Set the boolean value that checks the necessity to continue to try to input values
							boolean tryInput4 = true;
							
							// Try input until valid values are entered
							while (tryInput4) { 
								try {
							System.out.println();
							System.out.println("The options you can choose are: ");
							System.out.println();
							System.out.println("0 - to skip adding and deleting");
							System.out.println("1 - to add one or more bikes");
							System.out.println("2 - to add one or more cars");
							System.out.println("3 - to add one or more trucks");
							System.out.println("4 - to delete vehicles");
							System.out.println();
							System.out.print("Your choice: ");
								int addVehicles = input.nextInt();
								
								// Determine which type of vehicle the user wants to add
								if (addVehicles == 1 || addVehicles == 2 || addVehicles == 3 || addVehicles == 4) {
									
									do {
										if (addVehicles == 1) {
											// Set the boolean value that checks the necessity to continue to try to input values
				
											boolean tryInput6 = true;
											
											// Try input until valid values are entered
											while (tryInput6) { 
												try {
											// Ask the user how many bikes he/she wants to add
											System.out.println("How many bikes do you want to add?\n");
											int addBikes = input.nextInt();
											int addedBikes = 1;
											
											
											
											// Add a new bike to the list of vehicles
											do {	
												
												vehicles.add(Bike.quantityOfBikes, new Bike());										
												vehicles.get(Bike.quantityOfBikes - 1).setGeneralPosition(Bike.quantityOfBikes);
												vehicles.get(Bike.quantityOfBikes - 1).setTypeOfVehiclePosition(Bike.quantityOfBikes);
												vehicles.get(Bike.quantityOfBikes - 1).setNumber(Bike.quantityOfBikes);
												vehicles.get(Bike.quantityOfBikes - 1).setSoundOfWorkingEngine("");
												
												if (addBikes == 1) {
													
													// Ask the user to specify the country the bike is from 
													System.out.println("What is the country that is represented by the team of the bike ?\n");
												} else if (addBikes > 1 && addBikes < 100) {
												System.out.println("What is the country that is represented by the team of the bike " + 
														addedBikes + " ?\n");
												} else {
													
													throw new Exception("The value must be bigger than 0 and smaller than 100");
												}
												String country = input.next();
												vehicles.get(Bike.quantityOfBikes - 1).setCountry(country);
												if (addBikes == 1) {
													// Ask the user to specify the make of the bike 
													System.out.println("What is the make of the bike ?\n");
												} else {
												System.out.println("What is the make of the bike " + addedBikes + " ?\n");
												}
												String make = input.next();										
												vehicles.get(Bike.quantityOfBikes - 1).setMake(make);										
												addedBikes++;
											} while(addedBikes <= addBikes);	
											tryInput4 = false;
											tryInput6 = false;									
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The value must be bigger than 0 and smaller than 100");
													// Discard previous input
													input.nextLine();
													vehicles.remove(vehicles.get(Bike.quantityOfBikes - 1));
													Bike.quantityOfBikes--;
													Vehicle.quantityOfVehicles--;
												}
											}	
										} else if (addVehicles == 2) {
											// Set the boolean value that checks the necessity to continue to try to input values
											
											boolean tryInput7 = true;
											
											// Try input until valid values are entered
											while (tryInput7) { 
												try {
											// Ask the user how many cars he/she wants to add
											System.out.println("How many cars do you want to add?\n");
											int addCars = input.nextInt();
											int addedCars = 1;	
											// Add a new car to the list of vehicles
											do {			
												vehicles.add(Bike.quantityOfBikes + Car.quantityOfCars, new Car());
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setGeneralPosition(Bike.quantityOfBikes + Car.quantityOfCars);
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setTypeOfVehiclePosition(Car.quantityOfCars);
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setNumber(Car.quantityOfCars);
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setSoundOfWorkingEngine("");
												if (addCars == 1) {
													// Ask the user to specify the country the car is from 
													System.out.println("What is the country that is represented by the team of the car ?\n");
												} else if (addCars > 0 && addCars < 100) {
												System.out.println("What is the country that is represented by the team of the car " + 
														addedCars + " ?\n");
												} else {
													throw new Exception("The value must be bigger than 0 and smaller than 100");
													
												}
												String country = input.next();
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setCountry(country);
												if (addCars == 1) {
													// Ask the user to specify the make of the car 
													System.out.println("What is the make of the car ?\n");
												} else {
												System.out.println("What is the make of the car " + addedCars + " ?\n");
												}
												String make = input.next();
												vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1).setMake(make);
												addedCars++;
											} while(addedCars <= addCars);
											tryInput4 = false;
											tryInput7 = false;
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The value must be bigger than 0 and smaller than 100");
													// Discard previous input
													input.nextLine();
													vehicles.remove(vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1));
													Car.quantityOfCars--;
													Vehicle.quantityOfVehicles--;
												}
											}	
										} else if (addVehicles == 3) {
											// Set the boolean value that checks the necessity to continue to try to input values
											
											boolean tryInput8 = true;
											
											// Try input until valid values are entered
											while (tryInput8) { 
												try {
											// Ask the user how many trucks he/she wants to add
											System.out.println("How many trucks do you want to add?\n");
											int addTrucks = input.nextInt();
											int addedTrucks = 1;
											do {			
												vehicles.add(Vehicle.quantityOfVehicles, new Truck());
												vehicles.get(Vehicle.quantityOfVehicles - 1).setGeneralPosition(Vehicle.quantityOfVehicles);
												vehicles.get(Vehicle.quantityOfVehicles - 1).setTypeOfVehiclePosition(Truck.quantityOfTrucks);
												vehicles.get(Vehicle.quantityOfVehicles - 1).setNumber(Truck.quantityOfTrucks);
												vehicles.get(Vehicle.quantityOfVehicles - 1).setSoundOfWorkingEngine("");
												if (addTrucks == 1) {
													// Ask the user to specify the country the truck is from 
													System.out.println("What is the country that is represented by the team of the truck ?\n");
												} else if (addTrucks > 0 && addTrucks < 100) {
													System.out.println("What is the country that is represented by the team of the truck " + 
															addedTrucks + " ?\n");
												} else {
													
													throw new Exception("The value must be bigger than 0 and smaller than 100");
													
												}							
												String country = input.next();
												vehicles.get(Vehicle.quantityOfVehicles - 1).setCountry(country);
												if (addTrucks == 1) {
													// Ask the user to specify the make of the truck
													System.out.println("What is the make of the truck ?\n");
												} else {
												System.out.println("What is the make of the truck " + addedTrucks + " ?\n");
												}
												String make = input.next();
												vehicles.get(Vehicle.quantityOfVehicles - 1).setMake(make);
												addedTrucks++;
											} while(addedTrucks <= addTrucks);
											tryInput4 = false;
											tryInput8 = false;
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The value must be bigger than 0 and smaller than 100");
													// Discard previous input
													input.nextLine();
													vehicles.remove(vehicles.get(Vehicle.quantityOfVehicles - 1));
													Truck.quantityOfTrucks--;
													Vehicle.quantityOfVehicles--;
												}
											}	
										}
										
																							
								 else if (addVehicles == 4) {
									System.out.println();
									System.out.println("You can specify the type of the vehicles that you want to delete");
									// Set the boolean value that checks the necessity to continue to try to input values
									boolean tryInput5 = true;
									
									// Try input until valid values are entered
									while (tryInput5) { 
										try {
									System.out.println();
									System.out.println("The options you can choose are: ");
									System.out.println();
									System.out.println("1 - to delete bikes");
									System.out.println("2 - to delete cars");
									System.out.println("3 - to delete trucks");
									System.out.println();
									System.out.print("Your choice: ");
										int deleteVehicles = input.nextInt();
										if (deleteVehicles == 1) {
											// Set the boolean value that checks the necessity to continue to try to input values
											
											boolean tryInput9 = true;
											
											// Try input until valid values are entered
											while (tryInput9) { 
												try {
											System.out.println();
											// Ask the user how many trucks he/she wants to add
											System.out.println("How many bikes do you want to delete?\n");
											int deleteBikes = input.nextInt();
											if (deleteBikes > 0 && deleteBikes < Bike.quantityOfBikes) {
											int deletedBikes = 0;
											do {
												vehicles.remove(vehicles.get(Bike.quantityOfBikes - 1));
												deletedBikes++;
												Bike.quantityOfBikes--;
												Vehicle.quantityOfVehicles--;
											} while (deletedBikes < deleteBikes);
											} else {
												throw new Exception("The number must be at most one less than the amount of bikes");
											}
											
											setGeneralAndVehicleTypePositions(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
											
											// Display the vehicles that are ready for the race
											displayVehiclesReadyForRace(vehicles);
											
											tryInput5 = false;
											tryInput9 = false;
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The number must be at most one less than the amount of bikes");
													// Discard previous input
													input.nextLine();
												}
											}	
											
										} else if (deleteVehicles == 2) {
											// Set the boolean value that checks the necessity to continue to try to input values
											
											boolean tryInput10 = true;
											
											// Try input until valid values are entered
											while (tryInput10) { 
												try {
											System.out.println();
											// Ask the user how many trucks he/she wants to add
											System.out.println("How many cars do you want to delete?\n");
											int deleteCars = input.nextInt();
											if (deleteCars > 0 && deleteCars < Car.quantityOfCars) {
											int deletedCars = 0;
											do {
												vehicles.remove(vehicles.get(Bike.quantityOfBikes + Car.quantityOfCars - 1));
												deletedCars++;
												Car.quantityOfCars--;
												Vehicle.quantityOfVehicles--;
											} while (deletedCars < deleteCars);
											} else {
												throw new Exception("The number must be at most one less than the amount of cars");
											}
											
											setGeneralAndVehicleTypePositions(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
											
											// Display the vehicles that are ready for the race
											displayVehiclesReadyForRace(vehicles);
											
											tryInput5 = false;
											tryInput10 = false;
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The number must be at most one less than the amount of cars");
													// Discard previous input
													input.nextLine();
												}
											}	
											
										} else if (deleteVehicles == 3) {
											// Set the boolean value that checks the necessity to continue to try to input values
											
											boolean tryInput11 = true;
											
											// Try input until valid values are entered
											while (tryInput11) { 
												try {
											System.out.println();
											// Ask the user how many trucks he/she wants to add
											System.out.println("How many trucks do you want to delete?\n");
											int deleteTrucks = input.nextInt();
											if (deleteTrucks > 0 && deleteTrucks < Truck.quantityOfTrucks) {
											int deletedTrucks = 0;
											do {
												vehicles.remove(vehicles.get(vehicles.size() - 1));
												deletedTrucks++;
												Truck.quantityOfTrucks--;
												Vehicle.quantityOfVehicles--;
											} while (deletedTrucks < deleteTrucks);
											} else {
												throw new Exception("The number must be at most one less than the amount of trucks");
											}
											
											
											setGeneralAndVehicleTypePositions(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
											
											// Display the vehicles that are ready for the race
											displayVehiclesReadyForRace(vehicles);
											
											tryInput4 = false;
											
											tryInput5 = false;
											tryInput11 = false;
												} catch (InputMismatchException ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("Wrong value. Please, try again. You should enter an integer.");
													// Discard previous input
													input.nextLine();
												} catch (Exception ex) {
													// Display the reason of the exception
													System.out.println();
													System.out.println("The number must be at most one less than the amount of trucks");
													// Discard previous input
													input.nextLine();
												}
											}	
										} else if (deleteVehicles != 1 || deleteVehicles != 2 || deleteVehicles != 3) {
											// Display the reason of the exception
											System.out.println();
											System.out.println("Wrong value. Please, try again. You should enter either 1 or 2 or 3.");
											// Discard previous input
											input.nextLine();
										}
													} catch (InputMismatchException ex) {
														// Display the reason of the exception
														System.out.println();
														System.out.println("Wrong value. Please, try again. You should enter either 1 or 2 or 3.");
														// Discard previous input
														input.nextLine();
													}
												}	
										
		
										
								
											
										
								} setGeneralAndVehicleTypePositions(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
								
								// Display the vehicles that are ready for the race
								displayVehiclesReadyForRace(vehicles);
								
								break;
									
						} while(addVehicles != 0);
							
							
									if (addVehicles != 0) {
										continue;
									} else {
									
									
							// Invite the user to start the race
							System.out.println("Let us start a race.\n");
							System.out.println("Do you want to start a race ? \n");
							// Set the boolean value that checks the necessity to continue to try to input values
							
							boolean tryInput11 = true;
							
							// Try input until valid values are entered
							while (tryInput11) { 
								try {
							System.out.println();
							System.out.println("The options you can choose are: ");
							System.out.println();
							System.out.println("0 - to add or delete more vehicles");
							System.out.println("1 - to start a race");
							System.out.println();
							System.out.print("Your choice: ");
							startRace = input.nextInt();
							if (startRace == 0 || startRace == 1) {
								tryInput11 = false;
							} else {
								
								// Display the reason of the exception
								System.out.println();
								System.out.println("Wrong value. Please, try again. You should enter either 0 or 1");
								// Discard previous input
								input.nextLine();
							}
							
							
								} catch (InputMismatchException ex) {
									// Display the reason of the exception
									System.out.println();
									System.out.println("Wrong value. Please, try again. You should enter either 0 or 1.");
									// Discard previous input
									input.nextLine();
								}
							}	
									}
							} else if (addVehicles == 0) {
									System.out.println("Let us start a race.\n");
									System.out.println("Do you want to start a race ?\n");
									// Set the boolean value that checks the necessity to continue to try to input values
									
									boolean tryInput12 = true;
									
									// Try input until valid values are entered
									while (tryInput12) { 
										try {
									System.out.println();
									System.out.println("The options you can choose are: ");
									System.out.println();
									System.out.println("0 - to add or delete more vehicles");
									System.out.println("1 - to start a race");
									System.out.println();
									System.out.print("Your choice: ");
									startRace = input.nextInt();	
									// Change the boolean value so that it discontinues 
									// the necessity to continue to try to input values
									tryInput4 = false;
									
									if (startRace == 0 || startRace == 1) {
										tryInput12 = false;
									} else {
										// Display the reason of the exception
										System.out.println();
										System.out.println("Wrong value. Please, try again. You should enter either 0 or 1");
										// Discard previous input
										input.nextLine();
										
									}
									
									
										} catch (InputMismatchException ex) {
											// Display the reason of the exception
											System.out.println();
											System.out.println("Wrong value. Please, try again. You should enter either 0 or 1.");
											// Discard previous input
											input.nextLine();
										}
									}	
								} else if (addVehicles != 0 || addVehicles != 1 || addVehicles != 2 || addVehicles != 3 || addVehicles != 4) {
									// Display the reason of the exception
									System.out.println();
									System.out.println("Wrong value. Please, try again. You should enter either 0 or 1 or 2 or 3 or 4.");
									// Discard previous input
									input.nextLine();
								}
											} catch (InputMismatchException ex) {
												// Display the reason of the exception
												System.out.println();
												System.out.println("Wrong value. Please, try again. You should enter either 0 or 1 or 2 or 3 or 4.");
												// Discard previous input
												input.nextLine();
											}
										}
						} while(startRace == 0);
						
						
						// Create a file
						java.io.PrintWriter output = new java.io.PrintWriter(file);
						
						// Write formatted output to the file
						
						output.println("General position " + "	Vehicle type position");
						for (int n = 0; n < vehicles.size(); n++) {	
							// Write formatted output to the file
							output.println(vehicles.get(n).writeToFileVehicles());
							}
						
						// Close the file
						output.close();
						
								
						// Inform the user that the vehicles have begun the race		
						System.out.println("\n			THE VEHICLES HAVE BEGUN THE RACE !!!!!				\n\n");
						
						// Set the total distance for the entire race
						final int TOTAL_DISTANCE_OF_RACE = 10000;
						
						// Set the length of each part of the distance
						final int PART_OF_DISTANCE_OF_RACE = 1000;
						
						
						
				do {
					
					// Set speed, calculate distance and determine time of race for each vehicle
					settingSpeedDistanceAndDurationOfRaceForEachVehicle(vehicles, TOTAL_DISTANCE_OF_RACE, PART_OF_DISTANCE_OF_RACE);
					
					// Determine the general positions and vehicle type positions for each vehicle
					determinePositionsOfVehicles(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
					
				} while(vehicles.get(vehicles.size() - 1).getCoveredRaceDistance() < TOTAL_DISTANCE_OF_RACE);
				
							//Display the winner for bikes and the results for the winner
							System.out.println("Bike " + vehicles.get(0).getNumber() + " has won and has covered the distance in "
									+ vehicles.get(0).getTotalDurationOfRace() / 60 / 24 + " days " + vehicles.get(0).getTotalDurationOfRace()
									/ 60 % 24 +  " hours " + vehicles.get(0).getTotalDurationOfRace() % 60 + " minutes and the bike is "
											+ "sounding its horn like " + vehicles.get(0).getSoundOfHorn() + "\n");
							
							// Display winners for cars and trucks and their results
							displayWinnnersForCarsAndTrucks(vehicles);
												
							
							// Create a file
							java.io.PrintWriter output2 = new java.io.PrintWriter(file2);
							
							// Write formatted output to the file
							
							output2.println("						THE RESULTS FOR THE DAKAR RACE							");
							output2.println();
							output2.println("The total distance was " + TOTAL_DISTANCE_OF_RACE + " km");
							output2.println();
							output2.println("These are the vehicles that participated in the race and their results:");
							output2.println();
							output2.println("General position " + "	Vehicle type position");
							for (int n = 0; n < vehicles.size(); n++) {	
								// Write formatted output to the file
								output2.println(vehicles.get(n).writeToFileResultsOfRace());
								}
							
							// Close the file
							output2.close();
							// Change the boolean value so that it discontinues 
							// the necessity to continue to try to input values
							tryInput2 = false;
				
				} else if (startNewRace == 0) {
					System.out.println("Ok. Maybe some other time.");
					System.out.println();
					System.out.println("Good Bye!");
					runProgram = false;
					// Change the boolean value so that it discontinues 
					// the necessity to continue to try to input values
					tryInput2 = false;
							} else {
								// Display the reason of the exception
								System.out.println();
								System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
								// Discard previous input
								input.nextLine();
							}
										} catch (InputMismatchException ex) {
											// Display the reason of the exception
											System.out.println();
											System.out.println("Wrong value. Please, try again. You should enter 0 or 1.");
											// Discard previous input
											input.nextLine();
										}
				
					}	
			
		}

	}
	
	/** 
	 * The displayVehiclesReadyForRace method
	 * Purpose: Display the vehicles that are ready for a new race
	 * @param ArrayList<Vehicle> vehicles
	 * @return void
	 */
	
	public static void displayVehiclesReadyForRace(ArrayList<Vehicle> vehicles) {
		// Display a list of vehicles that are ready for the race
		System.out.println();
		System.out.println("These are the vehicles that will participate in this race\n");
		System.out.println("General position " + " 	Vehicle type position");
		for (int i = 0; i < vehicles.size(); i++) {
		System.out.println(vehicles.get(i).toString());
		}
		System.out.println();
		System.out.println();
	}
	
	/** 
	 * The settingSpeedDistanceAndDurationOfRaceForEachVehicle method
	 * Purpose: Set speed, calculate distance and determine time of race for each vehicle
	 * @param ArrayList<Vehicle> vehicles
	 * @param final int TOTAL_DISTANCE_OF_RACE
	 * @param final int PART_OF_DISTANCE_OF_RACE
	 * @return void
	 */
	
	public static void settingSpeedDistanceAndDurationOfRaceForEachVehicle(ArrayList<Vehicle> vehicles, final int TOTAL_DISTANCE_OF_RACE, 
			final int PART_OF_DISTANCE_OF_RACE) {
		// Set speed, calculate distance and determine time of race for each vehicle
		for (int i = 0; i < vehicles.size(); i++) {
			vehicles.get(i).setCurrentSpeed(10);
			int currentSpeed = vehicles.get(i).getCurrentSpeed();
			int durationOfRacePerPartOfTotalDistance = (int)(PART_OF_DISTANCE_OF_RACE / (double)currentSpeed * 60);
			int totalDurationOfRace = vehicles.get(i).getTotalDurationOfRace() + durationOfRacePerPartOfTotalDistance;
			int coveredRaceDistance = vehicles.get(i).getCoveredRaceDistance() + PART_OF_DISTANCE_OF_RACE;
			if (coveredRaceDistance > TOTAL_DISTANCE_OF_RACE) {
				coveredRaceDistance = TOTAL_DISTANCE_OF_RACE;
				vehicles.get(i).setCurrentSpeed(0);
			}
			vehicles.get(i).setCoveredRaceDistance(coveredRaceDistance);
			vehicles.get(i).setTotalDurationOfRace(totalDurationOfRace);
			
	}
	}
	
	/** 
	 * The determinePositionsOfVehicles method
	 * Purpose: Determine the position for each vehicle according to the time of its racing
	 * @param ArrayList<Vehicle> vehicles
	 * @param int quantityOfBikes
	 * @param int quantityOfCars
	 * @param int quantityOfTrucks
	 * @return void
	 */
	
	public static void determinePositionsOfVehicles(ArrayList<Vehicle> vehicles, int quantityOfBikes, int quantityOfCars, 
			int quantityOfTrucks) {
		// Determine the position for each vehicle according to the time of its racing
		for (int j = 0; j < vehicles.size() - 1; j++) {	
			if (vehicles.get(j) instanceof Bike) {
				for (int k = 0; k < quantityOfBikes - 1; k++) {
					for (int n = k + 1; n < quantityOfBikes; n++) {
				if (vehicles.get(k).getTotalDurationOfRace() > vehicles.get(n).getTotalDurationOfRace()) {
				// Vehicle bike = new Bike();
				Vehicle bike = vehicles.remove(n);
				vehicles.add(k, bike);
				}
				}
			}
			} else if (vehicles.get(j) instanceof Car) {
				for (int k = quantityOfBikes; k < quantityOfBikes + quantityOfCars - 1; k++) {
					for (int n = k + 1; n < quantityOfBikes + quantityOfCars; n++) {
				if (vehicles.get(k).getTotalDurationOfRace() > vehicles.get(n).getTotalDurationOfRace()) {
					// Vehicle car = new Car();
					Vehicle car = vehicles.remove(n);
					vehicles.add(k, car);
				}
					}
					
					//vehicles.get(k).setGeneralPosition(k + 1);
					//vehicles.get(k).setTypeOfVehiclePosition(k + 1);
					
					}
			} else if (vehicles.get(j) instanceof Truck) {
				for (int k = quantityOfBikes + quantityOfCars; k < vehicles.size() - 1; k++) {
					for (int n = k + 1; n < vehicles.size(); n++) {
				if (vehicles.get(k).getTotalDurationOfRace() > vehicles.get(n).getTotalDurationOfRace()) {
					// Vehicle truck = new Truck();
					Vehicle truck = vehicles.remove(n);
					vehicles.add(k, truck);
				}
					}
					
					//vehicles.get(k).setGeneralPosition(k + 1);
					//vehicles.get(k).setTypeOfVehiclePosition(k + 1);
					
					}
			}
			
		} 
		
		setGeneralAndVehicleTypePositions(vehicles, Bike.quantityOfBikes, Car.quantityOfCars, Truck.quantityOfTrucks);
		
		displayPositionsAndDurationOfRaceForEachVehicle(vehicles);		
		
		int amountOfDaysOfRace = (int)vehicles.get(vehicles.size() - 1).getTotalDurationOfRace() / 60 / 24;
		
		int amountOfHoursOfRace = (int)vehicles.get(vehicles.size() - 1).getTotalDurationOfRace() / 60 % 24;
		
		int amountOfMinutesOfRace = (int)vehicles.get(vehicles.size() - 1).getTotalDurationOfRace() % 60;
		
		if (amountOfDaysOfRace == 0) {
			System.out.print("\nThe race has lasted " + amountOfHoursOfRace + " hours\n\n\n");
		} else {				
		System.out.print("\nThe race has lasted " + amountOfDaysOfRace + " days " + amountOfHoursOfRace + " hours " 
				+ amountOfMinutesOfRace + " minutes\n\n\n");
		
		}
	}


	/** 
	 * The setGeneralAndVehicleTypePositions method
	 * Purpose: Set general and vehicle type positions for each vehicle
	 * @param ArrayList<Vehicle> vehicles
	 * @param int quantityOfBikes
	 * @param int quantityOfCars
	 * @param int quantityOfTrucks
	 * @return void
	 */
	
	public static void setGeneralAndVehicleTypePositions(ArrayList<Vehicle> vehicles, int quantityOfBikes, int quantityOfCars, 
			int quantityOfTrucks) {
		// Set general and vehicle type positions for each vehicle
		for (int j = 0; j < vehicles.size(); j++) {	
			if (vehicles.get(j) instanceof Bike) {
				for (int k = 0; k < Bike.quantityOfBikes; k++) {
					vehicles.get(k).setGeneralPosition(k + 1);
					vehicles.get(k).setTypeOfVehiclePosition(k + 1);
				}
				} else if (vehicles.get(j) instanceof Car) {
					for (int k = Bike.quantityOfBikes; k < Bike.quantityOfBikes + Car.quantityOfCars; k++) {
						vehicles.get(k).setGeneralPosition(k + 1);
						vehicles.get(k).setTypeOfVehiclePosition(k - Bike.quantityOfBikes + 1);
					}
					} else if (vehicles.get(j) instanceof Truck) {
						for (int k = Bike.quantityOfBikes + Car.quantityOfCars; k < vehicles.size(); k++) {
							vehicles.get(k).setGeneralPosition(k + 1);
							vehicles.get(k).setTypeOfVehiclePosition(k - Bike.quantityOfBikes - Car.quantityOfCars + 1);
						}
						}
		}
	}
	
		/** 
		 * The displayPositionsAndDurationOfRaceForEachVehicle method
		 * Purpose: Display the positions and duration of race for each vehicle
		 * @param ArrayList<Vehicle> vehicles
		 * @return void
		 */
		
		public static void displayPositionsAndDurationOfRaceForEachVehicle(ArrayList<Vehicle> vehicles) {
			// Display the positions and duration of race for each vehicle
			System.out.println("General position " + " 	Vehicle type position");
			for (int n = 0; n < vehicles.size(); n++) {				
				System.out.println(vehicles.get(n).toString());
				}
		}
		
		/** 
		 * The displayWinnnersForCarsAndTrucks method
		 * Purpose: Display the winners for cars and trucks and show their results
		 * @param ArrayList<Vehicle> vehicles
		 * @return void
		 */
		
		public static void displayWinnnersForCarsAndTrucks(ArrayList<Vehicle> vehicles) {
			// Display the winners for cars and trucks and show their results
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) instanceof Car) {
					System.out.println("Car " + vehicles.get(i).getNumber() + " has won and has covered the distance in "
							+ vehicles.get(i).getTotalDurationOfRace() / 60 / 24 + " days " + vehicles.get(i).getTotalDurationOfRace()
							/ 60 % 24 +  " hours " + vehicles.get(i).getTotalDurationOfRace() % 60 + " minutes and the car "
									+ "is sounding its horn like " + vehicles.get(i).getSoundOfHorn() + "\n");
					break;
				}		
			}
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) instanceof Truck) {
					System.out.println("Truck " + vehicles.get(i).getNumber() + " has won and has covered the distance in "
							+ vehicles.get(i).getTotalDurationOfRace() / 60 / 24 + " days " + vehicles.get(i).getTotalDurationOfRace()
							/ 60 % 24 +  " hours " + vehicles.get(i).getTotalDurationOfRace() % 60 + " minutes and the truck "
									+ "is sounding its horn like " + vehicles.get(i).getSoundOfHorn() + "\n");
					break;
				}
				}
			
		}
			
}

