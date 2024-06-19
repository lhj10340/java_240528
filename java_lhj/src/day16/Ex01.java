package day16;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* Up Down 게임 예제를 구현하세요. */
		/* 랜덤으로 숫자를 만들고 (1~100) 만들어진 숫자를 맞추는 게임. */
		
		int min = 1, max = 100;
		int random = (int)(Math.random()*(max - min + 1 ) + min);
		
		System.out.println("문제 : " + random);
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		do {
		
		System.out.print("정수 입력 : ");
		num = scan.nextInt();
		
		if( num > random ) {
			System.out.println("DOWN!");
		}
		else if ( num < random ) {
			System.out.println("UP");
		}
		else if ( num == random ) {
			System.out.println("정답입니다!");
		}
		else {
			System.out.println("잘못 입력하였습니다.");
		}
		
		} while(num != random);
	}

}
