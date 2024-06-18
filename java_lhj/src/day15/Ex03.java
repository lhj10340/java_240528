package day15;

import java.util.HashSet;

public class Ex03 {

	public static void main(String[] args) {

		/* 1 ~ 10 사이의 랜덤한 수를 중복되지 않게 6개를 생성해서 저장하고 출력하는 코드를 작성하세요. */

		// 1 ~ 10 사이의 랜덤한 수 생성.

		int min = 1;
		int max = 10;


		int random = (int)(Math.random()*(max - min + 1) - min);
		HashSet<Integer> set = new HashSet<Integer>();

		// 6번 반복하여 랜덤한 수 6개 생성.
		
		for( int i = 0; i < 6 ; i++ ) {
			
			if(set.size() != 6) {
				set.add(random);
			}
			
		}
		System.out.println(set);
	}

}
