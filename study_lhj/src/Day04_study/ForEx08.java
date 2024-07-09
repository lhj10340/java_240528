package Day04_study;

public class ForEx08 {

	public static void main(String[] args) {
		
		// 8과 12의 최대 공약수를 구하는 반복문 작성.
		
		/* 반복횟수 : 1부터 12까지 1씩 증가.
		 * 규칙성 :  ( 12 % i == 0 ) 중 ( 8 % i == 0 ) 도 만족하는 수.
		 * 		: 그 수를 선언한 변수에 입력. 반복되며 덮어지다보면 가장 큰 수만 남는다. ( 해설보고 추가한 부분 )
		 * 반복문 종료 후 : 없다.
		 * */
		
		// 이건 공약수만 구하는 코딩.
		
		/* for(int i = 1 ; i <= 12 ; i++ ) {
			if(12 % i == 0) {
				if(8 % i == 0) {
					System.out.print("" + i + ". ");
				}
			}
		} */
		
		// 해설보고 다시!
		
		int num = 0;
		
		for(int i = 1; i <= 12; i++) {
			if((12 % i == 0) && (8 % i == 0)) {
				num = i;
			}
		}
		
		System.out.println(num);
		
	}

}
