package level1;

import java.util.Arrays;

/* 프로그래머스 - 연습문제 - 서울에서 김서방 찾기
 * 
 * 분제
 *  - String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. 
 *    seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 * 
 * 제한조건
 *  - 1) seoul은 길이 1 이상, 1000 이하인 배열입니다.
 *    2) seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
 *    3) Kim은 반드시 seoul 안에 포함되어 있습니다.
 *      
 * 입출력 예
 *  - 입력 [Jane, Kim] / 출력 : 김서방은 1에 있다
 */
public class FindKim_2 {
	public String solution(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");
		String answer = "김서방은 "+x+"에 있다";
		
		return answer;
	}
	public static void main(String[] args) {
		FindKim_2 findKim_2 = new FindKim_2();
		String[] seoul = {"Jane", "Kim"};
		findKim_2.solution(seoul);
	}
}
