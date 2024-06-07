package day08;

import java.util.Arrays;

public class MethodEx05 {

	public static void main(String[] args) {
		/* 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단, 메서드를 이용. */
		
		int [] arr = new int [] { 1,3,5,7,9 };
		int num = 8;
		if(contains(arr,num)) {
			System.out.println(num + " 는 " + Arrays.toString(arr) + " 배열에 있습니다.");
		}
		System.out.println(num + " 는 " + Arrays.toString(arr) + " 배열에 없습니다.");
		
	}
	
	/** 기능 : 정수 배열이 주어지면 배열에 정수 num 가 있는지 없는지 알려주는 메서드.
	 * 매개변수 : 정수 num => 정수 => int num // 정수 배열 int [] arr
	 * 리턴타입 : 정수가 있는지 없는지 확인 => boolean
	 * 메서드명 : contains
	 * */
	
	// 참조변수를 사용할 때, null 값 체크를 꼭 해야한다.
	// 이 예제에서 순수하게 int 만 붙은 것이 아니라, int 배열이라서 참조형이다.
	
	public static boolean contains (int [] arr, int num) {
		// 배열이 null 이면 false 를 리턴.
		if(arr == null) {
			return false;
		}
		// 반복문을 이용하여 배열 전체를 탐색.
			for ( int tmp : arr) {
			// 배열에서 꺼낸 값과 num 가 같으면 true를 리턴.
				if(tmp==num) {
					return true;
				}
			}
		// 반복문이 끝날 때까지 못 찾았으면, false 를 리턴.
		return false;
	}
}
