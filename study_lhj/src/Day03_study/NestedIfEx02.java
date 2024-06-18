package Day03_study;

import java.util.Scanner;

public class NestedIfEx02 {

	public static void main(String[] args) {
		// 두 정수와 연산자를 입력하고, 그 계산과정과 결과를 출력하는 코딩

		Scanner scan = new Scanner(System.in);

		System.out.println("정수1 입력 : ");
		int num1 = scan.nextInt();
		System.out.println("연산자 입력 : ");
		char chr = scan.next().charAt(0);
		System.out.println("정수2 입력 : ");
		int num2 = scan.nextInt();

		double res;

		if(chr == '+') {
			res = num1 + num2;
			System.out.println("" + num1 + " " + chr + num2 + " " + " = " + (int)res);
		}
		else if(chr == '-') {
			res = num1 - num2;
			System.out.println("" + num1 + " " + chr + num2 + " " + " = " + (int)res);
		}
		else if(chr == '*') {
			res = num1 * num2;
			System.out.println("" + num1 + " " + chr + num2 + " " + " = " + (int)res);
		}

		// num2 가 0이면 나눌 수 없다고 출력.
		// 0 인 경우에만 계산을 하도록 하고, 아니면 나눌 수 없다라고 출력하는 것이 목적이었기 때문에
		// 계산식을 중첩 조건문 안쪽에 넣지 않으면 예외가 발생한다.

		else if(chr == '/') {

			if(num2 == 0) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
			else {
				res = num1 / (double)num2;
				System.out.println("" + num1 + " " + chr + " " + num2 + " " + " = " + res);
			}
		}

		// num2 가 0이면 나눌 수 없다고 출력.
		// 0 인 경우에만 계산을 하도록 하고, 아니면 나눌 수 없다라고 출력하는 것이 목적이었기 때문에
		// 계산식을 중첩 조건문 안쪽에 넣지 않으면 예외가 발생한다.

		else if(chr == '%') {

			if (num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
			}

			else {
				res = num1 % num2;
				System.out.println("" + num1 + " " + chr + num2 + " " + " = " + res);
			}
		}
		else {
			System.out.println("잘못된 연산자를 입력하였습니다.");
		}
	}

}
