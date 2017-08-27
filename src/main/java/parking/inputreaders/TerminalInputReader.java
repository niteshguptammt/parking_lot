package parking.inputreaders;

import java.util.Scanner;

public class TerminalInputReader extends InputReader {

	@SuppressWarnings("resource")
	@Override
	public void showInterface(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Input:");
			String command = scanner.nextLine();
			System.out.println("\nOutput:\n"+sendCommandToParking(command)+"\n");
		}
	}

}
