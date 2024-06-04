package day06;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		
		// 4과목의 성적을 입력받아 배열에 저장하고, 과락이 없고 평균이 평균이 60점이 넘으면 Pass, 아니면 Fail 이라고 출력하세요.
		
		// 어떻게 작성을 할 것인지 순서를 정하고 작성할 것.
		
		/* 4개짜리 배열 생성.
		 * 성적을 4개 입력.
		 * 입력받은 성적의 총합을 계산.
		 * 		반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 		실행문 : 배열에서 가져온 값을 sum에 누적
		 * 총합을 이용하여 평균을 계산.
		 * 과락여부 확인하여 변수에 저장.
		 * 		반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 		실행문 : 배열에서 가져온 값이 40보다 작으면 과락 변수를 true로 변경.
		 * 		반복문 종료 후 : 없음.
		 * 과락이 아니고 평균이 60점 이상이면 Pass
		 * 아니면 Fail
		 * */
		
		// 4개짜리 배열 생성.
		int score [] = new int [4];
		
		// 성적을 4개 입력.
		
		/* 반복횟수 : i는 0부터 score.length보다 작을 때까지 1씩 증가.
		 * 실행문 : Scanner를 이용하여 score 배열 i번지에 값을 입력해서 저장.
		 * 반복문 종료 후 : 없음.
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 입력 : ");
		
		// 입력받은 성적의 총합 계산.
		
		for(int i = 0; i < score.length; i++) {
			score[i] = scan.nextInt();
			System.out.print("과목"+(i+1)+" :" + score[i] + " ");
		}
		
		int sum = 0;
		for(int tmp : score) {
			sum += tmp;
		}
		
		// 총합을 이용하여 평균을 계산.
		double avg = sum / (double)score.length;
		
		/* 과락여부 확인하여 변수에 저장.
		 * 		반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 		실행문 : 배열에서 가져온 값이 40보다 작으면 과락 변수를 true로 변경.
		 * 		반복문 종료 후 : 없음.
		 */
		
		boolean isFail = false;
		
		for(int tmp : score) { 
			if(tmp < 40) { 
				isFail = true;
				break; // break 가 없어도 결과는 같지만, 조금이라도 덜 비교하기 위해 쓰는 것이 좋다.
			}
		}
		
		// 과락이 아니고 평균이 60점 이상이면 Pass, 아니면 Fail.
		
		if((!isFail) && (avg>=60)) {
			System.out.println("Pass");
			
		}
		else { System.out.println("Fail");
		
		}
		
			
		}
		}
		
		

