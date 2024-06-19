package Day03_study;

public class SwitchEx01 {

	public static void main(String[] args) {
		
		// switch 문을 이용한 홀,짝 예제
		
		/* switch(변수){
		 * case 값1:		// if(변수 == 값1) : else if 문의 이 부분과 동일하다.
		 * 		실행문;
		 * 		break;
		 * case 값2:		// else if(변수 == 값2) : else if 문의 이 부분과 동일하다.
		 * 		실행문;
		 * 		break;
		 * default:		// else : else if 문의 이 부분과 동일하다.
		 * 		실행문;
		 * }
		 * 
		 * */
		
		int num = 3;
		
		// 내 풀이 : 굳이 default 를 하나 더 써버렸다. 둘 중 하나로 판별하는거니까 굳이 내 풀이처럼 3가지를 쓸 필요가 없다.
		
		/* switch(num % 2) {
		case 0:
			System.out.println("짝수입니다.");
			break;
		case 1:
			System.out.println("홀수입니다.");
			break;
		default:
			break;
		} */
		
		switch(num % 2) {
		case 0:
			System.out.println(num + "는 짝수");
			break;
		default:
			System.out.println(num + "는 홀수");
		}
		
	}

}
