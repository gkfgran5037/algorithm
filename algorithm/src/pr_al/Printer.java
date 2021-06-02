package pr_al;

import java.util.Collections;
import java.util.PriorityQueue;

/* 프로그래머스  프린터 - 스택/큐
 * 
 * 문제 설명 : 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
 * 			1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 			2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 			3. 그렇지 않으면 J를 인쇄합니다.
 * 			현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 
 * 			내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
 * 			내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항 : 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 			인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * 			location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
*/
public class Printer {
	
	// 방법 1: PriorityQueue 사용
	public int solution(int[] priorities, int location) {
        int answer = 1;
        
        // 우선순위가 낮은 숫자 순 : new PriorityQueue<>();
        // 우선순위가 높은 숫자 순 : new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 중요도 세팅
        for (int priority : priorities) {
			queue.offer(priority);
		}
        // 큐 순회 반복
        while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				// 우선순위에 해당
				if (priorities[i] == queue.peek()) {
					// 요청한 문서일 때
					if (location == i) {
						return answer;
					}
					// 다른 문서 일때 출력순서++
					answer++;
					queue.poll();
				}
			}
		}
        
        return answer;
    }
	
	
	
	
	// 방법 2 : 
	public int solution2(int[] priorities, int location) {
        int answer = 0;
        
        
        
        
        return answer;
	}
}
