package day03;

import java.util.Scanner;

public class SwitchExam01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		switch(num%2) {
		case 0:
			System.out.println(num + "는 짝수입니다.");
		break;
		default:
			System.out.println(num + "는 홀수입니다.");
	}

}
}
