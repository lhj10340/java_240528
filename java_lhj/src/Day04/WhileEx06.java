package Day04;

public class WhileEx06 {

	public static void main(String[] args) {
		/* 12의 약수를 출력하는 코드를 작성하세요.
		 * 
		 * 반복횟수 : i 는 1 ~ 12까지 1씩 증가
		 * 규칙성 : 12 를 i 로 나눈것 중 나머지 0인 것을 출력 ( i가 12의 약수일 때, i를 출력 )
		 * 반복문 종료 후 : 없음.
		 * 
		 * */
		
		int i = 1;
		int num = 12;
		System.out.print(num + "의 약수 : ");
		while(i <= num) {
			if(num % i == 0) {
				System.out.print(i + (i != num ? ", " : "\n"));
			}
			i++;
		}
	}

}
