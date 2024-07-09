package Day02_study;

public class StringEx01 {

	public static void main(String[] args) {
		
		String str1 = null;
		String str2 = "안녕하세요.";
		String str3 = "null";
		String str4 = ""; // 문자열은 0자 이상.
		
		System.out.println(str1); // null 값이 출력된다.
		System.out.println(str2); // 안녕하세요, 가 출력된다.
		System.out.println(str3); // 문자열 null 이 출력된다, str1 과 혼동이 있을 수 있어서 쓰지 않는다.
		System.out.println(str4); // 빈 문자열이 출력되어, 겉으로 보기엔 아무것도 없다.
		
	}

}
