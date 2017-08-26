package parking;

import java.util.Scanner;




public class Hello {
	
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ParkingLots parking = new ParkingLots();
		
		if (args.length == 0) {
			// It is a terminal based system.
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println("Input:");
				String command = scanner.nextLine();
				System.out.println("\nOutput:\n"+parking.sendCommand(command)+"\n");
			}
		}
	}

}
