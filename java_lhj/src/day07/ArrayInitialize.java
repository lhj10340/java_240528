package day07;

import java.util.Arrays;

public class ArrayInitialize {

	public static void main(String[] args) {
		
		// new int 의 유무에 따른 초기화 가능여부 예제.
		
		int [] arr1 = new int[] {1,2,3,4,5};
		
		System.out.println(Arrays.toString(arr1));
		
		arr1 = new int [] {5,4,3,2,1};
		
		System.out.println(Arrays.toString(arr1));
		
		int [] arr2 = {3,4,5,6,7};
		
		System.out.println(Arrays.toString(arr2));
		
		// arr2 = {7,6,5,4,3}; // 에러가 발생한다, 불가능.
	}

}
