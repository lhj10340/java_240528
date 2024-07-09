package Day04_study;

public class NestedForEx02 {

	public static void main(String[] args) {
		
		// 약간에 차이로 되지 않았다, 강사님께 질문 후 풀이 적음. ( 나중에 다시 해보자 )
		
		// num가 소수인지 아닌지 판별하는 코드를 이용하여 100이하의 소수를 출력하는 코드를 작성하세요.

		// 소수는 나눠서 나머지가 0이 되게 하는 수가 1과 자기 자신 뿐인 수.

		/* 반복횟수 : num 는 2부터 100까지 1씩 증가
		 * 규칙성 : num 가 소수인지 아닌지 판별하는 코드를 활용해서 소수이면 num 를 출력, 아니면 아무것도 안함.
		 * 반복문 종료 후 : 없음.
		 * */

		int i, count = 0;
		int num = 2;
		
		for ( num = 2 ; num <= 100; num++ ) {
			
			for ( i = 1 , count = 0; i <= num; i++) {
				
				// 숫자마다 약수를 구해야하므로 중간에 초기화를 계속 해줘야한다.
				
				if(num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println(num);
			}
		}

	}

}
