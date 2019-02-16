package b_level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output_2 {
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String lineReader = null;

		boolean isTrue = true;
		while(isTrue){
		    lineReader = br.readLine();
		    if(lineReader != null){
		        sb.append(lineReader+"\n");
		        isTrue = true;
		    }else{
		        isTrue = false;
		    }
		}
	    System.out.println(sb.toString());
	}
}
