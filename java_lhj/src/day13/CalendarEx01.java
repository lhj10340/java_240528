package day13;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR); // 연도를 추출
		int month = cal.get(Calendar.MONTH); // 월을 추출 ( 결과가 0 ~ 11 이 나와서, +1 을 해주어야 한다. )
		int day = cal.get(Calendar.DAY_OF_MONTH); // 일을 추출

		System.out.println(year + "-" + (month+1) + "-" + day);
		
		// ' Calendar.YEAR : 1 ' 과 같이 상수로 지정이 되어있다. static 을 이용해서.
		
	}

}
