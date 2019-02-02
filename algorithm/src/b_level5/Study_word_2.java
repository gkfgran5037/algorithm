package b_level5;

import java.io.IOException;

/* 백준알고리즘 1157번 - 단어공부
 * 
 * 분제
 *  - 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * 
 * 입력
 *  - 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *    
 * 출력
 *  - 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class Study_word_2 {
	public static void main(String[] args) throws IOException {
		int[] count = new int[26];
		for (int c = System.in.read(); c >= 65; c = System.in.read()) {
			count[Character.toUpperCase(c) - 65] += 1;
		}

		int index = 0;
		boolean isDuplicate = false;
		for (int max = count[0], i = 1; i < 26; i++) {
			if (count[i] > max) {
				max = count[i];
				index = i;
				isDuplicate = false;
			} else if (count[i] == max) {
				isDuplicate = true;
			}
		}
		if (isDuplicate) {
			System.out.println("?");
		} else {
			System.out.println((char) (65 + index));
		}
	}
}
