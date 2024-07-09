package day02;

public class StringEx01 {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = "안녕하세요.";
		String str3 = "null"; // 이런 방식은 피해주는 것이 좋다. str1 과 혼동이 올 수 있기 때문.
		String str4 = "";// 문자열은 0자 이상이면 된다.
		
		System.out.println(str1); // 이 때 출력되는 null 은 null 이라는 문자열이 저장된게 아니라 null 값이 있다는 의미.
		System.out.println(str2);
		System.out.println(str4);
		System.out.println(str3); // 이 때 출력되는 null 은 null 이라는 문자열.
	}

}
