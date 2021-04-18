package pr_al;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**프로그래머스 - 위장
 * 
 * 문제 : 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 		노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 		1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 		2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 		3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 		노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 		베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 함수를 완성하세요.
 * 
 * 제한사항 : genres[i]는 고유번호가 i인 노래의 장르입니다.
 *		   plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 *		   genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 *		     장르 종류는 100개 미만입니다.
 *		     장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 *		     모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestAlbum {

	// 방법 1 :
	public int[] solution(String[] genres, int[] plays) {
        List<Integer> bestAlbumList = new ArrayList<Integer>();
        
        // Map<장르, 재생수> sumPlays
        Map<String, Integer> sumPlaysMap = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
        	sumPlaysMap.put(genres[i], sumPlaysMap.getOrDefault(genres[i], 0) + plays[i]);
		}
        
        // List<재생수> genresList -> Coolections.sort() 재생수 많은 순으로 내림차순
        List<String> genresList = new ArrayList<String>(sumPlaysMap.keySet());
        Collections.sort(genresList, (genreNm1, genreNm2) -> (sumPlaysMap.get(genreNm2).compareTo(sumPlaysMap.get(genreNm1))));
        
        
        // 장르수 만큼 반복
        for (String genre : genresList) {
        	Map<Integer, Integer> playsOfGenreMap = new HashMap<Integer, Integer>();
        	
        	// Map<해당 장르인 곡의 인덱스, 재생수> playsOfGenreMap
        	for (int i = 0; i < genres.length; i++){
				if (genre.equals(genres[i])) {
					playsOfGenreMap.put(i, plays[i]);
				}
			}
        	
        	// List<재생수> playsOfGenreList -> sort() 재생수 많은 순으로 내림차순 
        	List<Integer> playsOfGenreList = new ArrayList<>(playsOfGenreMap.keySet());
        	playsOfGenreList.sort((songIdx1, songIdx2) -> playsOfGenreMap.get(songIdx2).compareTo(playsOfGenreMap.get(songIdx1)));
        	
        	// 해당 장르에서 재생수 많은 곡 2개 이하 선택
        	int cnt = 0;
        	for (Integer songIdx : playsOfGenreList) {
        		if(cnt > 1)
        			break;
        		bestAlbumList.add(songIdx);
        		cnt++;
			}
		}
        
        // 베스트 앨범 인덱스 배열 리턴
        return bestAlbumList.stream().mapToInt(songIdx->songIdx).toArray();
    }
	

}
