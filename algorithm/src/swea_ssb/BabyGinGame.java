package swea_ssb;

/**
 * sw expert academy
 * self sturdy book 1 - array 2차시 - BabyGinGame
 * 
 * 0~9 사이의 숫자 카드에서 임의의 카드 6장을 뽑았을 떄, 3장의 카드가 연속적인 번호르 갖는 경우를 run이라 하고, 3장의 카드가 동일한 번호를 갖는 경우를 triple이라 한다.
 * 6장의 카드가 run과 tiple로만 구성된 경우르 baby-gin이라고 하는데, 6자리의 숫자를 입력 받아 bavy-gin 여부를 판단하는 프로그램을 작성해보자 
 */
public class BabyGinGame {
	public static void main(String[] args) {
	}
	
	boolean bgg(int input)
	{
		int c[] = new int[10]; // 0~10
		int tri = 0;
		int run = 0;
		
		for(int i=0; i<6; i++)
		{
			c[input%10]++; // 1의 자리수 카운팅
			input /= 10;
		}
		for (int i = 0; i < 10; i++) {
			if (c[i] >= 3) { // 같은 수가 3개
				c[i] -= 3;
				tri += 1; // 트리플
				i--;
			}
			if((c[i] >= 1) && (c[i+1] >= 1) && (c[i+2] >= 1)) // 연속한 3개의 수 
			{
				c[i] -= 1;
				c[i+1] -= 1;
				c[i+2] -= 1;
				run += 1; // 런
				i--;
			}
		}
		if (run + tri == 2) // 베이비건
			return true;
		return false;
	}
}


