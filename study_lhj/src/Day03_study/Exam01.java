package Day03_study;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		/* day03 패키지를 생성하세요.
		 * day03 패키지에 Exam01 클래스를 생성하세요.
		 * 
		 * 성적을 입력받아 입력받은 성적이 60점이상이면 Pass, 아니면 Fail이 출력되도록 코드를 작성하세요.
		 * 
		 * 예시1
		 * 성적 입력 : 65
		 * 65점은 Pass
		 * 
		 * 예시2
		 * 성적 입력 : 45
		 * 45점은 Fail
		 * 
		 * */
		
		System.out.print("성적 입력 : ");
		
		Scanner scan = new Scanner(System.in);
		
		// 변수명은 의미가 잘 드러나게 작성해야한다.
		// 학생 점수 구하는 예제이니, score 로 적자.
		// num 으로 적었었다.
		
		int score = scan.nextInt();  
		
		String str = score >= 60 ? (score + " 점은 Pass") : (score + " 점은 Fail"); // 조건 연산자로 하는 방법.

		System.out.println(str);
		
		// if else 문으로 하는 방법 (조건문)
		
		/* if(score >= 60) {
			System.out.println(score + "점은 Pass");
		}
		else {
			System.out.println(score + "점은 Fail");
		} */
		
		
	}

}
