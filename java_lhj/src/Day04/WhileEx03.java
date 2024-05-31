package Day04;

public class WhileEx03 {

	public static void main(String[] args) {
		
		// 구구단 2단을 출력하는 코딩.
		// 반복횟수 : i 는 1부터 9까지 1씩 증가
		// 규칙성 : 2 X i = 를 출력
		// 반복문 종료 후 : 없음.
		
		// 한 줄로 하려는 습관은 버려야 함.
		
		int i = 1;
		while(i <= 9) {
			int res = 2 * i;
			System.out.println( "2 X " + i + " = " + res ); 
			i++;
		
		}
	}

}
