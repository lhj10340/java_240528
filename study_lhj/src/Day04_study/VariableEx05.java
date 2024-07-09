package Day04_study;

public class VariableEx05 {

	public static void main(String[] args) {
		// 실수 소수점 유효범위 확인하는 예제.

		float num1 = 0.12345678f; // 여섯째 자리까지 정확하고 그 이후는 맞을 수도 틀릴 수도 ..
		double num2 = 0.123456789012345678; // 열다섯째 자리까지 정확하고 그 이후는 맞을 수도 틀릴 수도 ..

		System.out.printf("%.20f\n", num1); // %f : 실수를 의미.
		System.out.printf("%.20f\n", num2); // 소수점 아래 20개라는 의미.
	}

}
