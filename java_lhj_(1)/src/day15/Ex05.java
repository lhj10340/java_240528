package day15;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {

		/* 숫자 야구 게임을 구현하세요.
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우 */

		// 중복되지 않은 1 ~ 9 사이의 3개의 숫자를 생성.
		int min = 1, max = 9, count = 3;
		List<Integer> com = createRandom(min,max, count);

		System.out.println(com);

		int strike, ball;

		Scanner scan = new Scanner(System.in);
		List<Integer> user;

		// 반복문
		do {
			strike = ball = 0;
			// 사용자가 숫자 3개를 중복되지 않게 1 ~ 9 사이의 값을 입력
			System.out.print("입력 : ");
			user = inputUser(min, max, count, scan);

			// 입력한 값과 랜덤 값을 이용하여 결과를 출력
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			if(strike == 0 && ball == 0) {
				System.out.println("O");
			}
			System.out.println();
			
		} while(strike != 3);
		System.out.println("프로그램을 종료합니다.");
	}

	private static int getBall(List<Integer> com, List<Integer> user) {
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 판별할 수 없습니다.");
		}
		int ball = 0;
		
		// 일치하는 숫자가 있는지 개수를 세는 것. ( 볼 + 스트라이크 )
		
		for(int tmp1 : com) {
			if(user.contains(tmp1)) {
				ball++;
			}
		}
		
		// 그 전체에서 스트라이크를 빼주면 볼이 나온다.
		
		return ball - getStrike(com, user);
	}

	private static int getStrike(List<Integer> com, List<Integer> user) {
		
		// 예외 처리를 하는 습관을 들여놓는 것이 좋다.
		
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 판별할 수 없습니다.");
		}
		int strike = 0;
		for(int i = 0; i < com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				strike++;
			}
		}
		return strike;
	}

	private static List<Integer> inputUser(int min, int max, int count, Scanner scan) {
		// 1,3 이 와야하는데 3,1 이 온 경우 1,3 으로 변경.
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(max - min + 1 < count) {
			String format = "{0}~{1} 사이에서 중복되지 않은 {2}개의 수를 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min, max, count));
		}

		List<Integer> tmp = new ArrayList<Integer>();
		while(tmp.size() < count) {
			int num = scan.nextInt();
			if(!tmp.contains(num)) {
				tmp.add(num);
			}
		}

		return tmp;
	}

	private static List<Integer> createRandom(int min, int max, int count) {
		// 1,3 이 와야하는데 3,1 이 온 경우 1,3 으로 변경.
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(max - min + 1 < count) {
			String format = "{0}~{1} 사이에서 중복되지 않은 {2}개의 수를 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min, max, count));
		}

		// 중복 제거를 위해 set 을 활용.

		HashSet<Integer> set = new HashSet<Integer>();

		while(set.size() < count) {
			int r = (int)(Math.random() * (max - min + 1) + min );
			set.add(r);
		}

		// 숫자 야구 게임에서는 순서가 중요하기 때문에 Set 에 있는 숫자들을 List 에 저장한 후, 섞어준다.

		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set);

		Collections.shuffle(list);

		return list;
	}

}
