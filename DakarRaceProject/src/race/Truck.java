package race;

import race.Vehicle;

public class Truck extends Vehicle {
	
		private int averageDriveSpeedForTrucks;
		private int baseNumberForTrucks;
		private String soundOfWorkingEngineForTrucks;
		private String soundOfHornForTrucks;
		private int numberOfWheels;
		static int quantityOfTrucks = 0;
		
	
		// Construct a truck with default parameters
			public Truck() {
				this(90, 200, "mmm", "AAA", 4);
			}
		
		// Construct a truck with specified parameters
			public Truck(int averageDriveSpeedForTrucks, int baseNumberForTrucks, String soundOfWorkingEngineForTrucks, 
					String soundOfHornForTrucks, int numberOfWheels) {
				this.averageDriveSpeedForTrucks = averageDriveSpeedForTrucks;
				this.baseNumberForTrucks = baseNumberForTrucks;
				this.soundOfWorkingEngineForTrucks = soundOfWorkingEngineForTrucks;
				this.soundOfHornForTrucks = soundOfHornForTrucks;
				this.numberOfWheels = numberOfWheels;
				quantityOfTrucks++;
				quantityOfVehicles++;
			}
			
		// Construct a truck with specified parameters
			public Truck(int averageDriveSpeedForTrucks, int baseNumberForTrucks, String soundOfWorkingEngineForTrucks, 
					String soundOfHornForTrucks, int numberOfWheels, int generalPosition, int typeOfVehiclePosition, int number, int currentSpeed, String country, String make, String soundOfWorkingEngine, 
					String soundOfHorn, int coveredRaceDistance, int totalDurationOfRace) {
				this.averageDriveSpeedForTrucks = averageDriveSpeedForTrucks;
				this.baseNumberForTrucks = baseNumberForTrucks;
				this.soundOfWorkingEngineForTrucks = soundOfWorkingEngineForTrucks;
				this.soundOfHornForTrucks = soundOfHornForTrucks;
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
				quantityOfTrucks++;
			}
			
			@Override
			/** Return currentSpeed */
			public int getCurrentSpeed() {				 
				return (int)(super.currentSpeed + this.averageDriveSpeedForTrucks);
			}
			
			/** Return currentSpeed */
			public int getAverageDriveSpeedForTrucks() {
				return averageDriveSpeedForTrucks;
			}
			
			@Override
			/** Return number */
			public int getNumber() {
				return baseNumberForTrucks + super.number;
			}
			
			@Override
			/** Return soundOfWorkingEngine */
			public String getSoundOfWorkingEngine() {
				int truckNumber = super.number;
				String sound = "";
				for (int i = 0; i < truckNumber; i++) {
					sound += soundOfWorkingEngineForTrucks;
				}
				return sound;
			}
			
			@Override
			/** Return soundOfHorn */
			public String getSoundOfHorn() {
				int truckNumber = super.number;
				String sound = "";
				for (int i = 0; i < truckNumber; i++) {
					sound += soundOfHornForTrucks;
				}
				return sound;
			}
			
			@Override
			/** Return a string representation of this truck for writing to file */
			public String writeToFileResultsOfRace() {
				return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + "	       " + 
						" Truck " + this.getNumber() + " from " + super.getCountry() + 
						" of the " + super.getMake() + " Company reached the finish in " + Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + 
								Math.round(this.getTotalDurationOfRace() / 60 % 24) +
								" hours and " + Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
				}
			
			
			@Override
			/** Return a string representation of this object that will be written to file */
			public String writeToFileVehicles() {
				return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
						" Truck " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company";
				}
			
			
			/**Return a string description for this truck*/
			@Override
			public String toString() {
				if (super.coveredRaceDistance == 0) {
					return  "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + "	       " + 
				" Truck " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company and its working "
						+ "engine sounds like " + this.getSoundOfWorkingEngine() + "\n";
				} else {
				return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + "	        " + 
				" Truck " + this.getNumber() + " had the average speed " + this.getCurrentSpeed() + 
						" km/h and has covered " + this.getCoveredRaceDistance() + " km in " + 
				Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + Math.round(this.getTotalDurationOfRace() / 60 % 24) +
						" hours and " + Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
				}
			}
			
	
}
