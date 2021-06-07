package pr_al;

import java.util.Arrays;
import java.util.PriorityQueue;

/** 프로그래머스 디스크 컨트롤러 - 힙
 * 
 * 문제 설명 : 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 
 * 			디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 
 * 			가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 * 			- 0ms 시점에 3ms가 소요되는 A작업 요청
 *          - 1ms 시점에 9ms가 소요되는 B작업 요청
 *          - 2ms 시점에 6ms가 소요되는 C작업 요청
 *          각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 
 *          작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. 
 *          (단, 소수점 이하의 수는 버립니다)
 * 
 * 
 * 제한 사항 : jobs의 길이는 1 이상 500 이하입니다.
 *          jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
 *          각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
 *          각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
 *          하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
*/
public class DiskController {
	
	public static void main(String[] args) {
		int[][] jobs = {{0,3}, {1,9}, {2,6}};
		System.out.println(solution(jobs));
	}
	
	
	// 방법 1 
	public static int solution(int[][] jobs) {
        int answer = 0;
        int jobsIdx = 0;
        int count = 0; // 수행작업
        int end = 0;   // 작업 종료 시간
        
        // 이차원 베열 [0][1]
        
        // 요청시간 오름차순 (0열)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 처리시간 오름차순 (1열) -> 다차원 배열일 경우 정렬 기준을 comparable로 명시해야함 -> 지정 안 할 시 ClassCastException 발생
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 모두 작업
        while (count < jobs.length) {
        	// 현재, 작업 요청 시점이 이미 지나버린 경우 모두 큐에 넣음 
        	// 작업 요청시점 <= 총 작업 처리 시간 (여태까지 작업 처리한 시간)
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				// 현재 작업 후 진행 될 작업들 삽입
				// 요청시간 오름차순 정렬 후, 현재 작업 완료 이전의 작업들을 처리시간 오름치순으로 정렬하여 삽입
				queue.add(jobs[jobsIdx++]);
			}
			
			// 큐가 비었을 때 
			if (queue.isEmpty()) {
				// 큐에 넣었던 마지막 작업의 요청 시점
				end = jobs[jobsIdx][0];
			} else {
				int[] temp = queue.poll(); 			// 요청시간(오름차순) 처리시간(오름차순)
				answer += temp[1] + end - temp[0];  // 총소요시간(작업간 텀 포함) += 현재 작업 처리시간 + 총 작업 처리시간 - 현재 작업 요청 시점    
				end += temp[1]; // 작업 종료 시간 += 총 작업 처리시간
				count++; 		// 수행작업
			}
		}
        // 작업의 요청부터 종료까지 걸린 시간의 평균
        return answer/jobs.length;
    }
}
