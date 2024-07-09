package Day05_study;

public class StarEx02 {
	
	public static void main(String[] args) {
		
		/* * 을 하나씩 출력해서 다음과 같이 출력되록 중첩 반복문을 이용하여 작성하세요.
		 * *		i = 1, 
		 * **		i = 2,
		 * ***		i = 3,
		 * ****		i = 4,
		 * *****	i = 5
		 */
		
		/* 반복횟수 : i 는 1 ~ 5까지 1씩 증가
		 * 규칙성(1) : 줄을 바꿔가며 * 를 1개씩 출력
		 * 	   (2) : 반복횟수 : j 에서 i 까지 1씩 증가
		 * 			 j 는 첫번째 줄에서 0개
		 *				  두번째 줄에서 1개
		 *				  세번째 줄에서 2개
		 *				  네번째 줄에서 3개
		 *				  다섯번째 줄에서 4개
		 *				  즉, i 보다 작은 개수의 * 이 추가되엇다.
		 *			 반복문 종료 후 : 엔터 입력하여 줄을 바꾼다.
		 * 반복문 종료 후 : 없음.
		 * */
		
		for ( int i = 0 ; i < 5 ; i++ ) {
			for ( int j = 0; j <= i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

