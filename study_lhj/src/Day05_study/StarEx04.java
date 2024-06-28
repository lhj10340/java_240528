package Day05_study;

public class StarEx04 {

	public static void main(String[] args) {
		
		/* 아래와 같은 모양이 만들어지도록 반복문을 작성.
		 * 
		 *      *
		 *     ** *
		 *    *** **
		 *   **** ***
		 *  ***** ****
		 *  
		 *  StarEx03 에서 1개의 반복문만 더 넣으면 된다.
		 *  * 은 i-1 만큼만 추가로 증가한다.
		 *  
		 * */
		
		for( int i = 0; i < 5; i++ ) {
			for ( int j = 1; j < 5-i ; j++ ) {
				System.out.print(" ");
			}
			for ( int j = 0; j <= i ; j++ ) {
				System.out.print("*");
			}
			for( int j = 0; j < i ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
