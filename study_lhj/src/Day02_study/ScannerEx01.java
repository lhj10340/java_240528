package Day02_study;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// 콘솔창에서 원하는 값을 읽어와서 변수에 저장하는 예제.
		
		Scanner scan = new Scanner(System.in);
		
		/* println (값) : 값을 출력하고 자동으로 줄바꿈을 실행한다.
		 * print (값) : 값을 출력한다.
		 * */
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println(num);
		
		System.out.print("실수를 입력하세요 : ");
		double num1 = scan.nextDouble();
		System.out.println(num1);
		
		// day07.ScannerEx01 예제 및 학습동영상 참조.
		
		System.out.print("문자열(단어)를 입력하세요 : ");
		String str = scan.next(); // 콘솔에서 공백(엔터, 스페이스 등) 전까지 문자열을 가져온다.
		System.out.println("단어 : " + str);
		
		scan.nextLine(); // 공백 삭제용으로 적는 것.
		System.out.print("문자열(단어)를 입력하세요 : ");
		String str1 = scan.nextLine(); //
		System.out.println("단어 : " + str1);
		
		System.out.println("문자를 입력하세요 : ");
		char chr = scan.next().charAt(0);
		System.out.println(chr);
		
	}

}
