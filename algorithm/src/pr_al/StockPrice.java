package pr_al;

import java.util.Stack;

/** 프로그래머스 주식가격 - 스택/큐
 * 
 * 문제 서명 ) 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한 사항 ) prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * 			prices의 길이는 2 이상 100,000 이하입니다.
*/
public class StockPrice {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3}; 
		solution(prices);
	}
	
	// 방법 1 : 단순 이중 for문 : 시간복잡도 O(n2) -> 효율성 떨어짐
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
        	for (int j = i+1; j < answer.length; j++) {
        		answer[i]++;
        		
        		if (prices[i] > prices[j]) {
        			break;
        		}
			}
		}
        
        return answer;
    }
	
	/* 방법 2 : stack
	 * 
	 * prices = {1, 2, 3, 2, 3}
	 * 
	 * i=0 : !isEmpty(F) -> stack = [0]
	 * 
	 * i=1 : stack.peek()=0, prices[1] < price[0] (F) -> stack = [0, 1]
	 * 
	 * i=2 : stack.peek()=1, prices[2] < price[1] (F) -> stack = [0, 1, 2]  
	 * 
	 * i=3 : stack.peek()=2, prices[3] < price[2] (T) -> answer[2] = 3 - 2 -> stack.pop() -> stack = [0, 1], answer = [0, 0, 1, 0, 0]
	 * i=3 : stack.peek()=1, prices[3] < price[1] (T) -> answer[1] = 3 - 1 -> stack.pop() -> stack = [0], answer = [0, 2, 1, 0, 0]
	 * i=3 : stack.peek()=0, prices[3] < price[0] (F) -> stack = [0, 3]
	 * 					  							   
	 * i=4 : stack.peek()=3, prices[4] < price[3] (T) -> answer[3] = 4 - 3 -> stack.pop() -> stack = [0], answer = [0, 2, 1, 1, 0]
	 * i=4 : stack.peek()=0, prices[4] < price[0] (T) -> answer[0] = 4 - 0 -> stack.pop() -> stack = [] -> stack = [4], answer = [4, 2, 1, 1, 0]
	 * 
	 * 
	 * isEmpty(T) -> answer[4] = 5 - 4 - 1 = 0  -> stack.pop() -> stack = [] -> stack = [], answer = [4, 2, 1, 1, 0]
	*/
	public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
        	// 금액이 낮아질 경우
        	while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        		// 삽입 시점 금액에서 상승 유지 시간 = 낮아지는 시점 - 삽입한 시점
        		answer[stack.peek()] = i - stack.peek();
				// 삽입 시점 삭제
        		stack.pop();
			}
        	// 현재 시점 보다 높은 금액이 없을 경우 삽입
        	stack.push(i);
        }
        
        // 끝까지 가격 떨어지지 않은 주식
        while (!stack.isEmpty()) {
        	// 전체 시간 - 삽입 시점 - 1
			answer[stack.peek()] = prices.length - stack.peek() -1;
			stack.pop();
		}
        
        return answer;
	}
}
