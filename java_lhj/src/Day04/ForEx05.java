package Day04;

public class ForEx05 {

	public static void main(String[] args) {
		/* 1부터 10까지 짝수의 합을 구하는 코드를 작성하세요.
		 * 
		 * 반복횟수 : i는 2부터 10까지 2씩 증가.
		 * 규칙성 :  sum += 2
		 * 반복문 종료 후 : 1 ~ 10 까지 짝수의 합.
		 * 
		 * 		sum0 = 0
		 * 	i=2	sum = sum + 2
		 * 	i=4	sum = sum + 4
		 * 	i=6	sum = sum + 6
		 * 	i=8	sum = sum + 8
		 * 	i=10 sum = sum + 10
		 * 		sum = sum + i
		 * 
		 * */
		
		int i = 1;
		int sum = 0;

		for ( ; i <=10 ; i++ ) { if ( i % 2 == 0 ) { sum += i; } }
		
		System.out.println(sum);
		
	}

}
