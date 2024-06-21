package Day04_study;

public class WhileEx05 {

	public static void main(String[] args) {
		
		// 1부터 10까지 짝수의 합을 구하는 반복문.
		
		int i = 1;
		int sum = 0;
		
		while(i <= 10) {
			if( i % 2 == 0 ) {
				sum += i;
			} i++;
		}
		
		System.out.println(sum);
		
	}

}
