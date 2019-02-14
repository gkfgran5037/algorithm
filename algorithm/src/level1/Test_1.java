package level1;

import java.util.ArrayList;
import java.util.List;

/* 프로그래머스 - 완전탐색 - 모의고사
 * 
 * 분제
 *  - 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 *    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 *    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한조건
 * 
 *  - 시험은 최대 10,000 문제로 구성되어있습니다.
 *    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 *    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 *    
 * 입출력 예
 *  - 입력 [1,2,3,4,5] / 출력 [1]
 *  - 입력 [1,3,2,4,2] / 출력 [1,2,3]
 */
class Solution {
    public int[] solution(int[] answers) {
        int[] student_1 = {1, 2, 3, 4, 5};
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int[] count = {0, 0, 0};
    	List<Integer> list = new ArrayList();
        int[] answer;
        
        for (int i=0; i<answers.length; i++) {
        	if (answers[i]==student_1[i%student_1.length]) 
        		count[0]++;
        	
        	if (answers[i]==student_2[i%student_2.length]) 
        		count[1]++;
        	
        	if (answers[i]==student_3[i%student_3.length]) 
        		count[2]++;
		}
        
        list.add(1);
        int max = count[0];
        for (int i=1; i<count.length; i++) {
        	if (max<count[i]) {
        		max = count[i];
        		list.clear();
        		list.add(i+1);
			}else if (max==count[i]) {
				list.add(i+1);
			}
        }
        answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}

public class Test_1 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] answers = {2,3,2,1,2};
		s.solution(answers);
	}
}
