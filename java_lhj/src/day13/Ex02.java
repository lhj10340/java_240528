package day13;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 알려주는 메소드를 정의 및 구현하고
		 * main 메소드에서 실행하는 코드를 작성하세요.
		 * 단, 예외 발생 시 예외처리하는 코드를 추가하세요.
		 * */
		
		
	}
	
	/** 기능 : 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 알려준다.
	 * 매개변수 : 두 정수 => int num1, int num2 / 산술 연산자 => 문자 => char chr1
	 * 메서드명 : result
	 * @return 
	 * */
	
	
	public static double result (int num1, char chr, int num2 ) { // main 에 static 이 있으니 static 을 써주어야 한다.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입력 : ");
		
		num1 = scan.nextInt();
		chr = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		switch(chr) {
		case'+':
			System.out.println(num1 + chr + num2 + " = " + (num1+num2));
			break;
		case'-':
			System.out.println(num1 + chr + num2 + " = " + (num1-num2));
			break;
		case'*':
			System.out.println(num1 + chr + num2 + " = " + (num1*num2));
			break;
		case'/':
			System.out.println(num1 + chr + num2 + " = " + (num1/num2));
			break;
		case'%':
			System.out.println(num1 + chr + num2 + " = " + (num1%num2));
			break;
		default:
		}
		
		return 0;
		
	}
	
	
}
