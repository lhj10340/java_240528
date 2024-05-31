package Day04;

public class ForEx08 {

	public static void main(String[] args) {
		
		/* 두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공약수 중 가장 큰 공약수
		 * 
		 * 반복횟수 : i는 1부터 8까지 1씩 증가. ( 둘 중 하나만 넣으면 된다. )
		 * 규칙성		: i가 8과 12의 약수이면 i를 gcd에 저장한다
		 * 			: => i가 8의 약수이고 i가 12의 약수이면 i를 gcd에 저장
		 *  		: => 8을 i로 나누었을 때 나머지가 0과 같고, 12를 i로 나누었을 때 나머지가 0과 같다면 i를 gcd에 저장.
		 * 반복문 종료 후 : gcd를 출력
		 * */
		
		int i = 1;
		int abc = 1;

		for ( ; i<=8 ; i++ ) { if ( ( 8 % i == 0 ) && ( 12 % i == 0 ) ) { abc = i; } }

		System.out.println(abc);
		
	}

}
