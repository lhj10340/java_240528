package day02;

import java.util.Scanner; // ctrl + shift + o

public class ScannerEx02 {

	public static void main(String[] args) {
		/* 두 정수와 연산자를 입력받고 입력받은 결과를 콘솔에 출력하세요.
		 * 예시
		 * 정수1을 입력하세요 : 1
		 * 정수2를 입력하세요 : 2
		 * 연산자를 입력하세요 : +
		 * 입력 결과 : 1 + 2
		 * */
		
		// 이전 예제 보면서 했다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수1을 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println(num1);
		
		System.out.print("정수2를 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println(num2);
		
		System.out.print("연산자를 입력하세요 : ");
		char chr = scan.next().charAt(0);
		System.out.println(chr);
		
		System.out.print('\n');
		
		System.out.print("입력 결과 : " + "" + num1 + " " + chr + " " + num2);
	}

}
