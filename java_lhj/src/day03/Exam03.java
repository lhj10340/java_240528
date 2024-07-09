package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {

		// 변수를 추가하여 뒤쪽에 있는 코드를 간소화하는 연습이 필요. (밑에 있는 sum과 boolean은 강사님꺼 보고 수정한 것.)
		// 잘 풀리면 문제가 없으나, 잘 풀리지 않을 경우에는 무엇을 해야하는지 주석으로 적어놓고 코딩을 해보자.
		
		Scanner scan = new Scanner(System.in);
		
		String str1 = "예시1";
		System.out.print(str1);
		System.out.print('\n');
		
		System.out.print("과목1 성적 입력 : ");
		int score1 = scan.nextInt();
		
		System.out.print("과목2 성적 입력 : ");
		int score2 = scan.nextInt();
		
		int sum = score1 + score2;
		double avg = (sum)/(double)2;
		boolean isFail = (score1<40) || (score2<40);
		
		String result = avg>=60 && !isFail ? " 합격 " : " 불합격 ";
		System.out.println("결과 :" + result);
	}

}
