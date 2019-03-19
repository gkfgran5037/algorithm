package level2;

import java.util.Arrays;

public class Top_1 {
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;

        for (int i=1; i<heights.length; i++) {
        	for (int j = i-1; j>=0; j--) {
				if (heights[i]<heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		Top_1 t = new Top_1();
		//int[] heights = {6,9,5,7,4};
		//int[] heights = {3,9,9,3,5,7,2};
		int[] heights = {1,5,3,6,7,6,5};
		t.solution(heights);
	}
}
