package arr;

import java.util.Arrays;
import java.util.HashMap;

public class Participant {
	
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i = 0;
		while (i == participant.length-1) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
				
			} 
		}
		return participant[participant.length-1];
	}
	
	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String player : participant) 
			hm.put(player, hm.getOrDefault(player, 0)+1);
		for (String player : completion)
			hm.put(player, hm.get(player)-1);
		
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
				break;
			}
		}
		
		return answer;
	}
}
