package Day04_study;

public class VariableEx06 {
	public static void main(String[] args) {
		
		// 문자와 정수를 활용한 문자 출력 예제.
		// 알파벳은 아스키코드에 의해 각 정수에 맞는 알파벳이 지정되어있다.
		// 알파벳에 맞는 정수를 char 변수에 저장하면 해당 정수에 맞는 문자가 저장된다.
		
		char ch = 'a'; // char ch = 'a' + 1; 은 자동으로 계산할 수 있게 변환이 된다.
		
		int i = 1;
		ch = (char)(ch+i); // 이 경우에는 형변환을 하지 않으면, ch 를 int 로 바꾸거나, 형 변환을 하라고 나온다.
		
		System.out.println(ch);
	}
}
