package level1;

import java.util.Arrays;

public class Marathon_1 {
	public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0; i<completion.length; i++) {
        	if (!participant[i].equals(completion[i])) {
        		return participant[i];
			}
        }
        return participant[i];
    }
	public static void main(String[] args) {
		Marathon_1 marathon = new Marathon_1();
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "nikola", "vinko", "filipa"};
		marathon.solution(participant, completion);
	}
}
