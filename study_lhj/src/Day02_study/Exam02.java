package Day02_study;

public class Exam02 {

	public static void main(String[] args) {
		//num1, num2, ch 를 이용하여 1+2 가 콘솔에 출력되도록 코드를 작성해보세요.
		
		int num1 = 1, num2 = 2;
		char ch = '+';
		
		String str = "" + num1 + ch + num2;
		System.out.println("" + num1 + ch + num2);
		System.out.println(str);
		
		// 문자형 + 정수형 = 정수형
		// 1+2 가 출력되게 하려면 문자열이 되어야 한다.
		// ' 문자열 + 기본형 = 문자열 ' 이기 때문에 맨 앞에 빈 문자열 "" 를 넣어주어야 한다.
		// 그리고 빈 문자열을 사용해야하니, string 을 사용한 것.
		
	}

}
