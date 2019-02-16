package b_level1;

import java.io.IOException;

public class Output_3 {
	public static void main(String[] args) throws IOException {
		int x;
		while ((x = System.in.read()) != -1) {
			System.out.write(x);
		}
	}
}
