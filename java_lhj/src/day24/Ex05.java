package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		/* 문자열을 입력받아 exit 가 아니면 입력한 문자열을 출력하고, exit 이면 종료하는 코드를 작성하려고 했다.
		 * 원인 : (1) while 문의 경우는 false 는 한 번도 실행되지 않는다. ( 현재 조건식이 false 이다. ) (2) 문자열을 == 로 비교. (3) continue ( while 문에서 조건식으로 이동 )
		 * 해결 방법 : false 를 true 로 수정. == 를 equals 로 수정. continue 를 break 로 수정
		 * */
		
		/* 
		 * (2)번 원인을 확인하지 못 했다. 잘 알아두자.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		boolean res = true;
		
		while(res) {
			System.out.print("문자열 입력 : ");
			String str = scan.next();
			if(str.equals("exit")) {
				break;
			}
			System.out.println(str);
		}
		
	}

}
