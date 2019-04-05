package level2;

import java.util.Stack;

/* 프로그래머스 - 스택/큐 - 쇠막대기
 * 분제
 *  - 여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 
 *    효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 
 *    쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때, 
 *    잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.
 *    
 * 제한사항
 *  - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
 *  - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
 *  - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
 *  - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
 *  - arrangement의 길이는 최대 100,000입니다.
 *  - arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
 *  
 *  입력 : ()(((()())(())()))(())
 *  출력 : 17
 */
public class CutIronBar_2 {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < arrangement.length(); i++) {
			char ch = arrangement.charAt(i);
			
			if (ch == '(') {
				st.push(i);
			}else if (ch == ')') { 
				if (st.peek()+1 == i) { /* ()일 경우 */
					st.pop();
					answer += st.size();
				}else {
					st.pop();
					answer++; /* 끄트머리 개수 포함시키기  */
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CutIronBar_2 c = new CutIronBar_2();
		String arrangement = "()(((()())(())()))(())";
		c.solution(arrangement);
	}
}
