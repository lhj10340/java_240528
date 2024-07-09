package Day03_study;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {
		
		// 한번에 여러 값을 받는 Scanner 예제.
		// 학생 3명의 성적을 한 번에 입력받는 예제.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		
		
		int score1 = scan.nextInt();
		System.out.print(score1 + " ");
		int score2 = scan.nextInt();
		System.out.print(score2 + " ");
		int score3 = scan.nextInt();
		System.out.println(score3);
		
		System.out.println("-----");
		
		System.out.println("세 학생의 성적은 " + score1 + "," + score2 + "," + score3);
		
		
		
	}

}
