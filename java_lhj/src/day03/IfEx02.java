package day03;

public class IfEx02 {

	public static void main(String[] args) {
		// if else문을 이용하여 홀짝 판별 예제
		int num = 4;
		// num가 홀수이면 홀수라고 출력
		if(num%2==1) {System.out.println("홀수");}
		// 아니면 짝수라고 출력
		else {
			  System.out.println("짝수");
		}
	}

}

// else는 현위치에서 (if else와 같이) 연결된 조건문들이 모두 거짓이면