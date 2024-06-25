package Day04_study;

import java.util.Scanner;

public class DowhileEx02 {

	public static void main(String[] args) {
		
		/* 다음과 같이 메뉴를 출력하고 종료 메뉴를 선택하면 프로그램이 종료되는 코드를 작성하세요.
		 
		 * 	1. 프로그램 실행
			2. 프로그램 저장
			3. 프로그램 불러오기
			4. 프로그램 종료
			메뉴 선택 : 
			프로그램을 종료합니다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int menu;
		
		do { 
			System.out.println("-----메뉴-----");
			System.out.println("1. 프로그램 실행");
			System.out.println("2. 프로그램 저장");
			System.out.println("3. 프로그램 불러오기");
			System.out.println("4. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("프로그램을 실행합니다.");
				break;
			case 2:
				System.out.println("프로그램을 저장합니다.");
				break;
			case 3:
				System.out.println("프로그램을 불러옵니다.");
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		} while (menu != 4);
		
	}

}
