package level1;

import java.util.Scanner;

/* 프로그래머스 - 연습문제 - 문자열을 정수로 바꾸기
 * 
 * 분제
 *  - 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 * 
 * 제한조건
 *  - 1) s의 길이는 1 이상 5이하입니다.
 *    2) s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 *    3) s는 부호와 숫자로만 이루어져있습니다.
 *    4) s는 0으로 시작하지 않습니다.
 *      
 * 입출력 예
 *  - 입력  str : 1234 / 출력 : 1234
 *  - 입력  str : -1234 / 출력 : -1234
 */
public class Change_strToNum_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String result = "";
		for (int i=0; i<s.length(); i++) {
			int ch = s.charAt(i);
			if (ch==43)
				result += "+";
			if (ch==45)
				result += "-";
			if (ch>=48)
				result += ch-48;
		}
		int answer = Integer.parseInt(result);
		System.out.println(answer);
	}	
}
