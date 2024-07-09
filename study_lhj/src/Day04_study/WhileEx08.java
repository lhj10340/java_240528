package Day04_study;

public class WhileEx08 {

	public static void main(String[] args) {
		
		// 8과 12의 최대 공약수를 구하는 반복문.
		
		int i = 1, num = 12, num1 = 8;
		
		int gcd = 0;
		
		while ( i <= num ) {
			if( (num % i == 0) && (num1 % i == 0) ) {
				gcd = i;
			} i++;
		}
		System.out.println(gcd);
	}

}
