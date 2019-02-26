package level1;

import java.util.Scanner;

/* 프로그래머스 - 연습문제 - 수박수박수박수박수박수?
 * 
 * 분제
 *  - 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
 *    예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
 * 
 * 제한조건
 *  - n은 길이 10,000이하인 자연수입니다.
 *      
 * 입출력 예
 *  - 입력  3 / 출력 : 수박수
 *  - 입력  4 / 출력 : 수박수박
 */
public class SuBakSuBak_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = "";
		
		for (int i=0; i<n; i++) {
			if (i%2==0) {
				s += "수";
			}else {
				s += "박";
			}
		}
		System.out.println(s);
	}
}
