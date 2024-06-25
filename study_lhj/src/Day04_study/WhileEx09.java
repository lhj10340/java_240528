package Day04_study;

public class WhileEx09 {

	public static void main(String[] args) {
		// a 부터 z 까지 출력하는 반복문.
		
		int i = 0;
		
		while( i <= 25 ) {
			System.out.print((char)('a' + i) + ". "); i++;
		}
	}

}
