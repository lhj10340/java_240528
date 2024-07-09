package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {
		// 나이를 입력하여 19세이상이면 성인, 미만이면 미성년자가 출력되도록 코딩.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age = scan.nextInt();
		
		if(age>=19) {System.out.println("성인");
	}
		else {System.out.println("미성년자");
		
		}

}
}
