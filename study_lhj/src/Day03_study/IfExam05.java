package Day03_study;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		// 정수를 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성.
		// 2가지 방법으로 해주셨다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		
		int num = scan.nextInt();
		
		if ( num % 6 == 0 ) {
			System.out.println("6의 배수입니다.");
		}
		else if ( num % 6 == 2 || num % 6 == 4 ) {
			System.out.println("2의 배수입니다.");
		}
		else if ( num % 6 == 3) {
			System.out.println("3의 배수입니다.");
		}
		else {
			System.out.println("2,3,6 의 배수가 아닙니다.");
		}
		
	}

}
