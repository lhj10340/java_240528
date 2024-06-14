package day13;

public class ExceptionEx03 {

	public static void main(String[] args) {
		//finally 설명을 위한 예제.
		int num1 = 1, num2 = 2;

		try {
			System.out.println(num1 % num2);
		}
		catch(Exception e) {
			System.out.println("예외 발생");
		}
		System.out.println("프로그램을 종료합니다.");

		//

		try {
			System.out.println(num1 % num2);
		}
		catch(Exception e) {
			System.out.println("예외 발생");
		}
		finally {
			System.out.println("프로그램을 종료합니다.");
		}
		
		System.out.println("----------------------------------");
		test1();
		System.out.println("----------------------------------");
		test2();
		
	}
	// 당장의 결과는 동일하지만, 차이점이 있다. 그를 위해 메소드 제작.

	public static void test1 () {
		int num1 = 1, num2 = 0;
		
		try {
			System.out.println(num1 % num2);
		}
		catch(Exception e) {
			System.out.println("예외 발생");
			return;
		}
		System.out.println("프로그램을 종료합니다.");

	}
	
	public static void test2 () {
		int num1 = 1, num2 = 0;
		
		try {
			System.out.println(num1 % num2);
		}
		catch(Exception e) {
			System.out.println("예외 발생");
			return;
		}
		
		// 메소드에서 return 으로 빠져나가도 무조건 실행이 된다. ( try 또는 catch 에서 ... )
		
		finally {
			System.out.println("프로그램을 종료합니다.");
		}
	}
}
