package level1;

public class Word_mid_2 {
	public String solution(String s) {
		String answer = "";
		int mid =s.length()/2;
		answer = s.length()%2==0? s.substring(mid-1, mid+1) : s.substring(mid, mid+1);

		return answer;
	}
	
	public static void main(String[] args) {
		Word_mid_2 word_mid = new Word_mid_2();
		word_mid.solution("abcde");
	}
}
