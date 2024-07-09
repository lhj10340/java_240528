package Day04;

public class ForEx04 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 10까지 1씩 증가.
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 : 전체 i의 합을 출력.
		 * 
		 * 		sum0 = 0
		 * i=1	sum1 = sum0 + 1
		 * i=2	sum2 = sum1 + 2
		 * i=3	sum3 = sum2 + 3
		 * 		...
		 * i=10	sum10 = sum9 + 10
		 * 		sum = sum + i
		 * */
		
		int i = 1, sum = 0;
		
		for ( ; i <= 10; i++ ) { sum += i; }
		
		System.out.println(sum);
		
	}

}
