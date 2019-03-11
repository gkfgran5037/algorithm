package level1;

import java.util.Arrays;

/* 프로그래머스 - 연습문제 - 나누어 떨어지는 숫자 배열
 * 
 * 분제
 *  - array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 *    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 * 
 * 제한조건
 *  - 1) arr은 자연수를 담은 배열입니다.
 *    2) 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 *    3) divisor는 자연수입니다.
 *    4) array는 길이 1 이상인 배열입니다.
 *      
 * 입출력 예
 *  - 입력 arr : [5, 9, 7, 10] , divisor : 5 / 출력 : [5, 10]
 *  - 입력 arr : [2, 36, 1, 3] , divisor : 1 / 출력 : [1, 2, 3, 36]
 *  - 입력 arr : [3,2,6] , divisor : 10 / 출력 : [-1]
 */
public class DivideArray_2 {
	public int[] solution(int[] arr, int divisor) {
	      return Arrays.stream(arr).filter(i -> i%divisor==0).toArray();
	  }
	
	public static void main(String[] args) {
		DivideArray_1 d = new DivideArray_1();
		//int[] arr = {3,2,6};
		//int divisor = 10;
		int[] arr = {2,36,1,3};
		int divisor = 1;
		//int[] arr = {5,9,7,10};
		//int divisor = 5;
		
		System.out.println(d.solution(arr, divisor));
	}
}
