package Day04_study;

import java.util.Scanner;

public class ForEx10 {

	public static void main(String[] args) {
		
		// 문자를 입력받고, 입력받은 문자가 y 라면 종료하는 반복문.
		
		/* 반복횟수 : y 가 입력될 때까지.
		 * 규칙성 : 없음.
		 * 반복문 종료 후 : 없음.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		
		for ( ; ; ) {
			System.out.println("문자 입력 : ");
			char chr = scan.next().charAt(0);
			
			if(chr == 'y') {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}

}
