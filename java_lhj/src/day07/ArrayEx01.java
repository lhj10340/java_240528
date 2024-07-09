package day07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 3명의 학생의 국어, 영어, 수학 성적을 입력받고
		 * 각 학생의 평균을 구하는 코드를 작성하세요.
		 * 학생1의 성적을 입력하세요. (국어,영어,수학 순) :
		 * 학생2의 성적을 입력하세요. (국어,영어,수학 순) :
		 * 학생3의 성적을 입력하세요. (국어,영어,수학 순) :
		 * 학생1 평균 :
		 * 학생2 평균 :
		 * 학생3 평균 :
		 * */

		// 변수 및 배열 선언

		int [] kor, eng, math;
		int studentCount = 3;
		kor = new int[studentCount];
		eng = new int[studentCount];
		math = new int[studentCount];

		Scanner scan = new Scanner(System.in);


		// 반복문을 이용하여 학생 성적을 입력
		// i는 0부터 3보다 작을 때까지 1씩 증가
		for ( int i = 0; i < studentCount; i++ ) {
			// 학생(i+1) 안내 문구 출력.
			System.out.print("학생" + (i+1) + "의 성적을 입력하세요. (국어,영어,수학 순) : ");
			// 성적 입력 (국어, 영어, 수학 순서) 
			// => 그래서 배열에 저장. (성적 모두 입력받고 진행해야 한다.)
			kor[i] = scan.nextInt();
			eng[i] = scan.nextInt();
			math[i] = scan.nextInt();
		}
		// 평균 구하여 출력.
		int sum;
		double avg;

		// 반복문을 바로 만들어내지 못한다면, 되는 방법으로 해서 규칙을 찾아보자. 그 뒤 반복문으로 변경을 해보자.

		for(int i = 0; i < studentCount ; i++) {
			sum = kor[i] + eng[i] + math[i];
			avg = sum/3.0;
			System.out.println("학생" + (i+1) + "의 평균 : " + avg);
		}
		/* 각 과목의 평균을 구하는 코드를 작성하세요.
		 * 국어 평균 :
		 * 영어 평균 :
		 * 수학 평균 :
		 * */

		// 반복문 작성 이전에 sum 의 초기화가 필요하다. ( 각 평균마다 ... )
		
		sum = 0;
		
		
		for(int i = 0; i < studentCount; i++ ) {
			sum += kor[i];
		}
		avg = sum/3.0;
		System.out.println("국어 평균 : " + avg);
		
		sum = 0;
		
		for(int i = 0; i < studentCount; i++ ) {
			sum += eng[i];
		}
		avg = sum/3.0;
		System.out.println("영어 평균 : " + avg);
		
		sum = 0;
		
		for(int i = 0; i < studentCount; i++ ) {
			sum += math[i];
		}
		avg = sum/3.0;
		System.out.println("수학 평균 : " + avg);
		
	}

}

