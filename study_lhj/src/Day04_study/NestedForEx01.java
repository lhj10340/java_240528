package Day04_study;

public class NestedForEx01 {

	public static void main(String[] args) {

		/* 구구단 2 ~ 9단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : num 을 2부터 9까지 1씩 증가
		 * 규칙성 : num 단을 출력하는 코드.
		 * 반복문 종료 후 : 없음.
		 * */

		int res;

		for ( int num = 2; num < 10; num++ ) {
			System.out.println(num + "단");
			for( int i = 1; i < 10; i++) {
				res = num * i;
				System.out.println(num + " * " + i + " = " + res);
			}
		}
	}

}
