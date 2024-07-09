package Day03_study;

import java.util.Scanner;

public class NestedIfEx01 {

	public static void main(String[] args) {
		
		// 6의 배수를 중첩 if 문을 이용하여 작성하는 예제
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		
		int num = scan.nextInt();
		
		if(num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println(num + " 은 6의 배수입니다.");
			}
			else {
				System.out.println(num + "은 6의 배수가 아닙니다.");
			}
		}
		else {
			System.out.println(num + "은 6의 배수가 아닙니다.");
		}
		
	}

}
