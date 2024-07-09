package Day05_study;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		
		/* 3개의 정수를 입력받아 배열에 저장하고, 역순으로 출력하는 코드를 작성하세요. */
		
		Scanner scan = new Scanner(System.in);
		
		int [] arr = new int [3];
		
		for( int i = 0; i < 3 ; i++ ) {
			
			System.out.println("정수 입력 : ");
			
			arr[i] = scan.nextInt();
			
		}
		
		
	}

}
