package Day03_study;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		/* day03 패키지에 Exam03 클래스를 생성하세요.
		 * 2개의 과목 성적을 입력받아 평균 60점이 넘고 모든 과목이 과락(40점미만)이 없으면 합격, 아니면 불합격을 출력하는 코드를 작성하세요.
		 * (산술연산자(+), 비교연산자, 논리연산자, 조건연산자)
		 * 
		 * 예시1
		 * 과목1 성적 입력 : 100
		 * 과목2 성적 입력 : 35
		 * 결과 : 불합격
		 * 
		 * */
		
		// 2과목 성적을 입력하기 위하여 변수 2개 선언 및 입력 코딩.
		Scanner scan = new Scanner(System.in);
		
		int score1, score2;
		
		System.out.println("과목1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.println("과목2 성적 입력 : ");
		score2 = scan.nextInt();
		
		// 평균을 구하기 위해, 합계 및 평균의 변수 선언. 
		int sum = score1 + score2;
		double avg = sum / (double)2;
		
		// 합격/불합격 여부를 확인하기 위하여 조건을 확인했을 때, 모든 조건을 만족한다는 내용이 필요하여 논리연산자 && 를 사용하여 조건연산자 작성.
		String PF = ((avg > 60) && (score1 >= 40) && (score2 >= 40)) ? "합격" : "불합격";
		
		// 출력.
		System.out.println("시험 합격 여부 : " + PF);
		
	}

}
