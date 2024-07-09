package day08;

public class ClassEx01 {

	public static void main(String[] args) {

		int result;
		int num1 = 1, num2 = 2, num3 = 3;
		
		result = sum(num1, num2);
		result = sum(num3,result);
		System.out.println(result); // 좋은 메서드는 재사용이 가능한 메서드.
		
		sum2(num1,num2); // 이 방식은 딱 두 수의 합만 구할 수 있따.
		
	}
	/** 두 정수의 합을 구하는 메서드 (아래 3개의 사항을 항상 정리해주는 것이 좋다.)
	 * 매개변수 : 두 개의 정수. => int num1, int num2
	 * 리턴타입 : 두 정수의 합. => 정수 => int
	 * 메서드명 : sum
	 * */
	public static int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	/** 두 정수의 합의 구하는 메서드
	 * 매개변수 : 두 정수 = > int num1, int num2
	 * 리턴타입 : 없다, 콘솔에 찍으면 된다. => void
	 * 메서드명 : sum2
	 * */

	public static void sum2(int num1, int num2) {
		int sum2 = num1 + num2;
		System.out.println(sum2);
	}
}

// 바깥에 만들어야 한다, 일단은.

// 학생 클래스
class Student1 {
	// 이름, 학번, 학기 사는 곳, 전공
	String name, num, address, major;
	int semester;
}