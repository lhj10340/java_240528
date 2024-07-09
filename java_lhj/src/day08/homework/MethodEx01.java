package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx01 {

	/* 정수 n 을 입력받아, 입력받은 n 크기를 가지는 배열을 생성하는 코드를 작성하세요.
	 * 메서드를 이용.
	 * */

	public static void main(String[] args) {

		/* ( 내가 한 것 )

		//정수 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력 : ");

		// 입력받은 정수를 이용하여 정수 배열을 생성
		int n = scan.nextInt();

		 */
		
		// 정수 입력 (배열의 크기)
		System.out.print("배열 크기 입력 : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		
		// 입력받은 정수를 이용하여 정수 배열을 생성
		int [] arr = createArray(size);
		System.out.println(Arrays.toString(arr));

		// 입력받은 정수를 이용하여 정수 배열을 생성 ( 잘못된 예시와 연동 )
		int [] arr2 = null;
		createArray2(arr2, size);
		System.out.println(Arrays.toString(arr2));
		
	}
	
	/** 기능 : 정수 n 을 입력하면(배열의 크기가 주어지면), n 의 크기를 가진 정수 배열이 생성된다.
	 *  매개변수 : 배열의 크기 => 정수 => int size
	 *  리턴타입 : 정수 배열을 생성 => 정수 => int [] // 이름까지 쓸 필요는 없다.
	 *  메서드명 : createArray
	 * */

	/*
		public static int createArray(int n) {

		Scanner scan = new Scanner(System.in);
		// 배열의 크기를 입력
		n = scan.nextInt();
		// 입력된 크기로 배열을 생성.
		int [] arr = new int [n];

		return arr[n];

	 */

	public static int [] createArray(int size) {

		if(size < 0) {
			return null;
		}
		// 음수 갯수를 가지는 배열은 없다.

		int [] arr = new int [size]; // 이름 : 실제 값
		return arr;

		// return new int [size];
	}

	// < 잘못된 경우 예시 >
	
	/** 기능 : 배열과 배열의 크기가 주어지면 주어진 배열의 배열 크기의 정수 배열을 생성하는 메서드
	 * 매개변수 : 배열, 배열의 크기 => int [] arr, int size
	 * 리턴타입 : 없다 => void
	 * 메서드명 : createArray2
	 * */
	
	public static void createArray2(int [] arr, int size) {
		arr = new int [size];
	}
	
	/* 잘못된 예시 중 ( arr = new int [size] )
	 * : 매개변수는 복사되기 때문에, ' = ' 을 통해 기본형 변수나 참조형 변수를 재할당하면
	 * : main 에 있는 원본이 바뀌지 않는다. 
	 * */
	
}
