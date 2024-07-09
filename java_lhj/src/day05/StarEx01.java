package day05;

public class StarEx01 {

	public static void main(String[] args) {
		/* * 을 하나씩 출력해서 다음과 같이 출력되록 중첩 반복문을 이용하여 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * 반복횟수 : 5줄이라서 1부터 5까지 1씩 증가로 해야한다.
		 * 규칙성 : ***** 를 출력.
		 * 		 => 반복횟수 :  j는 1부터 5까지 1씩 증가.
		 * 			규칙성 : *을 출력(한 줄로)
		 * 			반복문 종료 후 : 엔터를 출력
		 * 반복문 종료 후 : 없음.
		 * */
		
		// 5줄 반복
		 int i, j;
		// 5줄 반복
		 for ( i = 1 ; i <= 5 ; i++ ) {
		// ***** 엔터, 를 출력.
		 for(j = 1; j <= 5; j++) {
			System.out.print("*");
		}
		System.out.println(); // 또는 System.out.print('\n'); // 엔터
		}
		
	}
}
	
		
	
