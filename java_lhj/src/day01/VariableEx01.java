package day01;

public class VariableEx01 {

	public static void main(String[] args) {

		char ch1; // 문자형 변수 ch1 선언.
		char ch2 = 'A'; // 문자형 변수 ch2를 선언하고 A로 초기화.
		// 문자형 변수 ch3과 ch4를 선언.
			/* 
			char ch3;
			char ch4; 도 가능하다.
			*/
		char ch3, ch4; // 같은 자료형인 경우 ,를 통해 동시에 선언할 수 있다.
		// 문자형 변수 ch5를 선언하고 +로 초기화
		// 문자형 변수 ch6을 선언하고 \n으로 초기화
		char ch5 = '+', ch6 = '\n';
		System.out.println(ch2);
		System.out.println(ch6);
		System.out.println(ch5);
		// 정수 리터럴은 기본이 int고 실수 리터럴은 기본이 double
		long num1 = 1234567890123L; // 정수 값이 int 형으로 표현되지 않으면 접미사를 반드시 붙여야 한다.
		float num2 = 3.14F; // 3.14는 double 형이기 때문에 반드시 접미사를 붙여야 한다.
		double num3 = 3.14;
		boolean isEven = true;
	}

}
