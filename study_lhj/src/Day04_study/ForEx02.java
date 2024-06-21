package Day04_study;

public class ForEx02 {

	public static void main(String[] args) {
		// (1) 1부터 5까지 출력하는 반복문 
		// (2) 10부터 1까지 출력하는 반복문.
		
		// (1)
		/* 반복횟수 : 5회
		 * 규칙성 : 1부터 시작하여 1씩 증가하면서 출력된다.
		 * 반복문 종료 후 : 없음.
		 * */
		
		for(int i = 1; i <= 5 ; i++ ) {
			System.out.print("" + i + ". ");
		}
		
		System.out.println();
		
		// (2)
		/* 반복횟수 : 10회
		 * 규칙성 : 10부터 시작하여 1씩 감소한다.
		 * 반복문 종료 후 : 없음.
		 * */
		
		for(int i = 10; i >= 1; i--) {
			System.out.print("" + i + ". ");
		}
	}

}
