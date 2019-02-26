package level1;

/* 프로그래머스 - 연습문제 - 약수의 합
 * 
 * 분제
 *  - 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 * 
 * 제한조건
 *  - n은 0 이상 3000이하인 자연수입니다.
 *      
 * 입출력 예
 *  - 입력 12 / 출력 : 28
 *  - 입력 5 / 출력 : 6
 */
public class Sum_divisor_2 {
	public int solution(int n) {
		int answer = 0;
		for (int i=1; i<=n/2; i++) {
			if (n%i==0) 
				answer += i;
		}
		answer += n;
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		Sum_divisor_2 divisor_2 = new Sum_divisor_2();
		int n = 12;
		divisor_2.solution(n);
	}
}
