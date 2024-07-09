package Day02_study;

public class ConditionalOperatorEx02 {

	public static void main(String[] args) {
		// 조건 연산자
		// num 가 짝수이면 짝수라고 출력하고 홀수이면 홀수라고 출력하는 코드를 작성하세요.
		// num 가 짝수이면 짝수라고 res 에 저장하고 아니면 홀수라고 res 에 저장
		
		int num = 3;
		
		String res = ( num % 2 == 0 ) ? "짝수" : "홀수";
		
		System.out.println(res);
		
	}

}
