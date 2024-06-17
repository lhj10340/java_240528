package Day03_study;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 : ");
		
		int month = scan.nextInt();
		
		if( month == 3 || month == 4 || month == 5 ) {
			System.out.println(" 해당 월은 봄입니다. ");
		}
		else if( month == 6 || month == 7 || month == 8 ) {
			System.out.println(" 해당 월은 여름입니다. ");
		}
		else if( month == 9 || month == 10 || month == 11 ) {
			System.out.println(" 해당 월은 가을입니다. ");
		}
		else if( month == 12 || month == 1 || month == 2 ) {
			System.out.println(" 해당 월은 겨울입니다. ");
		}
		else {
			System.out.println("잘못된 월을 입력하였습니다.");
		}
		
	}
	
	
}
