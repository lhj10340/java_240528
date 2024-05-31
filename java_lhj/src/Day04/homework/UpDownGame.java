package Day04.homework;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* 1 ~ 100 사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을 작성하세요.
		 * 예 (랜덤한 수가 30)
		 * 정수 입력 : 50
		 * DOWN!
		 * 정수입력 : 20
		 * UP!
		 * 정수 입력 : 25
		 * UP!
		 * 정수 입력 : 30
		 * 정답입니다!
		 * */
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		System.out.println("랜덤한 수 : " + random);

		Scanner scan = new Scanner(System.in);
		int i;
		
		// 이전에 했던 것 참고하여 일단 완료하긴 했다.
		
		for( ; ; ) {
			System.out.println("정수 입력 : ");
			i = scan.nextInt();
			if (i==random) { 
				System.out.println("정답입니다."); break; }
			else if (i > random) {
				System.out.println("DOWN!");
			}
			else if (i < random) {
				System.out.println("UP!");
			}
		}
		
		}
		
	}

