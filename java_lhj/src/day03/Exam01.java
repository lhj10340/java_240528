package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String str3 = "예시1";
		System.out.print(str3);
		
		System.out.print('\n');
		
		System.out.print("성적 입력 : ");
		int score1 = scan.nextInt();
		String str1 = (score1>=60) ? "Pass" : "Fail";
		System.out.println(score1 + "점은 " + str1);
		
		System.out.print('\n');
		
		String str4 = "예시2";
		System.out.print(str4);
		
		System.out.print('\n');
		
		System.out.print("성적 입력 : ");
		int score2 = scan.nextInt();
		String str2 = (score2>=60) ? "Pass" : "Fail";
		System.out.println(score2 + "점은 " + str2);
	}

}
