package race;

public class Vehicle {
	
	// data fields
	protected int generalPosition;
	protected int typeOfVehiclePosition;
	protected int number;
	protected int numberOfWheels;
	protected int currentSpeed = 0;
	protected String country;
	protected String make;
	protected String soundOfWorkingEngine = "";
	protected String soundOfHorn = "";
	protected int coveredRaceDistance = 0;
	protected int totalDurationOfRace = 0;
	protected static int quantityOfVehicles;
	
	/** Construct a default vehicle */
	public Vehicle() {
	}

	/** Construct a vehicle object with the specified values*/
	public Vehicle(int generalPosition, int typeOfVehiclePosition, int number, int numberOfWheels, int currentSpeed, String country, String make, 
			String soundOfWorkingEngine, String soundOfHorn, int coveredRaceDistance, int totalDurationOfRace) {
		this.generalPosition = generalPosition;
		this.typeOfVehiclePosition = typeOfVehiclePosition;
		this.number = number;
		this.numberOfWheels = numberOfWheels;
		this.currentSpeed = currentSpeed;
		this.country = country;
		this.make = make;
		this.soundOfWorkingEngine = soundOfWorkingEngine;
		this.soundOfHorn = soundOfHorn;
		this.coveredRaceDistance = coveredRaceDistance;
		this.totalDurationOfRace = totalDurationOfRace;
	}
	
	/** Return quantityOfVehicles*/
	static int getQuantityOfVehicles() {
		return quantityOfVehicles;
	}
	
	/** Set generalPosition */
	public void setGeneralPosition(int generalPosition) {
		this.generalPosition = generalPosition;
	}
	
	/** Return generalPosition */
	public int getGeneralPosition() {
		return generalPosition;
	}
	
	/** Set number */
	public void setTypeOfVehiclePosition(int typeOfVehiclePosition) {
		this.typeOfVehiclePosition = typeOfVehiclePosition;
	}
	
	/** Return number */
	public int getTypeOfVehiclePosition() {
		return typeOfVehiclePosition;
	}
	
	/** Set number */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/** Return number */
	public int getNumber() {
		return number;
	}
	
	/** Set numberOfWheels */
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	/** Return numberOfWheels */
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	/** Set currentSpeed */
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = (int)(Math.random() * currentSpeed);
	}
	
	/** Return currentSpeed */
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	/** Set coveredRaceDistance */
	public void setCoveredRaceDistance(int coveredRaceDistance) {
		this.coveredRaceDistance = coveredRaceDistance;
	}
	
	/** Return coveredRaceDistance */
	public int getCoveredRaceDistance() {
		return coveredRaceDistance;
	}
	
	/** Set coveredRaceDistance */
	public void setTotalDurationOfRace(int totalDurationOfRace) {
		this.totalDurationOfRace = totalDurationOfRace;
	}
	
	/** Return coveredRaceDistance */
	public int getTotalDurationOfRace() {
		return totalDurationOfRace;
	}
	
	/** Set a new country */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/** Return country */
	public String getCountry() {
		return country;
	}
	
	/** Set a new make */
	public void setMake(String make) {
		this.make = make;
	}
	
	/** Return make */
	public String getMake() {
		return make;
	}
	
	/** Set a new soundOfWorkingEngine */
	public void setSoundOfWorkingEngine(String soundOfWorkingEngine) {
		this.soundOfWorkingEngine = soundOfWorkingEngine;
	}
	
	/** Return soundOfWorkingEngine */
	public String getSoundOfWorkingEngine() {
		return soundOfWorkingEngine;
	}
	
	/** Set a new soundOfHorn */
	public void setSoundOfHorn(String soundOfHorn) {
		this.soundOfHorn = soundOfHorn;
	}
	
	/** Return soundOfHorn */
	public String getSoundOfHorn() {
		return soundOfHorn;
	}
	
	/** Return a string representation of this object that will be written to file */
	public String writeToFileResultsOfRace() {
		return "country: " + country + "make: " + make;
		}
	
	/** Return a string representation of this object that will be written to file */
	public String writeToFileVehicles() {
		return "vehicle: " + make;
		}
	
	/** Return a string representation of this object */
	public String toString() {
		return "country: " + country;
		}
	
}
