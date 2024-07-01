package day24;

public class Ex03 {

	public static void main(String[] args) {
		
		int num = 2;
		
		if (num % 2 == 0); {
			System.out.println("짝수");
		}
		
		if (num % 2 != 0); {
			System.out.println("홀수");
		}
		
		/* 짝수라고 판별해야하는데 짝수, 홀수 모두 출력이 되었다.
		 * 원인 : 조건식과 실행문 사이에 ; 이 찍혀있다. 종료가 되어 각각 별도의 문장이다.
		 * 해결 방법 : ; 을 삭제한다.
		 * */
		
	}

}
