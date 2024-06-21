package Day04_study;

public class WhileEx07 {

	public static void main(String[] args) {
		
		// 4의 소수 여부를 판별하는 반복문.
		
		int i = 1, num = 5;
		int count = 0;
		
		while ( i <= num ) {
			if ( num % i == 0 ) {
				count++;
			} i++;
		}
		
		if ( count == 2 ) {
			System.out.println("" + num + "은(는) 소수입니다.");
		}
		else {
			System.out.println("" + num + "은(는) 소수가 아닙니다.");
		}
		
	}

}
