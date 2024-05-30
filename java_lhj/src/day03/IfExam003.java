package day03;

import java.util.Scanner;

public class IfExam003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char chr;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 2) : ");
		
		num1 = scan.nextInt();
		chr = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		double res;
		
		if(chr=='+')  { res = num1 + num2;System.out.println("" + num1 + " " + chr + " " + num2 + " = " + (int)res);
		}
		else if(chr=='-')  { res = num1 - num2; System.out.println("" + num1 + " " + chr + " " + num2 + " = " + (int)res);
		}
		else if(chr=='*')  { res = num1 * num2; System.out.println("" + num1 + " " + chr + " " + num2 + " = " + (int)res);
		}
		else if(chr=='/')  { res = (double)num1 / num2; System.out.println("" + num1 + " " + chr + " " + num2 + " = " + res);
		}
		else if(chr=='%')  { res = num1 % num2; System.out.println("" + num1 + " " + chr + " " + num2 + " = " + (int)res);
		}
		else { System.out.println("잘못된 연산자입니다.");
		
}
}
}
