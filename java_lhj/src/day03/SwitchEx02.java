package day03;

import java.util.Scanner;

public class SwitchEx02 {

	// 뭘 넣어야할지 모르겠다.
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("월 : ");
		int month = scan.nextInt();
		
		switch(month) {
		case 3,4,5:
			System.out.println("봄");
			break;
		case 6,7,8:
			System.out.println("여름");
			break;
		case 9,10,11:
			System.out.println("가을");
			break;
		case 12,1,2:
			System.out.println("겨울");
			break;
		default:
			System.out.println("잘못된 월");
		}
		
	
	}
		
	}

