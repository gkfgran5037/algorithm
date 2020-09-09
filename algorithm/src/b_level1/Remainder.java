package b_level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 백준알고리즘 10430번 - 나머지
 *    
 * 문제 
 *  - (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
 *    (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
 *    세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오. 
 * 
 * 입력
 *  - 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
 *    
 * 출력
 *  - 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
 */

public class Remainder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		
		int num1 = Integer.parseInt(nums[0]);
		int num2 = Integer.parseInt(nums[1]);
		int num3 = Integer.parseInt(nums[2]);
		
		System.out.println((num1+num2)%num3);
		System.out.println(((num1+num3)+(num2+num3))%num3);
		System.out.println((num1*num2)%num3);
		System.out.println(((num1%num3)*(num2%num3))%num3);
	}
}
/*
 * public class Remainder { public static void main(String[] args) throws
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); StringTokenizer st = new
 * StringTokenizer(br.readLine());
 * 
 * int num1 = Integer.parseInt(st.nextToken()); int num2 =
 * Integer.parseInt(st.nextToken()); int num3 =
 * Integer.parseInt(st.nextToken());
 * 
 * System.out.println((num1+num2)%num3);
 * System.out.println(((num1+num3)+(num2+num3))%num3);
 * System.out.println((num1*num2)%num3);
 * System.out.println(((num1%num3)*(num2%num3))%num3); } }
 */