package parking;

import java.util.Scanner;

public class ParkingLots {
	private Integer totalLots;
	private Car[] assignedCarLots;
	private Integer totalCars;
	
	public ParkingLots(Integer totalLots, Car[] assignedCarLots,
			Integer totalCars) {
		this.totalCars = totalCars;
		this.assignedCarLots = assignedCarLots;
		this.totalLots = totalLots;
		// TODO Auto-generated constructor stub
	}
	public ParkingLots() {
		this.totalCars = 0;
		this.assignedCarLots = new Car[0];
		this.totalLots = 0;
		// TODO Auto-generated constructor stub
	}
	public Integer getTotalLots() {
		return totalLots;
	}
	public void setTotalLots(Integer totalLots) {
		this.totalLots = totalLots;
	}
	public Car[] getAssignedCarLots() {
		return assignedCarLots;
	}
	public void setAssignedCarLots(Car[] assignedCarLots) {
		this.assignedCarLots = assignedCarLots;
	}
	public Integer getTotalCars() {
		return totalCars;
	}
	public void setTotalCars(Integer totalCars) {
		this.totalCars = totalCars;
	}
	public String sendCommand(String commandLine) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		String[] commands = commandLine.split(" ");
		String command = commands[0];
		if ("create_parking_lot".equalsIgnoreCase(command)) {
			// COMMAND:: "create_parking_lot 6"
			Integer lotSize = scanner.nextInt();
			if (lotSize > 0) {
				pLotSize = lotSize;
				assignedCarLots = new Car[pLotSize];
				for (int i=0; i < pLotSize ; i++) {
					assignedCarLots[i] = null;
				}
				out.append("Created a parking lot with ")
				.append(lotSize).append(" slots");
			}
		} else if ("park".equalsIgnoreCase(command)) {
			String carNumber = scanner.next();
			String carColour = scanner.next();
			Car car = new Car(carNumber,carColour);
			boolean parked = false;
			if (totalCars < pLotSize) {
				for (int i=0; i < pLotSize ; i++) {
					if (assignedCarLots[i] == null) {
						car.setSlotNumber(new Integer(i+1));
						assignedCarLots[i] = car;
						parked = true;
						out.append("Allocated slot number: ")
						.append(car.getSlotNumber());
						break;
					}
				}
			}
			if (!parked) {
				out.append("Sorry, parking lot is full");
			}
		} else if ("leave".equalsIgnoreCase(command)) {
			String slotNumber = scanner.next();
			assignedCarLots[Integer.parseInt(slotNumber)-1] = null;
			out.append("Slot number ").append(slotNumber).append(" is free");
		} else if ("status".equalsIgnoreCase(command)) {
			out.append(String.format("%-10s\t%-20s\t%-10s", "Slot No"
					, "Registration No.", "Colour")).append("\n");
			for (int i=0; i < pLotSize ; i++) {
				if (assignedCarLots[i] != null) {
					Car car = assignedCarLots[i];
					out.append(String.format("%-10s\t%-20s\t%-10s", car.getSlotNumber()
							, car.getRegistrationNumber(), car.getColour())).append("\n");
				}
			}
		} else if ("registration_numbers_for_cars_with_colour"
				.equalsIgnoreCase(command)) {
			String colour = scanner.next();
			for (int i=0; i < pLotSize ; i++) {
				if (assignedCarLots[i] != null 
						&& colour.equalsIgnoreCase(assignedCarLots[i].getColour())) {
					Car car = assignedCarLots[i];
					out.append(car.getRegistrationNumber()).append(", ");
				}
			}
		} else if ("slot_number_for_registration_number"
				.equalsIgnoreCase(command)) {
			String regNo = scanner.next();
			boolean found = false;
			for (int i=0; i < pLotSize ; i++) {
				if (assignedCarLots[i] != null 
						&& regNo.equalsIgnoreCase(assignedCarLots[i]
								.getRegistrationNumber())) {
					Car car = assignedCarLots[i];
					out.append(car.getSlotNumber());
					found = true;
					break;
				}
			}
			if (!found) {
				out.append("Not found");
			}
		} else if ("slot_numbers_for_cars_with_colour"
				.equalsIgnoreCase(command)) {
			String colour = scanner.next();
			for (int i=0; i < pLotSize ; i++) {
				if (assignedCarLots[i] != null 
						&& colour.equalsIgnoreCase(assignedCarLots[i].getColour())) {
					Car car = assignedCarLots[i];
					out.append(car.getSlotNumber()).append(", ");
				}
			}
		}
		return out.toString;
	}
	
}
