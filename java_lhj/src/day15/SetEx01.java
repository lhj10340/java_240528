package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		/* Set 기본 예제 */
		HashSet<Integer> set = new HashSet<Integer>(); // 제네릭은 Wrapper 로 입력.
		
		/* add(객체) : 객체를 set 에 추가, 중복된 경우 false 를 리턴. */
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		System.out.println(set.add(100));
		System.out.println(set.add(1000));
		
		/* remove(객체) : 객체를 set 에서 제거, 없으면 false 를 리턴. */
		System.out.println(set.remove(20));
		System.out.println(set.remove(100));
		
		/* contains(객체) : set 에 객체가 있으면 true 없으면 false를 리턴. */
		
		System.out.println(set.contains(11));
		System.out.println(set.contains(1));
		
		/* size() : 저장된 개수 */
		
		System.out.println(set.size());
		
		System.out.println(set);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		/* addALL(컬렉션) : 컬렉션에 있는 원소들을 추가. 컬렉션 프레임 워크*/
		list.addAll(set);
		list.add(8);
		list.add(9);
		list.add(10);
		
		/* Collections.shuffle(리스트) : 리스트를 섞어준다. */
		
		Collections.shuffle(list);
		System.out.println(list);
		
	}

}
