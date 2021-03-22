package swea_ssb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * sw expert academy
 * self sturdy book 1 - array 1차시 - gravity
 * 
 * 90도 회전하여 상자들이 중력의 영향을 받아 낙하했을 시 낙차가 가장 큰 상자 구하여 그 낙차를 출력.
 * 
 * 1. case 수 (1<=T<=100)
 * 2. 가로의 길이 N(2<=N<=100), 세로의 길이 N(2<=M<=100)
 * 3. N개의 상자들이 쌓여 있는 높이 H(0<=H<=M) 
 */
public class gravity {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		int maxDif[] = new int[testCase];
		
		// 각 케이스별 최대 낙차수 구하기
		for (int i = 0; i < testCase; i++) {
			int[] roomXy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] boxTop = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			maxDif[i] = getMaxDif(roomXy[0] , roomXy[1], boxTop);
		}
		
		// 답 출력
		for (int i = 0; i < maxDif.length; i++) {
			System.out.println(maxDif[i]);
		}
	}
	
	static int getMaxDif(int roomWith, int roomHeight, int[] boxTop)
	{
		
		int room[][] = new int[roomWith][roomHeight];
		int countEmptySpace = 0;
		int maxDif = 0;
		
		for (int x = 0; x < roomWith; x++) { // 가로
			for (int y = 0; y < boxTop[x]; y++) { // 높이
				room[x][y] = 1; // 높이 만큼 상자 세팅
			}
		}
		
		for (int x = 0; x < roomWith; x++) { // 가로
			// 빈 열 제외
			if (boxTop[x] == 0)
				continue;
			
			countEmptySpace = 0;
			for (int x2 = x+1; x2 < roomWith; x2++) { // 이후 칸
				// 다음칸 중 해당 높이에 해당하는 칸 없을 시 낙차수 더함
				if (room[x2][boxTop[x]-1] == 0)
					countEmptySpace += 1;
			}
			// 멕스값일 경우 
			if(countEmptySpace > maxDif)
				maxDif = countEmptySpace;
		}
		
		return maxDif;
	}
}
