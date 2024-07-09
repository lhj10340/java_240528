package Day05_study;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		
		/* 학생 3명의 성적을 저장하는 배열을 생성하고,
		 * 학생 3명의 성적을 콘솔을 통해 입력받고, 출력하는 코드를 작성하세요.
		 * 입력받은 성적의 평균을 구하는 코드를 작성하세요.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int arr [] = new int [3];
		
		System.out.print("성적1 입력 : ");
		int score1 = scan.nextInt();
		System.out.print("성적2 입력 : ");
		int score2 = scan.nextInt();
		System.out.print("성적3 입력 : ");
		int score3 = scan.nextInt();
		
		arr[0] = score1;
		arr[1] = score2;
		arr[2] = score3;
		
		System.out.println();
		
		int sum = 0;
		
		for ( int i = 0; i < 3; i++ ) {
			sum += arr[i];
		}
		
		System.out.println("3명의 성적 합 : " + sum);
		
		double avg = sum / (double) arr.length;
		
		System.out.println("3명의 성적 평균 : " + avg);
		
	}

}
