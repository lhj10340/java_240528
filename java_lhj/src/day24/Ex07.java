package day24;

public class Ex07 {

	public static void main(String[] args) {
		
		/* 1부터 10까지의 합을 구하려고 했다.
		 * 원인 : ; 이 찍혀있다. ( 그래서 1만 반복된다. )
		 * 해결 방법 : ; 삭제.
		 * */
		
		int i;
		
		int sum = 0;
		
		// for ( i = 1; i <= 10; i++); {
		// 		sum += i }
		// 는 아래와 동일하다.
		
		for ( i = 1; i <= 10; i++ ) {
			
		}
		
		{
			sum += i;
		}
		
		System.out.println("1부터 10까지의 합 : " + sum);
	}

}

