package Day04_study;

public class WhileEx03 {

	public static void main(String[] args) {

		// 구구단 2단을 출력하는 반복문.

		int i = 1;
		int num = 2;
		int res;

			while(i <= 9) {
				res = num * i;
				System.out.println("" + num + " * " + i + " = " + res); i++;
			}

	}

}
