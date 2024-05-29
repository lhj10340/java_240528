package day02;

public class ConditionalOperatorEx2 {

	public static void main(String[] args) {
		// 조건 연산자
		// num 가 짝수이면 짝수라고 출력하고 홀수이면 홀수라고 출력하는 코드를 작성하세요.
		
		/* num 가 짝수이면 짝수라고 str 에 저장하고 아니면 홀수라고 str 에 저장.
		 * num 을 2로 나누었을 때, 나머지가 0과 같으면 짝수를 아니면 홀수를 str 에 저장.
		 * */
		
		int num = 3;
		String str = (num%2==0) ? "짝수" : "홀수" ;
		System.out.println(num + "은 " + str + "입니다. " );
	}

}
