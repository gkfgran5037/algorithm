package test;

public class Test_1 {
	public static void main(String[] args) {
		//int[][] v = {{1,4},{3,4},{3,10}};
		int[][] v = {{1,1},{2,2},{1,2}};
		//int[][] v = {{2,1},{1,1},{2,2}};
		
		int x = v[0][0]^v[1][0]^v[2][0];
		int y = v[0][1]^v[1][1]^v[2][1];
		
		System.out.println(x+" , "+y);
	}
}
