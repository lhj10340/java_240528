package day06;

public class ArrayEx05 {

	public static void main(String[] args) {
		// 100 이하의 소수를 찾는 예제 : 에라토스테네스의 체
		//  1(x) 2 3 4(x) 5 6(x) 7 8(x) 9(x) 10(x)
		
		int [] arr = new int[101]; // X : 1 , O : 0
		arr[1] = 1;
		
		// 2부터 에라토스테네스의 체를 이용하여 배열에 x 체크.
		
		/* 반복횟수 : i는 2부터 100까지 1씩 증가. => i는 2부터 101보다 작을 때까지 1씩 증가.
		 * 규칙성 : i번지에 있는 값이 1이면 건너뛰고 아니면 반복문 실시.
		 * 반복문 종료 후 : 없음.
		 */
		/*
		 * 		반복횟수 : j는 (2*i)부터 100까지 i씩 증가.
		 * 		규칙성 : j번지에 있는 값을 1로 변경.
		 * 		반복문 종료 후 : 없음.
		 * */
		
		for( int i = 2 ; i < arr.length ; i++ ) {
			// 이미 x 가 되어있다면 다음 숫자로
			if(arr[i] == 1) {
				continue;
				}
			
			/*
			 * 		반복횟수 : j는 (2*i)부터 100까지 i씩 증가.
			 * 		규칙성 : j번지에 있는 값을 1로 변경.
			 * 		반복문 종료 후 : 없음.
			 * */
			
				for ( int j = (2*i); j < arr.length ; j += i ) {
					arr[j] = 1;
				}
				
			}
		
		// 2부터 100까지 x체크가 되지 않은 수 (값이 0인 수)를 출력.
		
		for(int i = 2; i < arr.length; i++) {
			if (arr[i] == 0) {
				System.out.print(i + " ");
				
			}
			
		}
		
		
		
		
		
	}

}
