package level5;

import java.util.Arrays;

/* 프로그래머스 - 2017 (1치)카카오 블라인드 채용 - 비밀지도
 * 
 * 분제
 *  - 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
 *    전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 *    지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
 *    암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 *    네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
 * 
 * 입력형식
 *  - 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
 *      1) 1 ≦ n ≦ 16
 *      2) arr1, arr2는 길이 n인 정수 배열로 주어진다.
 *      3) 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
 *      
 * 출력형식
 *  - 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
 *    
 * 입출력 예
 *  - 입력  n : 5 / arr1 : [9, 20, 28, 18, 11] / arr2 : [30, 1, 21, 17, 28]
 *    출력 ["#####","# # #", "### #", "# ##", "#####"]
 */
class Solution2 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for (int i=0; i<n; i++) {
			String map1 = Integer.toBinaryString(arr1[i]);
			String map2 = Integer.toBinaryString(arr2[i]);
			answer[i] = "";

			if (map1.length() != n) {
				int plus = n-map1.length();
				for (int j=0; j<plus; j++) {
					map1 = '0'+map1;
				}
			}
			if (map2.length() != n) {
				int plus = n-map2.length();
				for (int j=0; j<plus; j++) {
					map2 = "0"+map2;
				}
			}
			
			for (int j=0; j<n; j++) {
				if (map1.charAt(j)=='0' && map1.charAt(j)==map2.charAt(j)) {
					answer[i] += " ";
				}else {
					answer[i] += "#";
				}
			}
		}
		return answer;
	}
}
public class Secret_map_2 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		
		String[] answer = solution.solution(n, arr1, arr2);
		System.out.println(Arrays.toString(answer));
	}
}
