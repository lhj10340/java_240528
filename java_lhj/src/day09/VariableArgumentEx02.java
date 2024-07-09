package day09;

public class VariableArgumentEx02 {

	/* 가변 매개변수를 이용한 예제 */
	public static void main(String[] args) {
		
	}
	
	/** 기능 : 정수들의 합을 구하는 기능
	 *  매개변수 : 여러 개의 정수
	 *  리턴타입 : 정수
	 *  메서드명 : sum
	 * */

	// 가변 매개변수는 마지막 매개변수에 넣어야 한다, 중간에 넣을 수 없다.
	
	/*
	public static void test(int num, String ... strs, int a) {
	}
	*/
	
	// 이렇게 가변 매개변수를 마지막에 넣어야 사용할 수 있다.
	public static void test(int num, int a, String ... strs) {
		
	}
	
}
