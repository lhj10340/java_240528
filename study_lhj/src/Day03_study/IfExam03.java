package Day03_study;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {
		
		// 두 정수와 산술 연산자를 입력하고 (예 : 1 + 2), 그 결과 값을 출력.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수1 을 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("연산자를 입력하세요 : ");
		char chr = scan.next().charAt(0);
		System.out.println("정수2 을 입력하세요 : ");
		int num2 = scan.nextInt();
		
		double res;
		
		if (chr == '+') {
			res = num1 + num2;
			System.out.print("" + num1 + chr + num2 + "=" + res);
		}
		else if (chr == '-') {
			res = num1 - num2;
			System.out.print("" + num1 + chr + num2 + "=" + res);
		}
		else if (chr == '*') {
			res = num1 * num2;
			System.out.print("" + num1 + chr + num2 + "=" + res);
		}
		else if (chr == '/') {
			res = num1 / (double)num2;
			System.out.print("" + num1 + chr + num2 + "=" + res);
		}
		else if (chr == '%') {
			res = num1 % num2;
			System.out.print("" + num1 + chr + num2 + "=" + res);
		}
		else {
			System.out.print("잘못된 연산자를 입력하였습니다.");
		}
	}

}
