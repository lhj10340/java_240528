package day24;

public class Ex04 {

	public static void main(String[] args) {
		
		int score = 80;
		
		if ( score >= 90 && score <= 100 ) {
			System.out.println("A");
		}
		
		/* A를 판별하는 코드를 작성했는데, A가 아닌 경우에도 A가 출력
		 * 원인 : 잘못된 연산자
		 * 해결 방안 : || 를 && 로 변경. ( 두 조건 모두 만족해야한다. )
		 * */
		
	}

}
