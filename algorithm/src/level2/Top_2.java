package level2;

import java.awt.Point;
import java.util.Arrays;
import java.util.Stack;

public class Top_2 {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Point> st = new Stack<Point>();
 		
		for(int i=heights.length-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
            	if(heights[i] < heights[j]) {
            		st.push(new Point(i+1, j+1));
            		break;
            	}else if(j==0){
            		st.push(new Point(i+1, 0));
				}
            }
        }
		int size = st.size();
        answer[0] = 0;
        
        for(int i=1; i<=size; i++) {
            answer[i] = st.pop().y;
        }
        
        System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public static void main(String[] args) {
		Top_2 t = new Top_2();
		//int[] heights = {6,9,5,7,4};
		//int[] heights = {3,9,9,3,5,7,2};
		int[] heights = {1,5,3,6,7,6,5};
		t.solution(heights);
	}
}
