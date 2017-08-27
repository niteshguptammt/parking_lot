package parking.inputreaders.factory;

import parking.inputreaders.InputReader;
import parking.inputreaders.TerminalInputReader;
import parking.inputreaders.TextFileInputReader;

public class InputReaderFactory {
	
	public static InputReader getInputReader(String type) {
		if ("terminal".equalsIgnoreCase(type)) {
			return new TerminalInputReader();
		} else if ("textfile".equalsIgnoreCase(type)) {
			return new TextFileInputReader();
		}
		return new TerminalInputReader();
	}

}
