package day12;

public class MathEx02 {

	public static void main(String[] args) {
		/* 3.14 를 소수점 2번째 자리에서 올림하는 코드를 작성하세요.
		 * 3.14 를 31.4 로 만들고 올린 후, 32 를 3.2 로 만들면 된다.
		 * */
	
		double num = 3.14;
		num = num * 10; // num *= 10
		num = Math.ceil(num);
		num = num / 10; // num /= 10
		
		System.out.println(num);
		
		// System.out.println(( Math.ceil ( num * 10 ) ) / ( double ) 10); // 내가 한 것.
		
	}

}
