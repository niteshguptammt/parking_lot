package parking.inputreaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileInputReader extends InputReader {

	@Override
	public void showInterface(String[] args) {
		System.out.println("Input:");
		String filename = args[0];
		StringBuilder finalOutput = new StringBuilder();
		
		try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                finalOutput.append("\n").append(sendCommandToParking(line))
                .append("");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("\nOutput:"+finalOutput.toString());
	}

}
