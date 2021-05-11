package pr_al;

import java.util.Arrays;

/** 프로그래머스 K번째수
 *  문제 설명 : 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *  		 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
 *  		commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *  
 *  제약 조건 : array의 길이는 1 이상 100 이하입니다.
 *  		array의 각 원소는 1 이상 100 이하입니다.
 *  		commands의 길이는 1 이상 50 이하입니다.
 *  		commands의 각 원소는 길이가 3입니다.
*/
public class KNum {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		solution(array, commands);
				
	}
	static public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			// copyOfRange(A, B) : A번 째 ~ B-1번 째 배열 복사  
			int[] rangeArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(rangeArr);
			answer[i] = rangeArr[commands[i][2]-1];
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
