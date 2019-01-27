package b_level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백준알고리즘 2920번 - 음계 
 * 
 * 분제
 *  - 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
 *    1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 *    연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 * 
 * 입력
 *  - 첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
 *    
 * 출력
 *  - 첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
 */
public class Ascending_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim().replace(" ", "");

		if (input.charAt(0) == '1') {
			for (int i=0; i<input.length(); i++) {
				if ((int)input.charAt(i)-48 != i+1) {
					System.out.println("mixed");
					break;
				}
				if (i==input.length()-1)
					System.out.println("ascending");
			}
		}else if (input.charAt(0) == '8') {
			for (int i=0; i<input.length(); i++) {
				if ((int)input.charAt(i)-48 != 8-i) {
					System.out.println("mixed");
					break;
				}
				if (i==input.length()-1)
					System.out.println("descending");
			}
		}else {
			System.out.println("mixed");
		}
	}
}
