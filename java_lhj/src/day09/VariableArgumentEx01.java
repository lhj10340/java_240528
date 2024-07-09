package day09;

public class VariableArgumentEx01 {

	/* 가변 매개변수를 이용하여 정수들의 합을 구하는 메서드 예제 */
	public static void main(String[] args) {
		
		System.out.println(sum1());
		System.out.println(sum1(1));
		System.out.println(sum1(1,2));
		System.out.println(sum1(1,2,3));
		
		// sum2 는 메서드에서 변수를 배열로 했기 때문에 위와는 다르게 입력해야한다.
		
		System.out.println(sum2(new int[0]));
		System.out.println(sum2(new int[] {1}));
		System.out.println(sum2(new int[] {1,2} ));
		System.out.println(sum2(new int[] {1,2,3}));
	}
	
	/** 기능 : 정수들의 합을 구하는 기능
	 *  매개변수 : 여러 개의 정수
	 *  리턴타입 : 정수
	 *  메서드명 : sum
	 * */
	
	// 가변 매개변수 이용
	public static int sum1(int ... nums) {
		if ( nums == null) {
			return 0;
		}
		int sum = 0;
		for (int tmp : nums) {
			sum += tmp;
		}
		return sum;
	}
	
	public static int sum2(int [] nums) {
		if ( nums == null) {
			return 0;
		}
		int sum = 0;
		for (int tmp : nums) {
			sum += tmp;
		}
		return sum;
	}
	
}
