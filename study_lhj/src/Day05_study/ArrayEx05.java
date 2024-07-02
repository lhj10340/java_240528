package Day05_study;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {

		// 1 ~ 10 사이의 랜덤한 수 3개를 저장하고 출력하는 예제.
		// 예시 : 랜덤으로 생성한 숫자가 1 3 2

		int min = 1, max = 10;

		int [] arr = new int [3];

		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*( max - min + 1 ) + min);
			arr[i] = random;
			System.out.print(arr[i] + ". ");
		}

		// 숫자를 입력해서 입력한 숫자가 랜덤한 수에 있는지 확인하는 예제.
		// 8을 입력하면 8은 없습니다. 라고 출력.
		// 2를 입력하면 2는 있습니다. 라고 출력.

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.print("정수 입력 : ");

		int num = scan.nextInt();
		int i;
		
		/* for ( i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				break;
			}
		}

		if( i < arr.length ) {
			System.out.println(num + "은 있습니다.");
		} else {
			System.out.println(num + "은 없습니다.");
		}
	} */
		
		boolean res = false;
		
		for ( int tmp : arr) {
			if(tmp == num) {
				res = true;
				break;
			}
		}
		
		if(res) {
			System.out.println(num + " 있습니다.");
		} else {
			System.out.println(num + " 없습니다.");
		}
		
	}
}
