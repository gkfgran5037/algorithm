package swea_ssb;

public class Ladder {
	public static void main(String[] args) {
		int arr[][] = {{9,20,2,18,11}, {19,1,25,3,21}, {8,24,10,17,7}, {15,4,16,5,6}, {12,13,22,23,14}};
		getAbs(arr);
	}
	
	
	// 배열의 순회 - 절대값의 합 구하기 
	// 5*5의 2차 배열에 무작위로 25개의 숫자로 초기화를 한 후 25개의 각 요소에 대해서 그 요소와 이웃한 요소와의 차의 절대값을 구한 뒤, 구한 모든 값의 총합을 구한다.
	static int getAbs(int[][] arr)
	{
		int dx[] = {0,0,-1,1}; // 상하좌우
		int dy[] = {-1,1,0,0}; 
		int newX, newY;
		int sum = 0;
		
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				for (int dir = 0; dir < 4; dir++) {
					newX = x+dx[dir];
					newY = y+dy[dir];
					
					if(newX<0 || newX>=arr[y].length || newY<0 || newY>=arr.length)
						continue;
					sum += Math.abs(arr[x][y]-arr[newX][newY]);
				}
			}
		}
		return sum;
	}
	
	// 2차원 배열 정렬
	// 달팽이 형태로 2차원 배열을 정렬하고 난 뒤 출력	
	
}
