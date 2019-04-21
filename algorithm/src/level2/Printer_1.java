package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 프로그래머스 - 스택/큐 - 프린터
 * 분제
 *  - 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
 *    이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
 *    이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *    현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 
 *    내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
 *    내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * 진행방법
 *  1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 *  2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 *  3. 그렇지 않으면 J를 인쇄합니다.
 *     
 * 제한사항
 *  - 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 *  - 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 *  - location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 *  
 *  입력 : priorities : [2, 1, 3, 2] , location : 2 / 출력 : 1
 *  입력 : priorities : [1, 1, 9, 1, 1, 1] , location : 0 / 출력 : 5
 */
public class Printer_1 { 
	public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Document_1> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
			que.add(new Document_1(i, priorities[i]));
		}
        
        Document_1 firstDc = null;
        while (que.size() > 1) {
        	firstDc = que.getFirst();
        	for (int i = 0; i < que.size(); i++) {
				if (firstDc.priority < que.get(i).priority) {
					que.addLast(firstDc);
					que.removeFirst();
					break;
				}
				
				if (i == que.size() - 1) {
					if (firstDc.idx == location) {
						return answer;
					}
					que.removeFirst();
					answer++;
				}
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		Printer_1 p = new Printer_1();
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		p.solution(priorities, location);
	}
}
