package pr_al;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 
 *  문제 설명 : 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *  		 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
 *  		이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *  		먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
 *  		각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *  
 *  제약 조건 : 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 *  		작업 진도는 100 미만의 자연수입니다.
 *  		작업 속도는 100 이하의 자연수입니다.
 *  		배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
 *  		예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
*/
public class FunctionDvl {
	
	// 
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        
        // 각 기능별 소요일 세팅
        for (int i = 0; i < progresses.length; i++) {
        	// 잔여 진도율%개발속도가 일자로 끊어지지 않으면 남은 시간은 +1일로 세팅
        	queue.add((100-progresses[i])%speeds[i]==0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i] + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        // 첫 번째 기능 소요일
        int prevFunc = queue.poll();
        // 배치하는 기능수
        int numOfFuncs = 1;
        
        while (!queue.isEmpty()) {
			int curFunc = queue.poll();
			// 이전 기능의 소요일이 더 오래걸리는 경우, 배치하는 기능 수를 증가한다.
			if (prevFunc >= curFunc) {
				numOfFuncs++;
			} else { // 다음 기능 소요일이 더 오래걸리는 경우, 이전 기능까지의 배치 기능 수를 세팅한다.
				list.add(numOfFuncs);
				prevFunc = curFunc;
			}
		}
        // 마지막 배치 기능 수 세팅
        list.add(numOfFuncs);
        //
        return list.stream().mapToInt(x->x).toArray();
    }
}
