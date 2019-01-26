package b_level4;

import java.io.IOException;

/* 백준알고리즘 1152번 - 단어의 개수 
 * 
 * 분제
 *  - 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
 *    단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 * 
 * 입력
 *  - 첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 
 *    단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
 *    
 * 출력
 *  - 첫째 줄에 단어의 개수를 출력한다.   
 */
public class Words_count_2 {
	public static void main(String[] args) throws IOException {
		char c;
		int ch=0, count = 0, judge = 0;
		
		while ((ch=System.in.read()) != -1) { // 입력 내용을 스페이스 단위로 끊어서 받아들이기. 더 이상 입력되지 않으면 -1 출력
			c = (char)ch; // 입력 단어 c에 저장
			if (Character.isSpace(c)) { // 스페이스가 있을 시 judge를 0으로 지정.
				if (judge == 1) 
					judge=0;
			}
			else { 
				if (judge == 0) { // 스페이스 이후 입력어일 때 개수 카운트. judge는 1로 지정.
					count++;
					judge = 1;
				}
			}
		}
		System.out.print(count);
	}
}
