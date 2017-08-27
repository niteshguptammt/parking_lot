package parking;

import java.util.Scanner;

import parking.inputreaders.IInputReader;
import parking.inputreaders.InputReaderImpl;
import parking.inputreaders.factory.InputReaderFactory;

public class ParkingApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ParkingLots parking = new ParkingLots();
		InputReaderImpl inputReader = null;
		if (args.length == 0) {
			// It is a terminal based system.
			inputReader = InputReaderFactory
					.getInputReader("terminal");
			/*Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println("Input:");
				String command = scanner.nextLine();
				System.out.println("\nOutput:\n"+parking.sendCommand(command)+"\n");
			}*/
		}
		inputReader.showInterface();
	}

}
