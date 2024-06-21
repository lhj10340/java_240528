package Day04_study;

public class WhileEx06 {

	public static void main(String[] args) {
		
		// 12의 약수를 출력하는 반복문.
		
		int i = 1;
		
		while(i <= 12) {
			if ( 12 % i == 0) {
				System.out.print("" + i + ". ");
			} i++;
		}
	}

}
