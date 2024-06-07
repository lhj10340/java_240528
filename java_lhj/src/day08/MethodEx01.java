package day08;

public class MethodEx01 {
	
	/* 주어진 num3 가 소수인지 아닌지 판별하는 코드를 작성하세요.
	 * 단, 메서드를 이용할 것.
	 * */
	
	public static void main(String[] args) {
		// num가 소수인지 판별하는 코드
		int num = 7;
		
		boolean result = isPrime(num);
		
		if(result) {
			System.out.println(num + "는 소수");
		} else {
			System.out.println(num + "는 소수가 아닙니다.");
		}
		// 100 이하의 소수를 출력하는 코드를 작성하세요. ( isPrime 을 이용할 것. )
		
		for(num = 2; num <= 100; num++) {
			if(isPrime(num)) {
				System.out.print(num + " ");
			}
		}
		
	}
	
	/** 주어진 정수가 소수인지 아닌지 알려주는 메서드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : boolean
	 * 메서드명 : isPrime
	 * 
	 * 주어진 정수를 나누었을 때, 나머지를 0으로 만드는 수가 2개인 정수를 확인.
	 * 	1개는 소수가 아니다. ex) '1'
	 * 	2개는 소수
	 * 	3개이상은 소수가 아니다.
	 * */
	
	public static boolean isPrime (int num) {
		int count = 0;
		
		for ( int i = 1; i <= num ; i++ ) {
			if((num % i == 0)) {
				count++;
			}
		}
		boolean result;
			if(count == 2) {
				result = true;
			}else {
				result = false;
			}
			
		return result;
		
		/* 두번째 방법
		 * public static boolean isPrime2 (int num) {
			if(num == 1) {
				return false;
			}
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					
				}
			}
			// 반복문이 끝날 때까지 약수를 찾지 못했다. => 약수가 1과 자기가신 뿐이다.
			return true;
		}
	}
	*/
	
	/* 메서드의 경우 어떠한 경우에도 리턴 값이 나와야한다.
	 * (1)
	 * 
	 * if(count == 2) {
	 * 		return true;
	 * } // 이렇게만 하면 에러가 난다.
	 * else {
	 * 		return false;
	 * }
	 * 
	 * (2)
	 * 
	 * if(count == 2){
	 * 	return true;
	 * }
	 * return false;
	 * 
	 * (3)
	 * 
	 * return count == 2 ? true : false
	 * 
	 * 간결하게 하는 것보다는 내가 이해할 수 있는 방법이 좋다.
	 * 간결함은 그 뒤.
	 * */

}
}
