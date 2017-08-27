package parking.inputreaders.factory;

import parking.inputreaders.IInputReader;
import parking.inputreaders.InputReaderImpl;
import parking.inputreaders.TerminalInputReader;

public class InputReaderFactory {
	
	public static InputReaderImpl getInputReader(String type) {
		if ("terminal".equalsIgnoreCase(type)) {
			return new TerminalInputReader();
		}
		return new TerminalInputReader();
	}

}
