package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String str1 = "예시1";
		System.out.println(str1);
		
		System.out.print("학생 성적 입력 : ");
		
		int score1 = scan.nextInt();
				
		int score2 = scan.nextInt();
		
		int score3 = scan.nextInt();
		
		int sum = score1 + score2 + score3;
		double avg = (sum)/(double)3;
		
		System.out.println("총점 : " + sum + "점" + " " + "평균 : " + avg);
	}

}
