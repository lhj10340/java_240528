package day15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요.
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우 */
		
		// 중복되지 않은 1 ~ 9 사이의 3개의 숫자를 생성.
		
		int min = 1;
		int max = 9;
		
		HashSet<Integer> game = new HashSet<Integer>();
		
		while(game.size() < 3) {
			int random = (int)(Math.random()*(max - min + 1) + min);
			game.add(random);
		}
		
		ArrayList<Integer> game1 = new ArrayList<Integer>();
		
		game1.addAll(game);
		
		Collections.shuffle(game1);
		
		System.out.println(game1);
		
		// 반복문
		Scanner scan = new Scanner(System.in);
			// 사용자가 숫자 3개를 중복되지 않게 1 ~ 9 사이의 값을 입력한다.
			HashSet<Integer> user = new HashSet<Integer>();
			
			System.out.print("번호 입력 : ");
			
			if(user.size() < 3) {
				user.add(scan.nextInt());
			}
			
			// 입력한 값과 랜덤 값을 이용하여 결과를 출력한다.
			
			ArrayList<Integer> user1 = new ArrayList<Integer>();
			
	}

}
