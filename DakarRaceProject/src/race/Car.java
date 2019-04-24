package race;

import race.Vehicle;

public class Car extends Vehicle {
	
	private int averageDriveSpeedForCars;
	private int baseNumberForCars;
	private String soundOfWorkingEngineForCars;
	private String soundOfHornForCars;
	private int numberOfWheels;
	static int quantityOfCars = 0;
	
	// Construct a car with default parameters
				public Car() {
					this(110, 100, "oo", "NN", 4);
				}
			
			// Construct a car with specified parameters
				public Car(int averageDriveSpeedForCars, int baseNumberForCars, String soundOfWorkingEngineForCars, 
						String soundOfHornForCars, int numberOfWheels) {
					this.averageDriveSpeedForCars = averageDriveSpeedForCars;
					this.baseNumberForCars = baseNumberForCars;
					this.soundOfWorkingEngineForCars = soundOfWorkingEngineForCars;
					this.soundOfHornForCars = soundOfHornForCars;
					this.numberOfWheels = numberOfWheels;
					quantityOfCars++;
					quantityOfVehicles++;
				}
				
			// Construct a car with specified parameters
				public Car(int averageDriveSpeedForCars, int baseNumberForCars, String soundOfWorkingEngineForCars, 
						String soundOfHornForCars, int numberOfWheels, int generalPosition, int typeOfVehiclePosition, int number, int currentSpeed, 
						String country, String make, String soundOfWorkingEngine, String soundOfHorn, int coveredRaceDistance, int totalDurationOfRace) {
					this.averageDriveSpeedForCars = averageDriveSpeedForCars;
					this.baseNumberForCars = baseNumberForCars;
					this.soundOfWorkingEngineForCars = soundOfWorkingEngineForCars;
					this.soundOfHornForCars = soundOfHornForCars;
					this.numberOfWheels = numberOfWheels;
					setGeneralPosition(generalPosition);
					setTypeOfVehiclePosition(typeOfVehiclePosition);
					setNumber(number);
					setCurrentSpeed(currentSpeed);
					setCountry(country);
					setMake(make);
					setSoundOfWorkingEngine(soundOfWorkingEngine);
					setSoundOfHorn(soundOfHorn);
					setCoveredRaceDistance(coveredRaceDistance);
					setTotalDurationOfRace(totalDurationOfRace);
					quantityOfCars++;
				}
				
				@Override
				/** Return currentSpeed */
				public int getCurrentSpeed() {
					return (int)(super.currentSpeed + this.averageDriveSpeedForCars);
				}
				
				/** Return currentSpeed */
				public int getAverageDriveSpeedForCars() {
					return averageDriveSpeedForCars;
				}
				
				@Override
				/** Return number */
				public int getNumber() {
					return baseNumberForCars + super.number;
				}
				
				@Override
				/** Return soundOfWorkingEngine */
				public String getSoundOfWorkingEngine() {
					int carNumber = super.number;
					String sound = "";
					for (int i = 0; i < carNumber; i++) {
						sound += soundOfWorkingEngineForCars;
					}
					return sound;
				}
				
				@Override
				/** Return soundOfHorn */
				public String getSoundOfHorn() {
					int carNumber = super.number;
					String sound = "";
					for (int i = 0; i < carNumber; i++) {
						sound += soundOfHornForCars;
					}
					return sound;
				}
				
				@Override
				/** Return a string representation of this car for writing to a file */
				public String writeToFileResultsOfRace() {
					return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
							" Car " + this.getNumber() + " from " + super.getCountry() + 
							" of the " + super.getMake() + " Company reached the finish in " + Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + 
							Math.round(this.getTotalDurationOfRace() / 60 % 24) + " hours and " + 
									Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
					}
				
				
				@Override
				/** Return a string representation of this object that will be written to file */
				public String writeToFileVehicles() {
					return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
							" Car " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company";
					}
				
				
				/**Return a string description for this car*/
				@Override
				public String toString() {
					if (super.coveredRaceDistance == 0) {
						return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
					" Car " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company and its "
							+ "working engine sounds like " + this.getSoundOfWorkingEngine() + "\n";
					} else {
					return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + "	        " + 
							" Car " + this.getNumber() + " had the average speed " + this.getCurrentSpeed() + 
							" km/h and has covered " + this.getCoveredRaceDistance() + " km in " + 
									Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + 
							Math.round(this.getTotalDurationOfRace() / 60 % 24) + " hours and " + 
									Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
					}
				}
				

}
