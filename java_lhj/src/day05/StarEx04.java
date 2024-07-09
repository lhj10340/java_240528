package day05;

public class StarEx04 {

	public static void main(String[] args) {
		/* * 을 하나씩 출력해서 다음과 같이 출력되록 중첩 반복문을 이용하여 작성하세요.
		 *     *		공백 = 4개, i = 1, 추가 별 * = 0
		 *    ** *		공백 = 3개, i = 2, 추가 별 * = 1
		 *   *** **		공백 = 2개, i = 3, 추가 별 * = 2
		 *  **** ***	공백 = 1개, i = 4, 추가 별 * = 3
		 * ***** ****	공백 = 0개, i = 5, 추가 별 * = 4
		 * 반복횟수 : i는 1 ~ 5까지 1씩 증가.
		 * 규칙성 : 공백을 ? 개 출력하고 * 을 i개 출력 후 엔터.
		 *		 => 반복횟수 : j는 1부터 (5-i)까지 1씩 증가.
		 * 			규칙성 : 공백을 출력
		 * 			반복문 종료 후 : 없음
		 * 		 => 반복횟수 : j는 1부터 i까지 1씩 증가.
		 * 			규칙성 : *을 출력
		 * 			반복문 종료 후 : 없음.
		 * 		 => 반복횟수 : j는 1부터 (i-1)까지 1씩 증가.
		 * 			규칙성 : *을 출력
		 * 			반복문 종료 후 : 엔터 출력	
		 * 반복문 종료 후 : 없음.
		 * */
		
		// 5줄 반복
		 int i, j;
		// 5줄 반복
		 for ( i = 1 ; i <= 5 ; i++ ) {
			 // 공백을 ?개 출력
			 for(j = 1; j <= (5-i); j++) {
					System.out.print(" ");
					 }
			// *을 출력
			 for(j = 1; j <= i; j++) {
				 	System.out.print("*");
			 }
			// 추가 *을 ?개 출력 
			 for(j = 1; j <= (i-1); j++) {
					System.out.print("*");
					 }
			 System.out.println(); // 또는 System.out.print('\n'); // 엔터
			 }
		}
		
	}

	
		
	
