package day24;

public class Ex01 {

	public static void main(String[] args) {
		
		int num1 = 4;
		double num2 = num1;
		
		int num3 = (int)num2;
		
		/* 에러 발생
		 * 원인 : 실수를 정수로 자동 자료형변환 하려했기 때문.
		 * 해결 방법 : 명시적 형변환을 하거나, 실수형 변수로 저장.
		 * */
	}

}
