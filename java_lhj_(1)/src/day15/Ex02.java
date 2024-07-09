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
		
		/* 강사님 풀이 */
		
		int menu;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list= new ArrayList<String>();
		
		do {
			
			// 메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 번호 추가");
			System.out.println("2. 번호 삭제");
			System.out.println("3. 번호 조회");
			System.out.println("4. 종료");
			System.out.println("메뉴 선택 : ");
			// 메뉴 선택
			menu = scan.nextInt();
			// 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				System.out.println("추가할 번호 입력 : ");
				String num1 = scan.next();
				if(list.contains(num1)) {
					System.out.println("이미 등록된 번호입니다."); // 이미 있는 번호인지 아닌지를 확인해야한다. (중복 확인)
				}
				else
				{
					System.out.println("번호를 등록했습니다.");
					list.add(num1);
				}
				break;
			case 2:
				System.out.println("삭제할 번호 입력 : ");
				String num2 = scan.next();
				if(list.remove(num2)) {
					System.out.println("번호를 삭제했습니다.");
				}
				else {
					System.out.println("일치하는 번호가 없습니다.");
				}
				break;
			case 3:{
				System.out.println(list);
			}
				break;
			case 4:
			{
				System.out.println("프로그램을 종료합니다.");
			}
				break;
			}
			
			
		} while(menu != 4);
		
	}

}
