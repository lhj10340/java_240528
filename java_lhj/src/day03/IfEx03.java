package day03;

public class IfEx03 {

	public static void main(String[] args) {
		// else if문 예제.
		
		int num = -1;
		
		// num가 0이면 0이라고 출력하고
		if(num==0) {System.out.println("0");
		
		}
		// num가 0이 아니고 양수이면 양수라고 출력하고
		else if(num>0) {System.out.println("양수");
		
		}
		// num가 0과 양수가 아니면 음수라고 출력하는 코드를 작성하세요.
		else {System.out.println("음수");
		
		}
	}

}
