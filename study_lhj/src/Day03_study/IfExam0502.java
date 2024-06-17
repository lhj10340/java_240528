package Day03_study;

import java.util.Scanner;

public class IfExam0502 {

	public static void main(String[] args) {
		// num 가 2의 배수이고 3의 배수가 아니면 2의 배수라고 출력하고
		// 아니면 num 가 3의 배수이고 2의 배수가 아니면 3의 배수라고 출력하고
		// 아니면 num 가 6의 배수이면 6의 배수라고 출력하고
		// 아니면 2,3,6의 배수가 아닙니다 라고 출력한다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		
		int num = scan.nextInt();
		
		if(num % 2 == 0 && num % 3 != 0) {
			System.out.println("2의 배수");
		}
		else if (num % 3 == 0 && num % 2 != 0) {
			System.out.println("3의 배수");
		}
		else if (num % 6 == 0) {
			System.out.println("6의 배수");
		}
		else {
			System.out.println("2,3,6 의 배수가 아닙니다.");
		}
	}

}
