package parking.inputreaders;

import parking.ParkingLots;

public abstract class InputReader {

	private ParkingLots parking = new ParkingLots();
	
	public abstract void showInterface(String[] args);
	
	public ParkingLots getParking() {
		return parking;
	}

	public void setParking(ParkingLots parking) {
		this.parking = parking;
	}

	public String sendCommandToParking(String command) {
		return parking.sendCommand(command);
	}

}
