package Day05_study;

public class StarEx01 {

	public static void main(String[] args) {

		/* * 을 하나씩 출력해서 다음과 같이 출력되록 중첩 반복문을 이용하여 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		for( int i = 0; i < 5 ; i++ ) {
			for( int j = 0; j < 5; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
