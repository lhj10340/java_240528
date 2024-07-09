package Day05_study;

public class ArrayEx03 {

	public static void main(String[] args) {
		
		/* 다시 풀어보자, 반복에 주의 */
		/* 1 ~ 10 랜덤한 수 3개를 저장하고 출력하는 코드를 작성하세요. */
		
		int [] arr = new int [3];
		
		int min = 1, max = 10;
		
		for ( int i = 0; i < 3 ; i++ ) {
		
		int random = (int)(Math.random()*(max - min + 1) + min);
		
		arr[i] = random;
		
		}

		for ( int i = 0; i <arr.length ; i++ ) {
			System.out.println(arr[i]);
		}
	}

}
