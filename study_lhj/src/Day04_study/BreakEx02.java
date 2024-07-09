package Day04_study;

public class BreakEx02 {

	public static void main(String[] args) {
		
		// 좀 헤메다가 풀었다. ( 나중에 다시 해보자 )
		
		// 최대 공약수 예제를 break 문을 이용하여 구현하는 예제.

		/* num1 에 8, num2 에 12가 저장. */
		
		int num1 = 8, num2 = 12;
		int i = num2;
		
		while(i >= 1) {
			if((num2 % i == 0) && (num1 % i == 0)) {
				System.out.println(i);
				break;
			}
			i--;
			
		}
			
	}

}
