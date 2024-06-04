package day06;

public class ArrayEx03 {

	public static void main(String[] args) {
		/* 2단의 결과 값인 2,4,6,8,10 ... 18 을 배열에 저장하고
		 * 배열에 있는 값을 이용하여 구구단 2단을 출력하는 예제.
		 * */
		
		int arr [] = new int [9];
		
		// 배열에 2부터 18까지 저장하는 작업.
		
		int num = 2;
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = num * (i+1);
		
			// 배열에 있는 값을 이용하여 2단을 출력.
			
			System.out.println(num + " X " + (i+1) + " = " + arr[i]);
			
		}
		
		System.out.println();
		
		// 10개 짜리 배열을 만들어서 0번지를 사용하지 않고 1번지부터 사용, 이 방법은 번지 이용 시 코드가 간결하지만 4바이트 낭비.
		
		int arr1[] = new int[10];
		for(int i = 1; i < arr1.length; i++) {
			arr1[i] = 2 * i;
			}
		
		for(int i = 1; i < arr1.length; i++) {
			System.out.println(num + " X " + i + " = " + arr1[i]);
			
		}
		
	}
}

