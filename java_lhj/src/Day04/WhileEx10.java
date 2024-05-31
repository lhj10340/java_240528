package Day04;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		/* 반복문을 이용하여 문자를 입력받고, 입력받은 문자가 y이면 반복문을 종료하는 코드를 작성하세요.
		 * 반복횟수 : ch는 y가 아닌 문자로 시작해서 y가 아니면 반복 // ???
		 * 규칙성 : 안내문구 출력 후, ch에 Scanner를 이용하여 문자를 저장
		 * 반복문 종료 후 : 없음.
		 * */
		
		char ch = 'n';
		Scanner scan = new Scanner(System.in);
		
		
		while(ch != 'y') { 
			System.out.println("문자를 입력하세요 : ");
			ch = scan.next().charAt(0); // 반복횟수가 정해져있지 않기 때문에, 입력한다.
		}
		
	}

}
