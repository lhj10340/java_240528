package day08.homework;

import java.util.Arrays;

public class MethodEx02 {

	/* 1 ~ 9 사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요.
	 * 메서드를 이용. ( 강사님은 2개 만들어서 진행하실 예정. )
	 * */
	
	public static void main(String[] args) {

		int size = 5;
		int [] arr = createRandomArray(size, 1, 9);
		System.out.println(Arrays.toString(arr));
		
	}
	
	/*
	 * 기능 : 1 ~ 9 중 랜덤한 수를 배열에 저장.
	 * 매개변수 : 랜덤한 정수 => int / 정수 배열 => int [] arr
	 * 리턴타입 : 콘솔에 출력 => void
	 * 메서드명 : pr
	 */
	
	/**기능 : 최소값과 최대값 사이의 랜덤한 정수를 생성해서 알려주는 메서드
	 * 매개변수 : 최소값과 최대값 => int min, int max => int 
	 * 리턴타입 : 랜덤한 정수 => int
	 * 메서드명 : random
	 * */
	
	public static int random(int min, int max) {
		if (min > max) { // 입력을 잘못했을 경우를 대비하는 보완.
			int tmp = min;
			min = max;
			max = tmp;
		}
		int random = (int)(Math.random() * (max - min + 1) + min );
		return random;
		// return (int)(Math.random() * (max - min + 1) + min );
	}
	
	/**기능 : 배열의 크기와 최소값과 최대값이 주어졌을 때, 랜덤한 배열을 만들어서 알려주는 메서드 
	 * 매개변수 : 배열의 크기, 최소값과 최대값 => int n, int min, int max
	 * 리턴타입 : 중복되지 않은 랜덤한 정수가 들어있는 배열 => int []
	 * 메서드명 : createRandomArray
	 */

	public static int [] createRandomArray(int size, int min, int max) {
		if (size < 0) {
			return null;
		}
		int [] arr = new int [size];
		for(int i = 0; i < size; i++) {
			arr[i] = random(min, max);
		}
		return arr;
	}
	
}
