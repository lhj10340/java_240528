package Day03_study;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		
		// 월을 입력받고, 계절을 출력하는 예제
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("월 입력 : ");
		int month = scan.nextInt();
		
		switch(month) {
		case 3,4,5:
			System.out.println("봄 입니다.");
			break;
		case 6,7,8:
			System.out.println("여름 입니다.");
			break;
		case 9,10,11:
			System.out.println("가을 입니다.");
			break;
		case 12,1,2:
			System.out.println("겨울 입니다.");
			break;
		default:
			System.out.println("잘못된 월을 입력하였습니다.");
			break;
		}
		}

}
