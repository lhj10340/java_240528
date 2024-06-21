package Day04_study;

public class ForEx05 {

	public static void main(String[] args) {
		
		// 1부터 10까지 짝수의 합을 구하는 반복문을 작성.
		
		/* 반복횟수 : 1부터 10까지 1씩 증가.
		 * 규칙성 : 짝수의 합 출력.
		 * 반복문 종료 후 : 합계 출력.
		 * */
		
		int sum = 0;
		
		for( int i = 1; i <= 10 ; i++ ) {
			
			/* 여기를 제외하고는 ForEx04 와 동일하다. 
			 * 짝수의 합을 구하는 것이기 때문에, 조건문을 추가하여 1 ~ 10 사이의 수 사이에서 짝수만 걸러야 한다.
			 * 그 조건에 부합하는 경우에만 합계에 포함될 수 있도록 조건문 작성.
			 * */
			
			if(i % 2 == 0) {
				sum += i;
				
			}
		}
		
		System.out.println(sum);
		
	}

}
