package Day04;

public class ContinueEx01 {

	public static void main(String[] args) {
		// 1부터 10 사이의 짝수 출력 예제 (continue 사용)
		// continue 문의 뒤에는 실행되지 않는다. ( break 와 유사, 그래서 if 문과 같이 사용한다. )
		
		int i = 0;
		
		while (i < 10) {
			i++;
			// 홀수이면 i를 출력하지 않고 건너뛴다.
			if(i % 2 != 0) {
				continue; // while 문에서는 조건식으로 건너뛴다.
			}
			System.out.println(i); 
			
		}
	}

}
