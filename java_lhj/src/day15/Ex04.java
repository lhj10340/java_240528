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
		
		/* 로또 번호와 보너스 번호를 생성 */
		
		Scanner scan = new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set1 = new HashSet<Integer>();
		
		int min = 1;
		int max = 45;
		
		while (set.size() < 6) {
			int random = (int)(Math.random()*(max + min - 1) + min);
			set.add(random);
		}
		
		System.out.println(set);
		
		while (set1.size() < 1) {
			int r = (int)(Math.random()*(max + min - 1) + min);
			if(!set.contains(set1)) {
				set1.add(r);
			}
		}
		
		System.out.println("보너스 번호 : " + set1);
		
		/* 사용자가 6개의 번호를 입력 */
		
		System.out.println("번호 입력 : ");
		
		int num = scan.nextInt();
		
		/* 입력한 번호를 이용하여 당첨 등수를 출력 */
		
		if(set.contains(num)) {
			System.out.println("1등 입니다.");
		}
			
	}

}
