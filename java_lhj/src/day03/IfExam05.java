package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		// 정수를 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성.
		// 2가지 방법으로 해주셨다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		// 1번.
		// 6의 배수를 먼저 넣어주어야 한다, 순서가 바뀌면 결과가 바뀐다. (간결하지만 ..)
		// 6으로 나눴을 때, 0 / 2로 나눴을 때, 0 / 3으로 나눴을 때, 0 / 으로 코딩해야한다.
		
		// 내가 한 방법은 어느 방식인지 질문해보자. (2번 방식으로 확인했다.)
		
		if(num%6==0) { System.out.println(num + "은(는) 6의 배수입니다.");
		}
		else if(num%6==3) { System.out.println(num + "은(는) 3의 배수입니다.");
		}
		else if(num%6==2||num%6==4) { System.out.println(num + "은(는) 2의 배수입니다.");
		}
		else { System.out.println(num + "은(는) 2,3,6의 배수가 아닙니다.");
		}
				
	}
	
	// num 가 2의 배수이고 3의 배수가 아니면 2의 배수라고 출력하고
	// 아니면 num 가 3의 배수이고 2의 배수가 아니면 3의 배수라고 출력하고
	// 아니면 num 가 6의 배수이면 6의 배수라고 출력하고
	// 아니면 2,3,6의 배수가 아닙니다 라고 출력한다.
	// 이건 순서와 상관없이 실행이 된다.
	
	// 2번.
	
	
	
}
