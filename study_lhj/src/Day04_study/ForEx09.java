package Day04_study;

public class ForEx09 {

	public static void main(String[] args) {
		
		// a 부터 z 까지 출력하는 반복문.
		
		/* 반복횟수 : 0부터 25까지 1씩 증가.
		 * 규칙성 : a 부터 z 까지 순서대로 출력.
		 * 반복문 종료 후 : 없음.
		 * */
		
		for ( int i = 0; i <= 25 ; i++ ) {
			char chr = 'a';
			System.out.print((char)(chr + i) + ". ");
		}
		
	}

}
