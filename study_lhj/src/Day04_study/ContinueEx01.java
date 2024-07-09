package Day04_study;

public class ContinueEx01 {

	public static void main(String[] args) {
		
		// 좀 헤메다가 풀었다. ( 나중에 다시 해보자 )
		
		// 1부터 10 사이의 짝수 출력 예제 (continue 사용)
		// continue 문의 뒤에는 실행되지 않는다. ( break 와 유사, 그래서 if 문과 같이 사용한다. )
		
		int i = 0;
		
		while ( i <= 10 ) { i++;
			if( i % 2 != 0 ) {
				continue;
			}
			System.out.print(i + ". ");
		}
		
	}

}
