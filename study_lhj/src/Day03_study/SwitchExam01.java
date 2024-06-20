package Day03_study;

import java.util.Scanner;

public class SwitchExam01 {

	public static void main(String[] args) {
		// 정수를 입력받고, 홀짝을 판단. ( switch 문으로 작성. )
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		switch(num % 2) {
		case 0:
			System.out.println("짝수입니다.");
			break;
		default:
			System.out.println("홀수입니다.");
			break;
		}
		
	}

}
