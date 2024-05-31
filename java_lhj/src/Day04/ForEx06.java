package Day04;

public class ForEx06 {

	public static void main(String[] args) {

		/* 12의 약수를 출력하는 코드를 작성하세요.
		 * 
		 * 반복횟수 : i 는 1 ~ 12까지 1씩 증가
		 * 규칙성 : 12 를 i 로 나눈것 중 나머지 0인 것을 출력 ( i가 12의 약수일 때, i를 출력 )
		 * 반복문 종료 후 : 없음.
		 * 
		 * */
		

		for ( int i = 1 ; i <= 12 ; i++ ) 
		{ if ( 12 % i == 0 ) { System.out.println(i); } }
		
	}

}
