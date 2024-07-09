package Day04_study;

public class ForEx04 {

	public static void main(String[] args) {
		// 1부터 10까지 합을 구하는 반복문.
		
		/* 반복횟수 : 10회
		 * 규칙성 : 
		 * 
		 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		 * 
		 * sum1 = sum0 + 1
		 * sum2 = sum0 + 1 + 2
		 * sum3 = sum0 + 1 + 2 + 3
		 * sum4 = sum0 + 1 + 2 + 3 + 4
		 * sum5 = sum0 + 1 + 2 + 3 + 4 + 5
		 * sum6 = sum0 + 1 + 2 + 3 + 4 + 5 + 6
		 * sum7 = sum0 + 1 + 2 + 3 + 4 + 5 + 6 + 7
		 * sum8 = sum0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8
		 * sum9 = sum0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9
		 * sum10 = sum0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		 * => sum i = sum(i-1) + i
		 * 
		 * 반복문 종료 후 : 합계 출력?
		 * 
		 * */
		
		int sum = 0;
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			
			sum += i;
		}
		
		System.out.println(sum);
		
	}

}
