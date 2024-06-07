package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {

	/* 숫자 야구 게임을 구현하세요.
	 * 
	 * 규칙
	 * - 중복되지 않은 1 ~ 9 사이의 랜덤한 수를 생성.
	 * - 스트라이크 : 해당 숫자가 있고, 위치도 같은 경우
	 * - 볼 : 숫자가 있지만 위치가 다른 경우
	 * - 아웃 : 일치하는 숫자가 하나도 없는 경우
	 * 
	 * 예시 ( 3 9 7 )
	 * 
	 * 입력 : 1 2 3
	 * 1B
	 * 입력 : 5 6 7
	 * 1S
	 * 입력 : 4 5 6
	 * 0
	 * 입력 : 3 7 9
	 * 1S 2B
	 * 입력 : 3 9 7
	 * 3S
	 * 
	 * 정답입니다.
	 * */

	public static void main(String[] args) {

		// 랜덤한 수를 생성. (중복이 되지 않게, 1 ~ 9 사이 3개의 수 )

		int [] list = new int [3];
		int count = 0;
		int min = 1, max = 9;
		int random, i;
		while(count < 3) {
			random = (int)(Math.random() * (max - min + 1) + min);
			for( i = 0; i < count; i++) {
				if(list[i] == random) {
					break; 
				}
			}
			if(i == count) {
				list[count] = random;
				count++;
			}
		}
		System.out.println(Arrays.toString(list));
		int [] user = new int [3];
		int s = 0, b = 0;
		Scanner scan = new Scanner(System.in);

		do {
			s = 0;
			b = 0;
			System.out.print("입력 : ");
		for(int k = 0; k < user.length; k++) {
			user [k] = scan.nextInt();
		}
		for(i = 0; i < list.length; i++){
			for(int j = 0; j < user.length; j++)
				if(list[i] == user[j]) {
					if(i == j) {
						s++;
					}else {
						b++;
					}
				}
		}
		
		// 여기 모르고 지운 부분이 있다.
		
		}while(s != 3);
	}

	// 내가 작성해본 주석 ... ( 너무 간단하게 밖에 못 했다. )

	// ArrayEx02 를 참고하여, 1 ~ 9 사이의 랜덤한 수 생성하는 코드 작성.

	// 반복해서 입력하는 코드 작성. ( 그 전에는 생성만 했어서, 입력하는 코드는 없다. )

	// 각각의 상황 ( 스트라이크, 볼, 아웃 ) 을 if 문으로 작성.

	// -----

	// < 해야할 작업을 순서대로 나열하는 연습이 필수 >
	// 잘 못할수록 더욱 이렇게 해야한다.
	// 반복문을 잘 사용할 수 있다면 좋지만,
	// 잘 안되면 반복문을 풀어서 쓰는 연습을 할 것.

}
