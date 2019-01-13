package level2;

import java.util.ArrayList;
import java.util.List;

public class Work_day_1 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
        int[] workday = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
        	workday[i] = (100 - progresses[i])/speeds[i];
        	if(progresses[i]+workday[i] != 100)
        		workday[i] += 1;
        }
        List<Integer> answer_list = new ArrayList<Integer>();
        for(int i=0; i< workday.length;) {
        	int n = 1;
        	for(int j=1; j<workday.length-i; j++) {
        		if(workday[i]>=workday[i+j]) { //같을 시 한 꺼번에 배포
        			n += 1;
        		}else {
        			break;
        		}
        	}
        	answer_list.add(n);
        	i+=n;
        }
        answer = new int[answer_list.size()];
        for(int i=0; i< answer_list.size(); i++) {
        	answer[i] = answer_list.get(i); 
        }

        return answer;
	}
	
	public static void main(String[] args) {
		Work_day_1 work_day = new Work_day_1();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		work_day.solution(progresses, speeds);
	}
}
