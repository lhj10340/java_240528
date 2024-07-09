package day03;

import java.util.Scanner;

public class SwitchExam03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char chr;
		
		System.out.print("두 정수와 연산자를 입력하세요 : ");
		num1 = scan.nextInt();
		chr = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		double res;
		
		switch(chr) {
		case'+':
			res = num1 + num2;
			System.out.println("" + num1 + chr + num2 + "=" + (int)res);
			break;
		case'-':
			res = num1 - num2;
			System.out.println("" + num1 + chr + num2 + "=" + (int)res);
			break;
		case'*':
			res = num1 * num2;
			System.out.println("" + num1 + chr + num2 + "=" + (int)res);
			break;
		case'/':
			res = (double)num1 / num2;
			System.out.println("" + num1 + chr + num2 + "=" + res);
			break;
		case'%':
			res = num1 % num2;
			System.out.println("" + num1 + chr + num2 + "=" + (int)res);
			break;
		default:
			System.out.println(chr + "는 연산자가 아닙니다.");
		}
		
	}

}
