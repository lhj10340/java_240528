package day19;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 주민번호를 입력받아 입력받은 주민번호의 생일을 출력하는 코드를 작성하세요.
		 * 
		 * 000101-3012141
		 * => 2000-01-01
		 * 000101-2012141
		 * => 1900-01-01
		 * 
		 * */
		
		// 스캐너 입력.
		Scanner scan = new Scanner(System.in);
		// 주민번호 입력 안내 후, 입력.
		System.out.println("주민등록번호를 입력하세요. ( xxxxxx-xxxxxxx ): ");
		int num = scan.nextInt();
		// 주민번호 뒷자리의 첫번째 숫자가 1,2 인 경우와 3,4 인 경우를 조건문을 통해 나눠서 작성.
		
		// ' 날짜 -> 문자열 ' 표현을 이용하여, 주민번호 앞자리를 생일로 표현.
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		// 출력
	}

}
