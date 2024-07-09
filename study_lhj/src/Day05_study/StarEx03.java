package Day05_study;

public class StarEx03 {

	public static void main(String[] args) {
		
		/* 이 모양의 삼각형이 출력되도록 중첩 반복문을 작성.
		 * 
		 *     *  / 공백 4개 입력 후, * 1개
		 *    **  / 공백 3개 입력 후, * 2개
		 *   ***  / 공백 2개 입력 후, * 3개
		 *  ****  / 공백 1개 입력 후, * 4개
		 * *****  / 공백 0개 입력 후, * 5개
		 * 
		 * 반복횟수 : i 는 4에서 0까지 1씩 감소.
		 * 규칙성 : i 와 동일한 수만큼의 공백 출력
		 * 			반복횟수 : j 는 1에서 5까지 1씩 증가
		 * 			규칙성 : (5-i) 개 만큼의 * 출력
		 * 			반복문 종료 후 : 엔터 출력
		 * 반복문 종료 후 : 없음.
		 * 
		 * */
		
		for( int i = 0; i < 5; i++) {
			for (int j = 1; j < (5-i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
