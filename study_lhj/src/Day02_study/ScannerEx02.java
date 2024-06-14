package Day02_study;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		
		/* 두 정수와 연산자를 입력 받고 입력받은 결과를 콘솔에 출력하세요.
		 * 예시
		 * 정수1을 입력하세요 : 1
		 * 정수2를 입력하세요 : 2
		 * 연산자를 입력하세요 : +
		 * 입력 결과 : 1 + 2 
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수1 을 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.println("정수2 를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		System.out.println("연산자를 입력하세요 : ");
		char chr = scan.next().charAt(0);
		
		System.out.println("" + num1 + chr + num2);
		
	}

}
