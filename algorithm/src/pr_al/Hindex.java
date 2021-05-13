package pr_al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 프로그래머스  H-index
 * 
 * 문제 설명 : H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 
 * 		       어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 		       어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항 : 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 		       논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
*/
public class Hindex {
	
	/*
	 * 방법 1-> 오답  
	 * 가정 ) h = n편 - 번째 <= 인용횟수  (오름차순) 
	 * 
	 *      _________n편_______
	 *      |n-h편||     h편       |
	 * 	    [0,  1,  3,  5,  6] 
	 *          
	 *      h=인용횟수=3
	 * 
	 * 놓친 조건 ) h > 0 (h는 자기자신을 포함해야 한다. 1편이상이어야 함) 
	 * 반례 ) n=1, 인용횟수 = 0일 때 오류 발생. 위 가정을 적용시키면 안 됨.
	 * 		citations = [0]
	 *     h = 1 - (0번째) <= 0
	 *     h = 1 -> 오답
	 */    
	public int solution(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
        	h = citations.length-i;
        	
			if(h <= citations[i]) 
			{
				break;
			}
		}
        return h;
    }
	
	/* 방법 2 -> 정답
	 * 
	 * 가정 ) 인용 횟수 < 번째 + 1 (내림차순) -> 논문의 갯수가 인용수의 최소값보다 작은 경우
	 * 		h = 번째
	 * 
	 *      _________n편_______
	 *      |    h편      || n-h편 |
	 *      [6,  5,  3,  1,  0] 
	 *      
	 *      h = 번째 = 3
	 * 
	 * 조건 ) h > 0
	 * 설명 ) h번 이상 인용된 논문 h편이상 => 큰수 부터 h편으로 갯수 정해져있음 -> 내림차순으로 정렬이 값구하기 용이
	 *      n=1, 인용횟수 = 0
	 *      citations = [0]
	 *      0 < 0+1
	 *      0<1
	 *      h=0 => 정답
	 */ 
	public int solution2(int[] citations) {
		List<Integer> citationList = new ArrayList<Integer>();
		Collections.sort(citationList);
		Collections.reverse(citationList);
		
		for (int i = 0; i < citations.length; i++) {
			if (citationList.get(i) < i+1) {
				return i;
			}
		}
		
		return citationList.size();
	}
}
