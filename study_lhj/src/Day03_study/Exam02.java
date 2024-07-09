package Day03_study;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		
		/*day03 패키지에 Exam02 클래스를 생성하세요.
		 * 
		 * 학생 3명의 성적을 입력받아 총점과 평균을 구하는 코드를 작성하세요.
		 * 
		 * 예시1
		 * 학생1 성적 입력 : 65
		 * 학생2 성적 입력 : 100
		 * 학생3 성적 입력 : 76
		 * 
		 * 총점 : 241점. 평균 : 80.3333333
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		// 학생 3명의 성적을 입력받기 위해 성적별 변수 선언 및 입력 코드 작성.
		int score1, score2, score3;
		
		System.out.print("학생1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.print("학생2 성적 입력 : ");
		score2 = scan.nextInt();
		System.out.print("학생3 성적 입력 : ");
		score3 = scan.nextInt();
		
		// 총점 및 평균 출력을 위한 각각의 변수 선언. 평균의 경우 소수점이 나와야하기 때문에 double 로 선언하고, 명시적 형변환도 진행.
		int sum = score1 + score2 + score3;
		double avg = sum / (double)3;
		
		System.out.println("총점 : " + sum + " " + "평균 : " + avg);
		
	}

}
