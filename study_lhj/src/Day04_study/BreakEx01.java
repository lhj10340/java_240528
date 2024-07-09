package Day04_study;

import java.util.Scanner;

public class BreakEx01 {

	public static void main(String[] args) {
		// y 를 입력하면 중지하는 코드를 break 를 입력하여 작성.
		// break 는 반복문을 빠져나오는 명령어.
		// if 문에서만 사용할 수 있다.
		
		// break 문을 사용하지 않고 do while 로 풀었었다.
		
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
