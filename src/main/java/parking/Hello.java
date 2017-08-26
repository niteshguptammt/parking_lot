package parking;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;




public class Hello {
	
	

	public static void main(String[] args) {
		
		ParkingLots parking = new ParkingLots();
		
		if (args.length == 0) {
			// It is a terminal based system.
			Scanner scanner = new Scanner(System.in);
			while(true) {
				//StringBuilder out = new StringBuilder();
				System.out.println("Input:");
				String command = scanner.nextLine();
				//out.append(command);
				//parking.sendCommand(command);
				
				
				System.out.println("\nOutput:\n"+parking.sendCommand(command)+"\n");
			}
		}
	}

}
