package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		
		/* Exam 01 ~ 03 기능을 하나로 합쳐서 다음 기능을 구현하세요.
		 * 
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * -----------
		 * 단어 입력 (종료:-1) : abc
		 * 단어를 추가했습니다. / 단어를 추가하지 못했습니다.
		 * 단어 입력 (종료:-1) : -1
		 * 메뉴로 돌아갑니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * -----------
		 * 단어 입력 (종료:-1) : abc
		 * 있는 단어입니다. / 없는 단어입니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 0
		 * -----------
		 * 잘못된 메뉴입니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * -----------
		 * 프로그램을 종료합니다.
		 * 
		 * 단어입력 (종료:-1) : cat
		 * 단어를 추가해습니다.
		 * 단어입력 (종료:-1) : dog
		 * 단어를 추가해습니다.
		 * 단어입력 (종료:-1) : good
		 * 단어를 추가하지 못했습니다.
		 * 단어입력 (종료:-1) : -1
		 * 종료합니다.
		 * 
		 * 입력한 문자열이 배열에 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단어 입력 (종료:-1) : apple
		 * 없는 단어입니다.
		 * 단어 입력 (종료:-1) : cat
		 * 있는 단어입니다.
		 * 단어 입력 (종료:-1) : -1
		 * 종료합니다.
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		int menu;
		int count = 0; // 추가된 단어의 갯수
		String word; // 추가/검색 기능에서 입력한 단어를 저장하는 변수
		boolean result; // 검색할 때, 있다/없다를 확인할 변수
		String [] list = new String [2];
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.println("메뉴 검색 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("----------");
					while(true) {
						System.out.println("단어 입력 (종료:-1) : ");
						word = scan.next();
						if(word.equals("-1")) {
							System.out.println("메뉴로 돌아갑니다.");
							break;
						}
						if(count==list.length) {
							System.out.println("단어를 추가하지 못했습니다.");
						}
						else {
							list[count] = word;
							count++;
							System.out.println("단어를 추가했습니다.");
						}
					}
				System.out.println("----------");
				break;
			case 2:
				System.out.println("----------");
					while(true) {
						System.out.println("단어 입력 (종료:-1) : ");
						word = scan.next();
						if(word.equals("-1")) {
							System.out.println("메뉴로 돌아갑니다.");
							break;
						}
						result = false;
						for(int i = 0; i < count; i++) {
							result = true;
							break;
						}
					}
				System.out.println("----------");
				break;
			case 3:
				System.out.println("----------");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("----------");
				break;
			default:
				System.out.println("----------");
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("----------");
			}
		} while (menu != 3);
		
	}

}
