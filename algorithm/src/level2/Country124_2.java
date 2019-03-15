package level2;

/* 프로그래머스 - 연습문제 - 124 나라의 숫자
 * 분제
 *  - 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 *    124 나라에는 자연수만 존재합니다. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다. 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 *    [1, 2, 3,  4,  5,  6,  7,  8,  9, 10, 11, 12,  13,  14,  15,  16,  17,  18..]
 *    [1, 2, 4, 11, 12, 14, 21, 22, 24, 41, 42, 44, 111, 112, 114, 121, 122, 124..]
 *    자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 *    
 * 제한사항
 *  - n은 500,000,000이하의 자연수 입니다.
 */
public class Country124_2 {
	public String solution(int n) {
		String answer = "";
	
		if (n > 0) {
			int rest = n % 3;
			answer = ((rest == 0) ? "4" : (rest == 1) ? "1" : "2") + answer;
			answer = solution((n-1)/3) + answer;
		}
		return answer;
	}   
	public static void main(String[] args) {
		Country124_2 c = new Country124_2();
		c.solution(9);
	}
}
