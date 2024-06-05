package Day02_study;

public class StringEx02 {

	public static void main(String[] args) {
		String str1 = 1 + "안녕";// 기본형 + 문자열
		String str2 = "안녕" + 2;// 문자열 + 기본형
		
			System.out.println(str1);
			System.out.println(str2);
			
		String str3 = 1 + 2 + "3"; // 순서대로 1 + 2 후, 기본형 3과 문자열 3이 더해져서 문자열 33.
		String str4 = "1" + 2 + 3; // 순서대로 문자열 1과 기본형 2가 더해져서 문자열 12, 그 후 기본형 3을 더하여 문자열 123.
				
			System.out.println(str3);
			System.out.println(str4);
		
		//
		//
	}

}
