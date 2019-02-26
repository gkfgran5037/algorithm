package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_3 {
	public static void main(String[] args) {
		/*int[] healths = {200,120,150};
		int[][] items = {{30,100},{500,30},{100,400}}; */
		int[] healths = {300,200,500};
		int[][] items = {{1000,600},{400,500},{300,100}}; 
		List<Integer> list = new ArrayList<Integer>(); 
		
		Arrays.sort(healths);
		for (int i=0; i<healths.length; i++) {
			int health = healths[i]-100;
			int max = 0;
			int max_num = 0;
			boolean isTrue = false;

			for (int j=0; j<items.length; j++) {
				if (health>=items[0][1] &&items[0][0]!=0) 
					isTrue = true;
				if (items[j][0]>max && health>items[j][1]) {
					max_num = j;
					max = items[j][0];
					
					isTrue = false;
				}
			}
			if ((isTrue&&max_num==0) || (!isTrue&&max_num!=0)) {
				System.out.println(">>"+(max_num+1));
				items[max_num][0] = 0;
				items[max_num][1] = 0;
				list.add(max_num+1);
			}
		}
		int[] answer = list.stream().mapToInt(i -> i).toArray();
		Arrays.sort(answer);
	}
}
