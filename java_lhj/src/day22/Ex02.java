package day22;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		/* 콘솔에서 정수로 이루어진 문자열을 입력받아, 각 정수들의 합을 구하는 코드를 작성하세요
		 * 
		 * ex) 1 23 45 3 9 7 5 = 103
		 * 
		 * */

		Scanner scan = new Scanner(System.in);

		System.out.println("입력 : ");

		String str = scan.nextLine(); // 공백도 모두 받아야 한다.
		
		int sum = convertAndSum(str);
		
		System.out.println("합 : " + sum);

		/* 문자열 -> 정수
		 * int num = Integer.parseInt(str);
		   System.out.println(num); */

		/* < 강사님이 적어주신 코드 >
		 * for ( String num : str1 ) {
		 * int number = Integer.parseInt(num);
		 * sum += number;
		 * */

		/* 위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때, 필요하다고 생각하는 코드를 메소드로 만들어보세요.
		 * */

	}

	/** 기능 : 주어진 문자열에 있는 정수들을 더해서 더한 결과를 반환하는 메소드
	 * @param str 정수들이 있는 문자열
	 * @return 문자열에 있는 정수들의 합
	 * */

	public static int convertAndSum (String str) {

		String [] str1 = str.split(" "); // 공백을 기준으로 나눈다는 뜻, 여기에 str 을 다시 넣어버려서 되지 않았던 것.

		int i = 0, sum = 0;

		// 반복문

		for ( i = 0; i < str1.length; i++) {

			// 문자열을 정수로 변환
			int num = Integer.parseInt(str1[i]);

			// 누적
			sum += num;

		}
		
		return sum;
	}

}
