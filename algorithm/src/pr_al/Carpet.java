package pr_al;

/**
 * 문제 설명 ) 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 *          Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 *          Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
 *          카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항 ) 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 *          노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 *          카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
*/
public class Carpet {
	// 방법 1 : 
	/* yellow는 brown보다 한치수 작은 사각형의 형태이다. (사각형 안에 사각형이 존재하려면 brown의 가로, 세로는 3이상이어야 한다.)
	 * brown = width * height
	 * yellow = (width-2) * (height-2)
	 */
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int block = brown + yellow;
        // brown의 사각형 만들 수 있는 조합 (가로가 더길어야함으로 height을 3부터 시작)
        for (int height = 3; height < block/2; height++) {
			int width = block / height;
			
			// yellow의 사각형 일치 여부
			if ((width-2)*(height-2) == yellow) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
		}
        return answer;
    }
}
