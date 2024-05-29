package day02;

public class ArithmeticOperatorEX01 {

	public static void main(String[] args) {
		// 산술 연산자 예제
		
		int num1 = 1, num2 = 2;
		
		System.out.println("" + num1 + '+' + num2 + '=' + (num1 + num2));
		System.out.println("" + num1 + '-' + num2 + '=' + (num1 - num2));
		System.out.println("" + num1 + '*' + num2 + '=' + (num1 * num2));
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / num2)); // 형 변환 안한 경우
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / (double)num2));
		System.out.println("" + num1 + '%' + num2 + '=' + (num1 % num2));
	}

}
