package level5;

import java.util.Arrays;

class Solution { //실패
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for (int i=0; i<n; i++) {
			String map1 = Integer.toBinaryString(arr1[i]);
			String map2 = Integer.toBinaryString(arr2[i]);
			answer[i] = "";
			
			String no_min_arr = map1.length()>=map2.length()? map1 : map2;
			int min_length = Math.min(map1.length(), map2.length());
			
			System.out.println("\n"+map1+" , "+map2);
			for (int j=0; j<n-min_length; j++) {
				if (no_min_arr.charAt(j) == '0') {
					answer[i] += " ";
				}else {
					answer[i] += "#";
				}
			}
			
			for (int j=0; j<min_length; j++) {
				int x = -min_length+j; 
				if (map1.charAt(map1.length()+x)=='0') {
					if (map1.charAt(map1.length()+x)==map2.charAt(map2.length()+x)) {
						answer[i] += " ";
						continue;
					}	
				}
				answer[i] += "#";
			}
		}
		return answer;
	}
}

public class Secret_map_1 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		String[] answer = solution.solution(n, arr1, arr2);
		System.out.println(Arrays.toString(answer));
	}
}
