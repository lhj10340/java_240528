package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력.
		// " 못 풀었다. : 조건식 설정을 못 했다. "
		// " ~ 하거나 " : 를 잘 생각해봐야 한다.
		// month = 6||7||8 
		// : 예를들어 이런건 자바에서 인식을 못 한다. 이건 C언어,자바스크립트에서 인식이 되긴한다. 0이 아니면 참이기 때문이다.
		// month == 6 || month == 7 || month == 8 : 이렇게 각각 해줘야한다. 각 항의 참,거짓이 판별될 수 있어야한다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월 : ");
		int month = scan.nextInt();
		
		if(month == 3|| month == 4|| month == 5) {System.out.println("봄");
		// 월이 3이거나 4이거나 5이면 중 하나 이면 봄으로 출력.
	} else if(month == 6|| month == 7|| month == 8) {System.out.println("여름");
		// 아니면 월이 6이거나 7이거나 8이면 중 하나 이면 봄으로 출력.
	} else if(month == 9|| month == 10|| month == 11) {System.out.println("가을");
		// 아니면 월이 9이거나 10이거나 11이면 중 하나 이면 봄으로 출력.
	} else if(month == 12|| month == 1|| month == 2) {System.out.println("겨울");
		// 아니면 월이 12이거나 1이거나 2이면 중 하나 이면 봄으로 출력.	
	} else {System.out.println("잘못된 월");
		// 아니면 잘못된 월이라고 출력.
	
	}
		
		// 월이 3이상 5이하면 봄이라고 출력
		// 아니면 월이 6이상 8이하면 여름이라고 출력
		// 아니면 월이 9이상 11이하면 가을이라고 출력
		// 아니면 월이 12이거나, 1이상 2이하면 겨울이라고 출력
		// 아니면 잘못된 월이라고 출력
		
		// 논리 연산자 사이의 우선 순위가 있기때문에 먼저 해야할 것에 괄호를 해주는 것이 안전하다.
		
		System.out.print("월 : ");
		
		if(month>=3 && month<=5) {System.out.println("봄");
	} else if(month>=6 && month<=8) {System.out.println("여름");
	} else if(month>=9 && month<=11) {System.out.println("가을");
	} else if(month ==12 || (month>=1 && month<=2)) {System.out.println("겨울");
	} else {System.out.println("잘못된 월");
	
	}
		
		
		

}
}
