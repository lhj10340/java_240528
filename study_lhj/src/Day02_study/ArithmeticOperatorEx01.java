package Day02_study;

public class ArithmeticOperatorEx01 {

	public static void main(String[] args) {
		// 산술 연산자 예제
		
		int num1 = 5, num2 = 3;
		
		System.out.println("" + num1 + '+' + num2 + '=' + (num1 + num2));
		System.out.println("" + num1 + '-' + num2 + '=' + (num1 - num2));
		System.out.println("" + num1 + '*' + num2 + '=' + (num1 * num2));
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / num2)); // 형 변환을 하지 않으면, 정수 / 정수 = 정수
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / (double)num2)); // 형 변환을 한 경우, 정수 / 정수 = 실수
		System.out.println("" + num1 + '%' + num2 + '=' + (num1 % num2));
	}

}
