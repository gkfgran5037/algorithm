package b_level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백준알고리즘 5622번 - 다이얼
 * 
 * 분제
 *  - 전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 
 *    숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
 *    숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
 *    상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
 *    할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오.
 * 
 * 입력
 *  - 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
 *  
 * 출력
 *  - 첫째 줄에 다이얼을 걸기 위해서 필요한 시간을 출력한다.
 */
public class Dial_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] alpha = new int[26];
		int time = 0;
		for (int i=0; i<alpha.length; i++) {
			if (15<=i && i<=18) {
				alpha[i] = 8;
			}else if (19<=i && i<=21) {
				alpha[i] = 9;
			}else if (22<=i) {
				alpha[i] = 10;
			}else {
				alpha[i] = (i/3)+3;
			}
		}
		
		for (int i=0; i<input.length; i++) {
			time += alpha[input[i]-65];
		}
		System.out.println(time);
	}
}
