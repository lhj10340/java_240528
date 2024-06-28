package Day05_study;

public class EnhancedForEx {

	public static void main(String[] args) {
		
		// 배열에 1,2,3,4,5를 저장한 후 향상된 for문을 이용하여 조회하는 예제.
		int [] arr = new int [] {1,2,3,4,5};
		
		// 향상된 for
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		
		System.out.println();
		
		// 일반 for
		for(int i = 0; i < arr.length ; i++) {
			int tmp = arr[i];
			System.out.print(tmp + " ");
		}
		
	}

}
