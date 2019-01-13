package level2;

import java.util.Arrays;

public class Work_day_2 {
	public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
     
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
	
	public static void main(String[] args) {
		Work_day_2 work_day = new Work_day_2();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		work_day.solution(progresses, speeds);
	}
}
