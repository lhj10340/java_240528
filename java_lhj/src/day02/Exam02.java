package day02;

public class Exam02 {

	public static void main(String[] args) {

		// 못 풀었음.
		
		int num1 = 1, num2 = 2;
		char ch = '+';
		// num1, num2, ch를 이용하여 1+2가 콘솔에 출력되도록 코드를 작성해보세요.
		
		String str = "" + num1 + ch + num2; // '정수 + 문자' 의 경우 문자가 정수화되어 더해진다. (자동 형 변환이 일어난다.)
		System.out.println("" + num1 + ch + num2); // "" 없을 경우 ch 의 유니코드 값이 더해져서 값이 다르게 나온다. (46)
		System.out.println(str);
		
	}

}
