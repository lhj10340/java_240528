package day13;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* 다음과 같은 책 제목이 있을 때, 원하는 단어를 검색(입력)해서 해당 단어가 있는 책을 출력하는 코드를 작성하세요. */
		/* 일치하는 책이 없는 경우 일치하는 책이 없습니다라고 출력 */

		String [] books = {"자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C"};
		int i = 0;
		int count = 0;

		// 단어를 입력.
		Scanner scan = new Scanner(System.in);
		System.out.print("단어 입력 : ");
		String str = scan.next();
		// 배열 안에 입력한 단어를 포함하는 책이 있는지 없는지 확인.
		for ( ; i < 5 ; i++ ) {
			// 있다면 해당 책 이름 출력.
			if( books[i].contains(str) ) {
				System.out.println( books[i] );
				count++;
			}
			// 없다면 '일치하는 책이 없습니다.' 출력.
		}
		if( count == 0 ) {
			System.out.println("일치하는 책이 없습니다.");
		}
	}

}

// if ( book.indexOf(search) >= 0 ) {
// System.out.println(book); 
// count++;}
