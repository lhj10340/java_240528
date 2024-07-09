package day09;

public class MethodOverloadingEx02 {

	public static void main(String[] args) {
		
		/* 대표적인 메서드 오버로딩이 적용된 메서드 */
		
		// println 에 마우스를 가져가보면 상세내용이 적혀있고, 각각의 매개변수가 다르다.
		// 이게 메소드 오버로딩이고, 이 기능이 없다면 각각 만들어줘야 한다.
		// 중요하다!
		
		System.out.println(1);		// 매개변수가 int
		System.out.println('a');	// 매개변수가 char
		System.out.println("abc");	// 매개변수가 String
		System.out.println(1.23);	// 매개변수가 double
		System.out.println(true);	// 매개변수가 boolean
		
	}

}
