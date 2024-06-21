package Day04_study;

public class ForEx07 {

	public static void main(String[] args) {
		
		// 4가 소수인지 아닌지 판별하는 반복문을 작성.
		
		// 소수란? : 나눠서 0이되는 수가 1과 자기자신 뿐인 수.
		
		/* 반복횟수 : 1부터 4까지 1씩 증가
		 * 규칙성 : ( 4 % i == 0 ) 의 개수 확인.
		 * 반복문 종료 후 : 소수인지 아닌지 출력.
		 * 
		 * */
		
		int count = 0;
		int num = 8;
		
		for( int i = 1; i <= num ; i++ ) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println("" + num + "은 소수입니다.");
		}
		else {
			System.out.println("" + num + "은 소수가 아닙니다.");
		}
	}

}
