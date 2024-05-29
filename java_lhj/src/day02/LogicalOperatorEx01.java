package day02;

public class LogicalOperatorEx01 {

	public static void main(String[] args) {
		// 논리 연산자 예제
		
		// 성적이 B학점인지 확인하는 예제
		int score = 95;
		boolean isB;
		/* score 가 80점 이상이고, score 가 90점 미만이다.
		 * score 가 80보다 크거나 같고, score 가 90보다 작다.
		 * score 가 80보다 크거나 같다 && score 가 90보다 작다.
		 * score >= 80 && score < 90;
		 */
		
		/* && 연산자 진리표
		 * A    B   A&&B
		 * T    T     T
		 * T    F     F
		 * F    F     F
		 * F    T     F
		 */
		
		isB = score >= 80 && score < 90;
		System.out.println(score + "점은 B학점인가요? " + isB);
		
		/* || 연산자 진리표
		 * A    B   A||B
		 * T    T     T
		 * T    F     T
		 * T    F     T
		 * F    T     T
		 */
		
		/* ! 연산자 진리표
		 * A   !A
		 * T    F
		 * F    T
		 */
		
		// 정보처리기사 필기시험을 보는데, 4과목 중 하나라도 과락이 있으면 탈락이다.
		// 과락은 과목 점수가 40점 미만인 경우이다.
		// 각 과목의 성적이 다음과 같을 때, 과락이 있는지 확인하는 코드를 작성하세요.
		
		int sub1 = 60, sub2 = 100, sub3 = 30, sub4 = 80;
		boolean isFail = sub1<40 || sub2<40 || sub3<40 || sub4<40;
		System.out.println("과락이 있습니까? "+ isFail);
		
		// 19세 이상은 성인이다.
		// 나이가 주어지면 미성년자인지 확인하세요.
		// 나이가 19세 이상이 아니다.
		// !(나이가 19세 이상이다.)
		
		int age = 20;
		boolean isAdult = age>=19;
		System.out.println("성인 입니까? " + isAdult);
		
		}

}
