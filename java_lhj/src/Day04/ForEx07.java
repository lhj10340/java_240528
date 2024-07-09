package Day04;

public class ForEx07 {

	public static void main(String[] args) {

		/* 4가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기자신인 수를 소수라고 한다.
		 * 
		 * 반복 횟수 : i가 1에서 4까지 1씩 증가
		 * 규칙성 : i가 4의 약수라면 약수의 개수(count)를 1증가
		 * 반복문 종료 후 : 약수의 개수가 2개이면 소수, 아니면 소수가 아니라고 출력.
		 * 
		 * count 쓰는거 검색해서 했다, 다시 해봐야 함.
		 * 
		 * */
		
		int num = 4;
		int i = 1, count = 0;

		for ( ; i <= num ; i++ ) {
			if ( num % i == 0 ) { count++; } }

		if ( count == 2 ) { System.out.println(num + " 은 소수입니다."); }
		else { System.out.println(num + " 은 소수가 아닙니다.");
		
	}

}}
