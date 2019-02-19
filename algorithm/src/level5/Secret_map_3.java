package level5;

class Solution3 {
    public String makeSharp(int bitResult, int n) {
        if(bitResult == 0) {
            if(n > 0) {
                String str = "";
                for(int i = 0; i < n; i++) {
                    str += " ";
                }
                return str;
            }
            else return "";
        }else {
        	//재귀함수 : 처음 리턴 값이 제일 마지막에 들어감   ex) f(1 f(2 f(3)..)) => ..321
            return bitResult % 2 == 0 ? makeSharp(bitResult/2, n-1) + " " : makeSharp(bitResult/2, n-1) + "#"; 
        }
    }
    
    public String[] solution(int n, int [] arr1, int [] arr2) {
        String [] answer = new String[n];
        
        int [] secretMap = new int[n];
        for(int i=0; i<n; i++) {
            secretMap[i] = arr1[i] | arr2[i]; // | 비트 논리합 : 1|1=1 / 1|0=1 / 0|0=0
            answer[i] = makeSharp(secretMap[i], n);
        }
        return answer;
    }
}

public class Secret_map_3 {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();

		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		solution.solution(n, arr1, arr2);
	}
}
