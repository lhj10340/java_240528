package Day03_study;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		// 정수를 입력했을 때, 3의 배수인지 아닌지 판별하고 그 내용을 출력하는 코딩.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		
		int num = scan.nextInt();
		
		if( num % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}
		
		else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
	}

}
