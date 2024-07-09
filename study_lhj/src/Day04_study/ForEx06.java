package Day04_study;

public class ForEx06 {

	public static void main(String[] args) {
		
		// 12의 약수를 출력하는 반복문.
		
		/* 반복횟수 : 1에서 12까지 1씩 증가.
		 * 규칙성 : ' 12 % i == 0 ' 가 되게 하는 i
		 * 반복문 종료 후 : 없다.
		 * */
		
		for( int i = 1 ; i <= 12 ; i++ ) {
			if( 12 % i == 0) {
				System.out.print("" + i + ". ");
			}
		}
		
	}

}
