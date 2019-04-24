package race;

import race.Vehicle;

public class Bike extends Vehicle {
	
	private int averageDriveSpeedForBikes;
	private int baseNumberForBikes;
	private String soundOfWorkingEngineForBikes;
	private String soundOfHornForBikes;
	private int numberOfWheels;
	static int quantityOfBikes = 0;
	
	
	// Construct a bike with default parameters
	public Bike() {
		this(130, 0, "z", "E", 2);
	}

// Construct a bike with specified parameters
	public Bike(int averageDriveSpeedForBikes, int baseNumberForBikes, String soundOfWorkingEngineForBikes, 
			String soundOfHornForBikes, int numberOfWheels) {
		this.averageDriveSpeedForBikes = averageDriveSpeedForBikes;
		this.baseNumberForBikes = baseNumberForBikes;
		this.soundOfWorkingEngineForBikes = soundOfWorkingEngineForBikes;
		this.soundOfHornForBikes = soundOfHornForBikes;
		this.numberOfWheels = numberOfWheels;
		quantityOfBikes++;
		quantityOfVehicles++;
	}
	
// Construct a bike with specified parameters
	public Bike(int averageDriveSpeedForBikes, int baseNumberForBikes, String soundOfWorkingEngineForBikes, 
			String soundOfHornForBikes, int numberOfWheels, int generalPosition, int typeOfVehiclePosition, int number, int currentSpeed, String country, String make, 
			String soundOfWorkingEngine, String soundOfHorn, int coveredRaceDistance, int totalDurationOfRace) {
		this.averageDriveSpeedForBikes = averageDriveSpeedForBikes;
		this.baseNumberForBikes = baseNumberForBikes;
		this.soundOfWorkingEngineForBikes = soundOfWorkingEngineForBikes;
		this.soundOfHornForBikes = soundOfHornForBikes;
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
		quantityOfBikes++;
		quantityOfVehicles++;
	}
	
	@Override
	/** Return currentSpeed */
	public int getCurrentSpeed() {
		return (int)(super.currentSpeed + this.averageDriveSpeedForBikes);
	}
	
	/** Return currentSpeed */
	public int getAverageDriveSpeedForBikes() {
		return averageDriveSpeedForBikes;
	}
	
	@Override
	/** Return number */
	public int getNumber() {
		return baseNumberForBikes + super.number;
	}
	
	@Override
	/** Return soundOfWorkingEngine */
	public String getSoundOfWorkingEngine() {
		int bikeNumber = super.number;
		String sound = "";
		for (int i = 0; i < bikeNumber; i++) {
			sound += soundOfWorkingEngineForBikes;
		}
		return sound;
	}
	
	@Override
	/** Return soundOfHorn */
	public String getSoundOfHorn() {
		int bikeNumber = super.number;
		String sound = "";
		for (int i = 0; i < bikeNumber; i++) {
			sound += soundOfHornForBikes;
		}
		return sound;
	}
	
	@Override
	/** Return a string representation of this bike for writing to a file */
	public String writeToFileResultsOfRace() {
		return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
				" Bike " + this.getNumber() + " from " + super.getCountry() + 
				" of the " + super.getMake() + " Company reached the finish in " + Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + 
				Math.round(this.getTotalDurationOfRace() / 60 % 24) +" hours and " + 
						Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
		}
	
	@Override
	/** Return a string representation of this object that will be written to file */
	public String writeToFileVehicles() {
		return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
				" Bike " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company";
		}
	
	/**Return a string description for this bike*/
	@Override
	public String toString() {
		if (super.coveredRaceDistance == 0) {
			return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + " 	       " + 
		" Bike " + this.getNumber() + " from " + super.getCountry() + " of the " + super.getMake() + " Company and its working "
				+ "engine sounds like " + this.getSoundOfWorkingEngine() + "\n";
		} else {
		return "       " + super.getGeneralPosition() + "	                 " + super.getTypeOfVehiclePosition() + "	        " + 
				" Bike " + this.getNumber() + " had the average speed " + this.getCurrentSpeed() + 
				" km/h and has covered " + this.getCoveredRaceDistance() + " km in " + 
						Math.round(this.getTotalDurationOfRace() / 60 / 24) + " days " + 
				Math.round(this.getTotalDurationOfRace() / 60 % 24) +" hours and " + 
						Math.round(this.getTotalDurationOfRace() % 60) + " minutes\n";
		}
	}

}
