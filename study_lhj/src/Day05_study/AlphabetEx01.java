package Day05_study;

public class AlphabetEx01 {

	public static void main(String[] args) {
	
	// 해설을 보고 했다, 다시 해보자.
		
	/* 반복횟수 : a 에서 z 까지 1씩 증가
	 * 규칙성 : 더해줄 때마다 1번씩 출력
	 * 반복문 종료 후 : 없음.
	 * */
	
	for( int i = 0; i <= 26; i++) {
		for( int j = 0; j < i; j++ ) {
			System.out.print((char)('a'+ j));
		}
		System.out.println();
	}
	
	}

}

/*  
 * 	a 											
	ab							
	abc							
	abcd
	.
	.
	.
	.
	abcdefghijklmnopqrstu
	abcdefghijklmnopqrstuv
	abcdefghijklmnopqrstuvw
	abcdefghijklmnopqrstuvwx
	abcdefghijklmnopqrstuvwxy
	abcdefghijklmnopqrstuvwxyz
	
	콘솔에 해당 모양이 출력되도록 코드를 작성
	
	a += i
	
 * */