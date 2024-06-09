package day08.homework;

import java.util.Scanner;

public class MethodEx01 {

	/* 정수 n 을 입력받아, 입력받은 n 크기를 가지는 배열을 생성하는 코드를 작성하세요.
	 * 메서드를 이용.
	 * */

	public static void main(String[] args) {
		
		//정수 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력 : ");

		// 입력받은 정수를 이용하여 정수 배열을 생성
		int n = scan.nextInt();
		
		
		
	}
/** 기능 : 정수 n 을 입력하면(배열의 크기가 주어지면), n 의 크기를 가진 정수 배열이 생성된다.
 *  매개변수 : 배열의 크기 => 정수 => int
 *  리턴타입 : 정수 배열을 생성 => 정수 => int [] arr => int
 *  메서드명 : createArray
 * */

		public static int createArray(int n) {
		
		Scanner scan = new Scanner(System.in);
		// 배열의 크기를 입력
		n = scan.nextInt();
		// 입력된 크기로 배열을 생성.
		int [] arr = new int [n];
		
		return arr[n];

}
}