package Day04_study;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		int random = (int)(Math.random()*(max - min + 1 ) + min);
		
		System.out.println("랜덤한 수 : " + random);
		int i;
		
		do {
			
			System.out.println("정수 입력 : ");
			i = scan.nextInt();
			
			if(random > i) {
				System.out.println("UP!");
			}
			else if (random < i) {
				System.out.println("DOWN!");
			}
			else if (random == i) {
				System.out.println("정답입니다!");
			}
			
		} while ( random != i ); // 여기 틀렸다. 이 조건일 때 반복하는 것인데, ' ~까지 ' 로 잘못 생각했다. 
		
	}

}
