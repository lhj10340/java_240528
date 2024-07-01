package day24;

public class Ex02 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		
		double res = (double)num1 / num2;
		
		/* 문제 : 1 / 2 = 0.5가 출력되지 않는다.
		 * 원인 : 정수를 정수로 나누면 정수가 출력된다. 1 과 2 모두 정수라서 0.0 으로 출력된다.
		 * 해결 방법 : 1 또는 2를 자료형변환 한다.
		 * */
		
		System.out.println(num1 + " / " + num2 + " = " + res);
		
	}

}
