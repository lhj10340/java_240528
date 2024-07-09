package day03;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하시오 : ");
		int num1 = scan.nextInt();
		char chr = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		int res1 = num1 + num2, res2 = num1 - num2, res3 = num1 * num2, res4 = num1 / num2, res5 = num1 % num2;
		
		switch(chr) {
		case'+':
			System.out.println("" + num1 + " " + chr + " " + num2 + " = " + res1 );
		break;
		case'-':
			System.out.println("" + num1 + " " + chr + " " + num2 + " = " + res2);
		break;
		case'*':
			System.out.println("" + num1 + " " + chr + " " + num2 + " = " + res3);
		break;
		case'/':
			System.out.println("" + num1 + " " + chr + " " + (double)num2 + " = " + res4);
		break;
		case'%':
			System.out.println("" + num1 + " " + chr + " " + num2 + " = " + res5);
		break;
		default:
			System.out.println(chr + "는 연산자가 아닙니다.");
		}
	}

}
