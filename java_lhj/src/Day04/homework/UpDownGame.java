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
		// do while 문이 적절하다. ( 최소 1번은 실행이 되어야 하니까. )
		
		// int num; ( 잘 모르겠으면 변수선언은 밖에다가 하면 맞다. )
		
		/* do {
		 *  ( 정수 입력 : 이라는 안내 문구 출력 )
		 *  ( 정수를 입력 )
		 *  num = scan.nextInt();
		 *  ( 정답 여부를 판별, DOWN 인지 UP 인지 정답인지 )
		 *  : 잘 안되더라도 주석 쓰는 연습을 계속적으로 해야한다.
		 *  ( num 가 random 보다 크면 down
		 *    num 가 random 보다 작으면 up
		 *    아니면 정답입니다 라고 출력.
		 *  : 바로 코딩이 되면 좋지만, 안되면 주석으로 풀어쓰는 연습은 꼭 해야한다.
		 * } while(random != num)
		 * */
		
		for( ; ; ) {
			System.out.print("정수 입력 : ");
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

