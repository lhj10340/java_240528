package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) throws ParseException {
		Date date = new Date(); // date 가 null 인 경우
		
		System.out.println(date);
		// 날짜 => 문자열.
		// 필요할 때, 붙여넣을 수 있는 코드 모음에 넣어두는 것이 좋다.
		// 자주 쓰이는 코드.
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		System.out.println(dateStr);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr1 = format1.format(date);
		System.out.println(dateStr1);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String dateStr2 = format2.format(date);
		System.out.println(dateStr2);
		
		// 문자열 => 날짜
		// 포맷이 안 맞는 경우, 예외가 발생할 수 있다.
		
		String dateStr4 = "2024-06-14 09:22";
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date4 = format4.parse(dateStr4);
		System.out.println(date4);
	}

}
