package day16;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class Ex03 {

	public static void main(String[] args) {
		/* UP DOWN 게임에 기록을 저장하는 기능을 추가
		 * 최대 5등까지 저장하며, 먼저 등록된 순으로 저장.
		 * 아이디를 입력받아 저장.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * */

		Scanner scan = new Scanner(System.in);
		
		ArrayList <Record> list = new ArrayList();
		
		int menu;
		int num;
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * ( max - min + 1) + min );
		int count = 0;
		
		do {

			menu = scan.nextInt();

			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.println("메뉴 선택 : ");

			switch(menu) {

			case 1:

				do {

					System.out.println("게임을 시작합니다!");
					System.out.println("\n");
					System.out.println("입력 : ");
					num = scan.nextInt();
					printResult(random,num);
					count++;
					
					
					/* 여기서 해야할 것. 
					 * 1. 몇번의 입력을 통해 정답을 맞추었는지 그 횟수 확인.
					 * 2. 기록 및 아이디 저장을 하도록 list 생성. (순서를 보장하고, 중복도 허용하니까 list 일것 같다.)
					 * 3. 5개의 기록을 저장할 수 있도록 하며(반복문 말고, 6번째 기록부터는 5번째 기록과 비교하고 없애는 식으로)
					 * 4. 입력 횟수를 기준으로 list 배열. (등수 선정을 위해)
					 * */

				} while (random != num);

				break;

			case 2:
				
				/* 여기서 해야할 것.
				 * 생성된 list 를 확인할 수 있도록 출력만 해주면 될 것 같다. */
				
				break;

			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				break;

			}

		} while(menu != 3);
	}

	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * ( max - min + 1) + min );
	}

	public static void printResult(int random, int num) {
		if(random > num) {
			System.out.println("UP");
		}
		else if(random < num) {
			System.out.println("DOWN");
		}
		else {
			System.out.println("정답!");
		}

	}
}

