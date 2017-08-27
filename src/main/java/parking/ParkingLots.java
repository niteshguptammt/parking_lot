package parking;

public class ParkingLots {
	private Integer totalLots;
	private Car[] assignedCarLots;
	private Integer totalCars;
	
	public ParkingLots(Integer totalLots, Car[] assignedCarLots,
			Integer totalCars) {
		this.totalCars = totalCars;
		this.assignedCarLots = assignedCarLots;
		this.totalLots = totalLots;
	}
	public ParkingLots() {
		this.totalCars = 0;
		this.assignedCarLots = new Car[0];
		this.totalLots = 0;
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
		StringBuilder out = new StringBuilder();
		String[] commands = commandLine.split(" ");
		String command = commands[0];
		if ("create_parking_lot".equalsIgnoreCase(command)) {
			// COMMAND:: "create_parking_lot 6"
			if (commands.length == 2 && Integer.parseInt(commands[1]) > 0) {
				Integer lotSize = Integer.parseInt(commands[1]);
				// assign total lots
				this.totalLots = lotSize;
				// assign null to each lot
				assignedCarLots = new Car[totalLots];
				for (int i=0; i < totalLots ; i++) {
					assignedCarLots[i] = null;
				}
				out.append("Created a parking lot with ")
				.append(lotSize).append(" slots");
			} else {
				out.append("Please enter valid command as :: ")
				.append(" create_parking_lot <Positive_integer>");
			}
		} else if ("park".equalsIgnoreCase(command)) {
			// COMMAND :: "park <car_num> <car_colour>"
			if (totalLots < 1) {
				out.append("Please create parking lots using command as :: ")
				.append(" create_parking_lot <Positive_integer>");
			} else if (totalCars >= totalLots) {
				out.append("Sorry, parking lot is full");
			} else if (commands.length == 3) {
				String carNumber = commands[1];
				String carColour = commands[2];
				Car car = new Car(carNumber,carColour);
				
					for (int i=0; i < totalLots ; i++) {
						if (assignedCarLots[i] == null) {
							// whichever lowest number is available, just assign
							car.setSlotNumber(new Integer(i+1));
							assignedCarLots[i] = car;
							totalCars++;
							out.append("Allocated slot number: ")
							.append(car.getSlotNumber());
							break;
						}
					}
				
			} else {
				out.append("Please enter valid command as :: ")
				.append(" park <car_Reg_num> <car_colour>");
			}
		} else if ("leave".equalsIgnoreCase(command)) {
			// COMMAND :: "leave 4"
			if (commands.length == 2) {
				String slotNumber = commands[1];
				if (null != assignedCarLots[Integer.parseInt(slotNumber)-1]) {
					assignedCarLots[Integer.parseInt(slotNumber)-1] = null;
					totalCars--;
					out.append("Slot number ").append(slotNumber).append(" is free");
				} else {
					out.append("Slot number ").append(slotNumber).append(" is already free");
				}
			} else {
				out.append("Please enter valid command as :: ")
				.append(" leave <slot_number>");
			}
		} else if ("status".equalsIgnoreCase(command)) {
			// COMMAND :: "status"
			if (totalCars == 0) {
				out.append("Parking lot is empty");
			} else {
				out.append(String.format("%-10s\t%-20s\t%-10s", "Slot No"
						, "Registration No.", "Colour")).append("\n");
				for (int i=0; i < totalLots ; i++) {
					if (assignedCarLots[i] != null) {
						Car car = assignedCarLots[i];
						out.append(String.format("%-10s\t%-20s\t%-10s", car.getSlotNumber()
								, car.getRegistrationNumber(), car.getColour())).append("\n");
					}
				}
			}
		} else if ("registration_numbers_for_cars_with_colour"
				.equalsIgnoreCase(command)) {
			// COMMAND :: "registration_numbers_for_cars_with_colour white"
			if (commands.length == 2) {
				String colour = commands[1];
				int carWithColourCount = 0;
				for (int i=0; i < totalLots ; i++) {
					if (assignedCarLots[i] != null 
							&& colour.equalsIgnoreCase(assignedCarLots[i].getColour())) {
						Car car = assignedCarLots[i];
						carWithColourCount++;
						out.append(car.getRegistrationNumber()).append(", ");
					}
				}
				if (carWithColourCount == 0) {
					out.append("No car found with colour ").append(colour);
				}
			} else {
				out.append("Please enter valid command as :: ")
				.append(" registration_numbers_for_cars_with_colour <colour>");
			}
			
		} else if ("slot_number_for_registration_number"
				.equalsIgnoreCase(command)) {
			// COMMAND :: "slot_number_for_registration_number HR51"
			if (commands.length == 2) {
				String regNo = commands[1];
				boolean found = false;
				for (int i=0; i < totalLots ; i++) {
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
			} else {
				out.append("Please enter valid command as :: ")
				.append(" slot_number_for_registration_number <reg_no>");
			}
			
		} else if ("slot_numbers_for_cars_with_colour"
				.equalsIgnoreCase(command)) {
			// COMMAND :: "slot_numbers_for_cars_with_colour white"
			if (commands.length == 2) {
				String colour = commands[1];
				int carWithColourCount = 0;
				for (int i=0; i < totalLots ; i++) {
					if (assignedCarLots[i] != null 
							&& colour.equalsIgnoreCase(assignedCarLots[i].getColour())) {
						Car car = assignedCarLots[i];
						carWithColourCount++;
						out.append(car.getSlotNumber()).append(", ");
					}
				}
				if (carWithColourCount == 0) {
					out.append("No car found with colour ").append(colour);
				}
			} else {
				out.append("Please enter valid command as :: ")
				.append(" slot_numbers_for_cars_with_colour <colour>");
			}
		}
		return out.toString();
	}
	
}
