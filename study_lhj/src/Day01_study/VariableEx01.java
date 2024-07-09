package Day01_study;

public class VariableEx01 {

	public static void main(String[] args) {
		// 문자형 변수 ch1 을 선언.
		char ch1;
		// 문자형 변수 ch2 를 선언하고 A 로 초기화.
		char ch2 = 'A';
		// 문자형 변수 ch3, ch4 선언. ( 같은 자료형의 경우 동시에 선언이 가능하다. )
		char ch3, ch4;
		// 문자형 변수 ch5 를 선언하고 + 로 초기화.
		char ch5 = '+';
		// 문자형 변수 ch6 을 선언하고 \n 으로 초기화.
		char ch6 = '\n';
		// 정수의 리터럴은 int, 실수의 리터럴은 double.
		long num1 = 1234567890123L; // 정수, 리터럴은 int 지만 int 의 범위를 넘어섰기 때문에 long 사용 후, 접미사 L 입력.
		float num2 = 3.14F; // 3.14 는 실수, 리터럴은 double, float 표시를 위해 접미사 F 입력.
		double num3 = 3.14; // 3.14 는 실수, 리터럴은 double, Ok.
		boolean isEven = true; // true/false 표시를 위해서 boolean 사용. 리터럴은 false.
	}

}
