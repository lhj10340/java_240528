package day03;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {
		// 한번에 여러 값을 받는 Scanner 예제.
		// 학생 3명의 성적을 한 번에 입력받는 예제.
		// 입력할 때, 한 칸씩 띄우고 입력하면 된다.
		// 물론 엔터도 가능하다.
		
		// 100 공백 30 공백 50 엔터
		
		// 첫번째 scan 으로 100 을 가져감
		// 두번째 scan 으로 nextInt 라서 공백을 버리고 30을 가져간다.
		// 세번째 scan 으로 nextInt 라서 공백을 버리고 50을 가져간다.
		
		int score1, score2, score3;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("세 학생의 성적을 입력하세요 : ");
		score1 = scan.nextInt();
		score2 = scan.nextInt();
		score3 = scan.nextInt();
		
		System.out.println("세 학생의 성적은 " + score1 + "," + score2 + "," + score3);
	}

}
