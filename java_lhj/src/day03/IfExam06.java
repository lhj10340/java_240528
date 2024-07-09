package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		// 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적 입력 : ");
		int num = scan.nextInt();
		
		if(num >= 90 && num <= 100) { System.out.println(num + "점은 A학점입니다.");
		}
		else if(num >= 80 && num < 90) { System.out.println(num + "점은 B학점입니다.");
		}
		else if(num >= 70 && num < 80) { System.out.println(num + "점은 C학점입니다.");
		}
		else if(num >= 60 && num < 70) { System.out.println(num + "점은 D학점입니다.");
		}
		else if(num < 60 && num >= 0) { System.out.println(num + "점은 F학점입니다.");
		}
		else { System.out.println("잘못된 성적입니다.");
		}
	}

	/* 성적이 0보다 작거나 100보다 크면 잘못된 성적입니다라고 출력.
	 * 아니면 성적이 90점이상 A
	 * 아니면 성적이 80점이상 B
	 * 아니면 성적이 70점이상 C
	 * 아니면 성적이 60점이상 D
	 * 아니면 ... F
	 * 내가 한 방법의 거꾸로하면 된다. 코드가 더 간결해진다.
	 * 바르지 않은 점수를 거르고 시작하는 것.
	 * 순서를 잘 지켜야하는 코딩.
	 * */
	
}
