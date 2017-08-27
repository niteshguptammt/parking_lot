package parking;

import parking.inputreaders.InputReader;
import parking.inputreaders.factory.InputReaderFactory;

public class ParkingApp {
	public static void main(String[] args) {
		
		InputReader inputReader = null;
		if (args.length == 0) {
			// It is a terminal based system.
			inputReader = InputReaderFactory
					.getInputReader("terminal");
		} else if (args.length == 1) {
			inputReader = InputReaderFactory
					.getInputReader("textfile");
		}
		inputReader.showInterface(args);
	}

}
