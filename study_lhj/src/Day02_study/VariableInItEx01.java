package Day02_study;

public class VariableInItEx01 {

	public static void main(String[] args) {

		int num; // The local variable num may not have been initialized 발생.
		// System.out.println(num); num 을 초기화하지 않아서 발생하는 에러.
		
		num = 0;
		System.out.println(num); // num 을 0으로 초기화해서 에러가 발생하지 않았다.
		
	}

}
