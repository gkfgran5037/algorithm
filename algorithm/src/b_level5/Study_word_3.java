package b_level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class Study_word_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] count = new int[26];
		int max = 0;
		char max_a = 'a';
		
		for (int i=0; i<input.length(); i++) {
			int idx = Character.getNumericValue(input.charAt(i))-10;
			count[idx]++;
			
			if (max < count[idx]) {
				max = count[idx];
				max_a = (char)(idx+65);
			}else if (max == count[idx]) {
				max_a = '?';
			}	
		}
		System.out.println(max_a);
	}

}
