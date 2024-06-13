package Day02_study;

public class LogicalOperatorEx01 {

	public static void main(String[] args) {
		// 논리 연산자 예제
		// 성적이 B학점인지 확인하는 예제
		
		int score = 75;
		boolean isB;
		
		/* score 가 80점 이상이고, score 가 90점 미만이다.
		 * score 가 80보다 크거나 같고, score 가 90보다 작다.
		 * score 가 80보다 크거나 같다 && score 가 90보다 작다.
		 * (score >= 80) && (score < 90)
		 * */
		
		/* && 연산자 진리표
		 * A   B   A&&B
		 * T   T    T
		 * T   F    F
		 * F   T    F
		 * F   F    F
		 * */
		
		// 둘 중에 하나라도 F 가 있으면 && 의 결과는 F
		
		isB = score >= 80 && score < 90;
		System.out.println(score + "점은 B학점인가요? " + isB);
		
		/* || 연산자 진리표
		 * A   B   A||B
		 * T   T    T
		 * T   F    T
		 * F   T    T
		 * F   F    F
		 * */
		
		// 둘 중에 하나라도 T 가 있으면 || 의 결과는 T
		
		/* 정보처리 기사 필기 시험을 보는데 4과목 중 하나라도 과락이 있으면 탈락이다.
		   과락은 과목 점수가 40미만인 경우이다.*/
		
		int sub1 = 100, sub2 = 30, sub3 = 70, sub4 = 80;
		
		boolean isFail;
		
		isFail = sub1 < 40 || sub2 < 40 || sub3 < 40 || sub4 < 40 ;
		
		System.out.println("과락인가요? " + isFail);
		
		/* ! 연산자 진리표
		 * A   !A
		 * T    F
		 * F    T
		 * */
		
		/* 19세 이상은 성인이다.
		 * 나이가 주어지면 미성년자인지 확인하세요. 
		 * => 나이가 19세 이상이 아니다
		 * => !(나이가 19세 이상)
		 * => !(나이가 19보다 크거나 같다)
		 * => !(age >= 19)
		 * */
		int age = 20;
		boolean isMinor = !(age >= 19);
		System.out.println("미성년자입니까? " + isMinor);
		
	}

}
