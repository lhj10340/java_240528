package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요. 
		 * 메뉴
		 * 1. 번호 추가
		 * 2. 번호 삭제
		 * 3. 번호 조회 ( sysout(list) ) 로 대체.
		 * 4. 종료
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int menu;
		ArrayList<String> list = new ArrayList<String> ();
		
		do {
			
			menu = scan.nextInt();
			
			System.out.println("메뉴");
			System.out.println("1. 번호 추가");
			System.out.println("2. 번호 삭제");
			System.out.println("3. 번호 조회");
			System.out.println("4. 종료");
			System.out.println("메뉴 선택 : ");
			
			switch(menu) {
			
			case 1: {
				System.out.println("번호를 입력하세요 : ");
				
				String num = scan.next();
				
				list.add(num);
				System.out.println("번호가 등록되었습니다.");
			}
				break;
				
			case 2: {
				System.out.println("삭제할 번호를 입력하세요 : ");
				
				String num = scan.next();
				
				if(list.remove(num)) {
					System.out.println("번호를 삭제했습니다.");
				}
				else {
					System.out.println("삭제할 번호가 없습니다.");
				}
			}
				break;
				
			case 3:{
				System.out.println("번호를 조회합니다. ");
				System.out.println(list);
			}
				break;
			case 4:
			{
				System.out.println("프로그램을 종료합니다.");
			}
				break;
			}
			
		} while (menu != 4);
		
	}

}
