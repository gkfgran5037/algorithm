package pr_al;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;

/**프로그래머스 - 위장
 * 
 * 문제 : 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 		예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
 * 		다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * 		스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 함수를 작성해주세요.
 * 
 * 제한사항 : clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 			스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 			같은 이름을 가진 의상은 존재하지 않습니다.
 * 			clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 			모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 			스파이는 하루에 최소 한 개의 의상은 입습니다.
*/
public class Clothes {
	
	// 방법 1 : hashmap - getOrDefault 사용
	public int solution(String[][] clothes) {
        // 계산을 위해 1로 세팅
		int answer = 1;
        
        // Map<의상의 종류, 개수>
        Map<String, Integer> clothesMap = new HashMap<String, Integer>();
        
        // 의상의 종류 일치할 경우++ => 의상 종류별 개수 세팅
        // map.put(의상의 종류, 의상의 종류 nvl(개수, 0)+1)
        for (int i = 0; i < clothes.length; i++) {
			clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
		}
        
        // 경우의 수 *= (종류별 개수)입는 경우 + 안 입는 경우  
        for (int cnt: clothesMap.values()) {
			answer *= (cnt+1);
		}
        
        // 모두 다 안 입는 경우 제외
        return answer-1;
    }
	
	// 방법 2 : hashmap - containsKey, replace 사용
	public int solution2(String[][] clothes) {
		// 계산을 위해 1로 세팅
		int answer = 1;
		
		// Map<의상의 종류, 개수>
		HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
		
		// 의상의 종류 일치할 경우 += 1
        // 없을 경우 + 1
		for (int i = 0; i < clothes.length; i++) {
			if (clothesMap.containsKey(clothes[i][1])) {
				clothesMap.replace(clothes[i][1], clothesMap.get(clothes[i][1])+1);
			} else {
				clothesMap.put(clothes[i][1], 1);
			}
		}
		
		// 경우의 수 *= (종류별 개수)입는 경우 + 안 입는 경우  
        for (int cnt: clothesMap.values()) {
			answer *= (cnt+1);
		}
		
		// 모두 다 안 입는 경우 제외
        return answer-1;
	}
	
	
	// 방법 3 : arrays.steam 사용
	public int solution3(String[][] clothes) {
		return Arrays.stream(clothes)
				.collect(groupingBy(p->p[1], mapping(p->p[0], counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x,y)->x*(y+1))).intValue() -1 ;
	}
	
	
}
