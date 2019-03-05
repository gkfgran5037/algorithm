package level1;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/* 프로그래머스 - 연습문제 - 2016
 * 
 * 분제
 *  - 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
 *    요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
 *    예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.
 * 
 * 제한조건
 *  - 1) 2016년은 윤년입니다.
 *    2) 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
 *      
 * 입출력 예
 *  - 입력 a:5 b:24 / 출력 : TUE
 */
public class Day_2016_2 {
	public String solution(int a, int b) {
		Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, a-1, b).build();
		
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		Day_2016_2 d = new Day_2016_2();
		System.out.println(d.solution(a, b));
	}
}
