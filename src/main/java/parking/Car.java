package parking;

public class Car {
	private Integer slotNumber;
	private String registrationNumber;
	private String colour;
	public Car(String registrationNumber, String colour) {
		this.registrationNumber = registrationNumber;
		this.colour = colour;
		// TODO Auto-generated constructor stub
	}
	public Integer getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
