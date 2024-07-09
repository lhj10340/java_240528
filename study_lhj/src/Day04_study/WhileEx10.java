package Day04_study;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		
		// 문자를 입력받고, 입력받은 문자가 y 라면 종료하는 반복문.
		
		Scanner scan = new Scanner(System.in);
		
		char chr;
		
		while(true) {
			System.out.println("문자 입력 : ");
			chr = scan.next().charAt(0);
			if(chr == 'y') {
				break;
			}
		}
		
	}

}
