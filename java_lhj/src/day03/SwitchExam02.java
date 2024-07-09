package day03;

import java.util.Scanner;

public class SwitchExam02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호를 입력하세요 : ");
		int num = scan.nextInt();
		
		switch(num) {
		case 1,2,3:
			System.out.println("1조 입니다.");
		break;
		case 4,5,6:
			System.out.println("2조 입니다.");
		break;
		case 7,8,9:
			System.out.println("3조 입니다.");
		break;
		default:
			System.out.println("없는 번호입니다.");
		}
		
	}

}
