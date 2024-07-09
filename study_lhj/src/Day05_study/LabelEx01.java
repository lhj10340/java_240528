package Day05_study;

public class LabelEx01 {

	public static void main(String[] args) {
		
		int i, j;
		
		 for (i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++ ) {
				System.out.println(i * j + " ");
			}
		} 
		
		// 라벨 이름 A 를 지정한 후, break A; 를 이용하면 라벨 이름이 A 인 반복문을 빠져나갈 수 있다.
		// 이런 형태도 있다는 정도만 알아둘 것, 거의 안 쓴다.
		
		A : for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.println(i * j + " ");
				if ( j == 3 ) {
					break A;
				}
			}
			System.out.println();
		}
		
	}

}
