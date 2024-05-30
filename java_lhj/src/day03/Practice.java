package day03;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 연산자 별로 else if문을 작성했어야 하는데, 보여주신 예시만 나오게 했었다.
		// 연산자 별로 변수 설정 후, else if문 작성.
		// <주의> char 의 경우는 '' 사이에 넣어야한다. 아까 "" 사이에 넣어서 에러가 났었다.
		
		int num1, num2;
		char chr;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 2) : ");
		
		num1 = scan.nextInt();
		chr = scan.next().charAt(0); // 기억이 나지 않았음, 이전에 했던 것에서 복사해왔다.
		num2 = scan.nextInt();
		
		// double result; 를 넣고, 실행문에 result = 각 연산자별 계산 넣어서 해도 된다.
		// 나누기에서 형 변환을 주의할 것.
		// 기본적인 문법의 형태를 미리 적어두고 시작하는 것이 좋다. 괄호 실수를 줄일 수 있을 것이다.
		
		double res;
		
		if(chr=='+') { System.out.println(num1 + " " + chr + " " + num2 + " = " + (res = num1 + num2));
		}
		else if(chr=='-') { System.out.println(num1 + " " + chr + " " + num2 + " = " + (res = num1 - num2));
		}
		else if(chr=='*') { System.out.println(num1 + " " + chr + " " + num2 + " = " + (res = num1 * num2));
		}
		else if(chr=='/') { System.out.println(num1 + " " + chr + " " + num2 + " = " + (res = num1 / (double)num2));
		}
		else if(chr=='%') { System.out.println(num1 + " " + chr + " " + num2 + " = " + (res = num1 % num2));
		}
		else { System.out.println("잘못된 연산자입니다.");
	}

}
}