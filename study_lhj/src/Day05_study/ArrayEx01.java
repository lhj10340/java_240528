package Day05_study;

public class ArrayEx01 {

	public static void main(String[] args) {
		
		// 5명의 학생 성적을 저장하기 위한 변수를 선언하자.
		// 지역변수는 자동으로 초기화되지 않는다.
		
		int score1, score2, score3, score4, score5;
		
		// 5명의 학생 성적을 저장할 수 있는 배열을 생성.
		// 배열은 자동으로 자료형에 맞는 초기화가 된다.
		// 배열은 참조형이다.
		
		int [] scores1 = new int [5];
		int scores2 [] = new int [5];
		
		// 5개짜리 배열을 만들어서 1,2,3,4,5 순서대로 초기화.
		
		int scores3 [] = new int [] {1,2,3,4,5};
		
		// scores1 배열 0번지에 1, 1번지에 2, 2번지에 3, 3번지에 4, 4번지에 5 저장.
		
		/* scores1[0] = 1
		 * scores1[1] = 2
		 * scores1[2] = 3
		 * scores1[3] = 4
		 * scores1[4] = 5
		 */
		
		//
		
		/* 반복 횟수 : i는 0부터 5보다 작을 때까지 1씩 증가. */
		
		for (int i = 0; i < 5; i++) {
			scores1[i] = i + 1;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(scores1[i]);
		}
		
	}

}
