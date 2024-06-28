package Day05_study;

public class LCMEx01 {

	public static void main(String[] args) {
		
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * A의 배수 B : B 를 A로 나누었을 때, 나머지가 0인 B를 A의 배수라고 표현.
		 * 6의 배수 : 6, 12, 18 ...
		 * 8의 배수 : 8, 16, 24 ...
		 * 공배수 : 두 수의 배수 중 공통으로 있는 수
		 * 6과 8의 공배수 : 24, 48, 72 ...
		 * 최소 공배수 : 두 수의 공배수 중 가장 작은 수
		 * 6과 8의 최소 공배수 : 24
		 * */
		
		int i = 1;
		
		for( ; ; i++ ) {
			if((i % 6 == 0) && (i % 8 == 0)) {
				System.out.print(i);
				break;
			} 
		}
		
	}

}
