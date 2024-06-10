package day09;

public class MethodOverloadingEx01 {

	public static void main(String[] args) {
		
		/* 메소드 오버로딩 조건
		 * 1. 매개변수의 개수가 다르다.
		 * 2. 매개변수의 타입이 다르다.
		 * */
		
		
	}

	/* 메소드 오버로딩 예제 */
	
	public static int sum (int num1, int num2) {
	return num1 + num2;
	}
	
	// double sum ( double num1, double num2 ) : o / double 이라서 가능하다.
	
	public static double sum (double num1, double num2) {
		return num1 + num2;
		}
	
	// double sum ( int num1, int num2 ) : x / int 라서 불가능하다. ( 중복 에러 발생 )
	
	/* public static double sum (int num1, int num2) {
		return num1 + num2;
		}
		
		*/
	
	// int sum ( int num1, int num2, int num3 ) : o / 갯수가 다르다.
	
	public static int sum (int num1, int num2, int num3) {
		return num1 + num2 + num3;
		}
	
	// int sum ( int a, int b ) : x / int 라서 불가능하다. ( 중복 에러 발생 )
	
	/* public static int sum (int a, int b) {
	return a + b;
	}
	
	*/
	
}
