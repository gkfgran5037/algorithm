package level2;

/* 프로그래머스 - 해시 - 전화번호 목록
 * 분제
 *  - 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 *    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *    구조대 : 119 / 박준영 : 97 674 223 / 지영석 : 11 9552 4421
 *    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
 *    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *    
 * 제한사항
 *  - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 *    각 전화번호의 길이는 1 이상 20 이하입니다.
 *    
 * 입출력 예제
 *  - 입력 : [119, 97674223, 1195524421] / 출력 : false
 *    입력 : [123,456,789] / 출력 : true
 *    입력 : [12,123,1235,567,88] / 출력 : false
 */
public class CellNum_1 {
	public boolean solution(String[] phone_book) {
        for (int i=0; i<phone_book.length-1; i++) {
        	String idx = phone_book[i]; 
        	for (int j=i+1; j<phone_book.length; j++) {
        		if (idx.length()>phone_book[j].length()&&idx.substring(0, phone_book[j].length()).equals(phone_book[j])) 
        			return false;
        		if (phone_book[j].substring(0, idx.length()).equals(idx)) 
        			return false;
			}
		}
        return true;
    }
	
	public static void main(String[] args) {
		CellNum_1 c = new CellNum_1();
		//String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123", "456", "789"};
		String[] phone_book = {"12232332", "12", "222222"};
		
		System.out.println(c.solution(phone_book));
	}
}
