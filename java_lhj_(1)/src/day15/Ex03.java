package day15;

import java.util.HashSet;

public class Ex03 {

	public static void main(String[] args) {
		
		/* 1 ~ 10 사이의 랜덤한 수를 중복되지 않게 6개를 생성해서 저장하고 출력하는 코드를 작성하세요. */
		/* 강사님 풀이
		 * set 활용. -> 중복되지 않으니 활용.
		 * size() 활용. */
		
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 10;
		
		while(set.size() < 6) {
			int r = (int)(Math.random()*((max - min + 1) + min)); // (int) 를 바깥에 붙여주어야 한다. 안에 넣으면 계속 0만 나온다.
			/* 위 1줄과 동일한 코드.
			 * Random random = new Random ();
			 * int r = random.nextInt(min, max+1);
			 * */
			set.add(r);
			
		}
		System.out.println(set);
	}

}
