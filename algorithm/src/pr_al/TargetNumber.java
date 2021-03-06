package pr_al;

/** 프로그래머스  타겟 넘버 - DFS/BFS
 * 
 * 문제 설명 : n개의 음이 아닌 정수가 있습니다. 
 *         이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
 *         예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *         -1+1+1+1+1 = 3
 *         +1-1+1+1+1 = 3
 *         +1+1-1+1+1 = 3
 *         +1+1+1-1+1 = 3
 *         +1+1+1+1-1 = 3
 *         사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
 *         타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 : 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 *         각 숫자는 1 이상 50 이하인 자연수입니다.
 *         타겟 넘버는 1 이상 1000 이하인 자연수입니다.
*/
public class TargetNumber {
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // sum : 0
        // 경우1 : sum + numbers[0] = numbers[0]
 		// 경우2 : sum - numbers[0] = -numbers[0]
 		// result = 경우 1 성공여부 + 경우 2 성공여부
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        return answer;
    }
	
	
	// dfs: 깊이 우선 탐색
	// 0    +        -
	// 1  +   -    +   -  
	// 2 + - + -  + - + -
 	public int dfs(int[] numbers, int target, int sum, int i) {
		if (i == numbers.length) {
			return sum==target? 1 : 0;
		}
		int result = 0;
		// sum : numbers를 i-1까지 + 또는 -연산한 결과 
		// 경우1 : sum + numbers[i]
		// 경우2 : sum - numbers[i]
		// result = 경우 1 성공여부 + 경우 2 성공여부 
		result += dfs(numbers, target, sum+numbers[i], i+1);
		result += dfs(numbers, target, sum-numbers[i], i+1);
		//
		return result;
	}
}
