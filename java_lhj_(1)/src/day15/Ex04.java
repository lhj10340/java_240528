package day15;

import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		/* 1 ~ 45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고,
		 * 사용자가 번호를 6개 입력해서 몇 등인지 맞추는 로또 예제 */
		
		/* 1등 : 번호 6개가 일치.
		 * 2등 : 5개 + 보너스 번호 일치.
		 * 3등 : 번호 5개가 일치
		 * 4등 : 번호 4개가 일치
		 * 5등 : 번호 3개가 일치
		 * 이외 : 꽝
		 * */
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		int min = 1, max = 45;
		
		while(lotto.size() < 6) {
			int r = (int)(Math.random()*((max - min + 1) - min)); // (int) 를 바깥에 붙여주어야 한다. 안에 넣으면 계속 0만 나온다.
			/* 위 1줄과 동일한 코드.
			 * Random random = new Random ();
			 * int r = random.nextInt(min, max+1);
			 * */
			lotto.add(r);
		}
		
		// 보너스 번호 생성 코드
		
		int bonus;
		
		do {
			bonus = (int)(Math.random()*((max - min + 1) - min));
		} while(lotto.contains(bonus));
		
		System.out.println(lotto + " : " + bonus);
		
		// 6개 번호 입력
		
		Scanner scan = new Scanner(System.in);
		HashSet<Integer> user = new HashSet<Integer>();
		
		System.out.print("번호 입력 : ");
		while(user.size() < 6) {
			user.add(scan.nextInt());
		}
		
		// 입력한 번호를 이용하여 당첨 등수를 출력
		
		// 당첨 개수를 센다.
		
		int count = 0;
		
		for(Integer num : user) { // user 에 있는 것을 1개씩 꺼내와 num 으로 가져온다는 뜻.
			if(lotto.contains(num)) { // 그 num 이 lotto 에 포함되는 것과 관련된 조건문.
				count++;
			}
		}
		
		switch(count) {
		case 6:
		
			System.out.println("1등!");
		
			break;
		case 5:
		
			if(user.contains(bonus)) {
				System.out.println("2등!");
			}
			else {
				System.out.println("3등!");
			}
			break;
		case 4:
		
			System.out.println("4등!");
		
			break;
		case 3:
		
			System.out.println("5등!");
		
			break;
		default:
		
			System.out.println("꽝!");
		
			break;
		}
		
	}

}
