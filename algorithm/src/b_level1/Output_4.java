package b_level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader inFile = new BufferedReader(new InputStreamReader(System.in));
		String string;
		
		while((string = inFile.readLine()) != null){
			System.out.println(string);
		}
	}
}
