package test;

import java.util.Arrays;

public class Ex_2 {
	public static void main(String[] args) {
		int[] people = {2,2,1000};
		int[] tshirts = {2,2,1,2};
		int[] a = new int[1001];
		int count = 0;
		for (int i : people) {
			a[i]++;
		}
		
		System.out.println(Arrays.toString(a));
		for (int i : tshirts) {
			if (a[i]!=0) { 
				a[i]--;
				count++;
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println(count);
	}
}
