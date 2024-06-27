package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {

		/* 리스트에 숫자들을 저장하고, 저장된 숫자들을 정렬하는 코드를 작성하세요.
		 * */

		// 리스트에 숫자들을 저장.
		
		List <Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(23);
		list.add(12);
		list.add(3);

		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		/* 정렬된 숫자들을 역순으로 정렬하는 코드를 작성하세요. */
		
		// Collections.reverse(list); // 요소들을 역순으로 배치, 앞에서 이미 정렬이 되어있어서 그 순서만 뒤집는 것.
		
		Collections.sort(list, (i1,i2) -> i2 - i1); // 람다식 활용하여 정렬, 기존의 정렬 방식이 i1 - i2 이다.
		
		System.out.println(list);
	}

}
