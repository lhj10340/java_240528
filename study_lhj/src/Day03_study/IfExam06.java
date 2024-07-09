package Day03_study;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		// 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적 입력 : ");
		
		int score = scan.nextInt();
		
		if(score > 100 || score < 0) {
			System.out.println("점수를 잘못 입력하였습니다.");
		}
		else if (score >= 90) {
			System.out.println("A학점");
		}
		else if (score >= 80) {
			System.out.println("B학점");
		}
		else if (score >= 70) {
			System.out.println("C학점");
		}
		else if (score >= 60) {
			System.out.println("D학점");
		}
		else {
			System.out.println("F학점");
		}
	}

}
