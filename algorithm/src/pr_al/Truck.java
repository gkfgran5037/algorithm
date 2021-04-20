package pr_al;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 프로그래머스 - 다리를 지나는 트럭
 *  
 *  문제 설명 : 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
 *  		모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
 *  		트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 *  		※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 *  		solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 
 *  		이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 *  
 *  제한조건 : bridge_length는 1 이상 10,000 이하입니다.
 *          weight는 1 이상 10,000 이하입니다.
 *          truck_weights의 길이는 1 이상 10,000 이하입니다.
 *          모든 트럭의 무게는 1 이상 weight 이하입니다.
*/
public class Truck {
	
	public static void main(String[] args) {
		int[] a = {7, 4, 5, 6};
		System.out.println(solution(2, 10, a));;
	}
	
	// 방법 1 :
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new ConcurrentLinkedQueue<>();
        int sumWeight = 0;
        
        for (int truckWeight : truck_weights) {
        	while (true) {
        		// 새트럭이 다리를 건널 수 있을 때
        		if (bridge.isEmpty()) {
        			bridge.add(truckWeight);
        			sumWeight += truckWeight;
        			answer++;
        			break;
        		} else if (bridge.size() == bridge_length) {
        			// 트럭이 다리를 건넜을 때
        			sumWeight -= bridge.poll();
        		} else {
        			answer++;
        			// 새트럭이 다리를 건널 수 있을 때
        			if (weight >= sumWeight+truckWeight) {
        				bridge.add(truckWeight);
        				sumWeight += truckWeight;
        				break;
        			} 
        			// 새트럭이 다리를 건널 수 없을 때
        			bridge.add(0);
        		}
			}
		}
        return answer + bridge_length;
    }
}
