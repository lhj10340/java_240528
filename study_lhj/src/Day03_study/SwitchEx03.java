package Day03_study;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력하여 계산하는 것을 Switch 문으로 작성.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수1 입력 : ");
		int num1 = scan.nextInt();
		System.out.println("연산자 입력 : ");
		char chr = scan.next().charAt(0);
		System.out.println("정수2 입력: ");
		int num2 = scan.nextInt();
		
		// 하나하나 입력을 해도 되고, 한 칸씩 띄면서 한 줄에 모두 입력할 수도 있다.
		
		/* System.out.print("두 정수와 산술 연산자를 입력하시오 : ");
		int num1 = scan.nextInt();
		char chr = scan.next().charAt(0);
		int num2 = scan.nextInt(); */
		
		double res;
		
		switch(chr) {
		case '+':
			res = num1 + num2;
			System.out.println("" + num1 + " " + chr + " " + num2 + " " + "= " + (int)res );
			break;
		case '-':
			res = num1 - num2;
			System.out.println("" + num1 + " " + chr + " " + num2 + " " + "= " + (int)res );
			break;
		case '*':
			res = num1 * num2;
			System.out.println("" + num1 + " " + chr + " " + num2 + " " + "= " + (int)res );
			break;
		case '/':
			res = num1 / (double)num2;
			System.out.println("" + num1 + " " + chr + " " + num2 + " " + "= " + res );
			break;
		case '%':
			res = num1 % num2;
			System.out.println("" + num1 + " " + chr + " " + num2 + " " + "= " + (int)res );
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}
		
	}

}
