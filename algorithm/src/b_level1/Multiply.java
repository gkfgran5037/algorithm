package b_level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 백준알고리즘 10998번 - A*B
 *    
 * 문제 
 *  - 두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 *  - 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
 *    
 * 출력
 *  - 첫째 줄에 A×B를 출력한다.
 */

/**
 * 방법 5 : BufferdReader, StringTokenizer, parseInt
 * 시간 : 68ms
 */
public class Multiply {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());	
		
		System.out.println(num1*num2);
	}
}



/**
 * 방법 4 : BufferdReader, Character.getNumericValue 
 * 시간 : 68ms
 */
/*
 * public class Multiply { public static void main(String[] args) throws
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in));
 * 
 * int num1 = Character.getNumericValue(br.read()); br.read(); int num2 =
 * Character.getNumericValue(br.read());
 * 
 * System.out.println(num1 * num2); } }
 */


/**
 * 방법 3 : BufferdReader, String[], split, parseInt 
 * 시간 : 68ms
 */
/*
 * public class Multiply { public static void main(String[] args) throws
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); String str = br.readLine(); String[] nums =
 * str.split(" ");
 * 
 * int num1 = Integer.parseInt(nums[0]); int num2 = Integer.parseInt(nums[1]);
 * 
 * System.out.println(num1*num2); } }
 */



/**
 * 방법 2 : System.in.read , ch-48 
 * 시간 : 68ms
 */
/*
 * public class Multiply { public static void main(String[] args) throws
 * IOException { int num1 = System.in.read(); System.in.read(); //space 처리 int
 * num2 = System.in.read();
 * 
 * System.out.println((num1-48)*(num2-48)); } }
 */



/**
 * g 방법 1 : Scanner, nextInt() 
 * 시간 : 116ms
 */
/*
 * public class Multiply { public static void main(String[] args) { Scanner sc =
 * new Scanner(System.in); int num1, num2; num1 = sc.nextInt(); num2 =
 * sc.nextInt();
 * 
 * System.out.println(num1 * num2); } }
 */