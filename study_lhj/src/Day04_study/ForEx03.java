package Day04_study;

public class ForEx03 {

	public static void main(String[] args) {
		// 구구단 2단을 출력하는 반복문 작성.
		
		/* 반복횟수 : 9회 ( 구구단은 ' x * 9 ' 까지 있다. )
		 * 규칙성 : ( 2 * i ) 가 출력된다.
		 * 반복문 종료 후 : 없음.
		 * */
		
		for ( int i = 1; i <= 9; i++) {
			int res = 2 * i;
			System.out.println("" + "2 * " + i + " = " + res);
		}
		
	}

}
