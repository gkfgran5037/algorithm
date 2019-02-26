package level1;

import java.util.ArrayList;
import java.util.List;

public class Budget {
	class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;
			int sum = 0;
			List<Integer> max = new ArrayList(); 
			
			for (int i=0; i<d.length; i++) {
				max.indexOf(sum);
				sum += d[i];
			}
			
			if (sum <= budget) 
				return d.length;
			
			return answer;
		}
	}

	public static void main(String[] args) {
	}
}
