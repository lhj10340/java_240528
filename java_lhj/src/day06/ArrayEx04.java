package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// 4자리 정수를 입력받아 입력받은 정수를 역순으로 배열에 저장하고, 출력하는 코드를 작성.
		// 1234 => 0번지에 4, 1번지에 3, 2번지에 2, 3번지에 1을 저장하고, 4,3,2,1 순으로 출력.
		
		// 4자리 정수 입력.
		int num;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("4자리 정수를 입력하세요 : ");
		num = scan.nextInt();
		int arr [] = new int [4]; // 4자리 정수여서 자리 4개의 배열 선언.
		
		// 4자리 정수가 아니면 잘못 입력됐다고 출력.
		
		if(num<1000 || num>9999) {
			System.out.print("4자리 정수가 아닙니다.");
		}
		
		// 4자리 정수이면 ( 이 부분부터 못 했다. )
		
		else {
			// 역순으로 배열에 저장, % 연산과 / 연산을 이용.
			// 1234 => 4를 추출해서 배열에 저장하고, 1234 => 123 으로 만듦.
			// 123 => 3을 추출해서 배열에 저장하고, 123 => 12로 만듦.
			// 12 => 2를 추출해서 배열에 저장하고, 12 => 1로 만듦.
			// 1 = > 1을 추출해서 배열에 저장하고, 1 => 0으로 만듦.
			
			int tmp = num;
			int i = 0;
			while(tmp != 0) {
				arr[i++] = tmp % 10;
				tmp = tmp / 10; // 정수 / 정수 = 정수 ( 소수가 생기지 않는다. )
			}
			
			// 배열에 값을 순차적으로 출력.
			System.out.print("역순 : ");
			for(int tmp2 : arr) {
				System.out.print(tmp2);
			}
		}
	}

}