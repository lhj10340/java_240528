package day06;

import java.util.Scanner;

public class ArraysEx08 {

	public static void main(String[] args) {
		/* 문자열을 최대 5개 저장할 수 있는 배열을 선언하고,
		 * 문자열을 5개 입력하여 저장한 후, 저장한 문자열을 출력하는 예제를 작성하세요.
		 * */

		// 입력하는 것.
		Scanner scan = new Scanner(System.in);
		
		// 문자열 5개를 저장하는 배열 선언.
		String [] list = new String [5];
		
		// 배열 사용을 위해 정수 선언.
		int i;
		
		System.out.print("문자열 입력 : ");
		
		for ( i = 0 ; i < list.length ; i++ ) {
			list[i] = scan.next();
		}
		
		for(String tmp : list) {
			System.out.println(tmp);
		}
		// 문자열을 입력 (5개)
		
		
	}

}
