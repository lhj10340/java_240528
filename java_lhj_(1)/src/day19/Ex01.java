package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		/* 리스트에 문자열을 5개 입력받아 저장하는 예제.
		 * */
		
		// 스캐너 생성.
		Scanner scan = new Scanner(System.in);
		// 리스트 생성.
		List<String> list = new ArrayList<String>();
		// 반복문을 이용하여 문자열을 입력받아 리스트에 저장.
		for( int i = 0; i < 5 ; i++ ) {
			// 5번 반복
			// 콘솔에서 문자열을 입력받아 문자열 변수에 저장
			System.out.println("문자열 입력 : ");
			String tmp = scan.next();
			// 문자열 변수를 리스트에 추가
			list.add(tmp);
		}
		// 저장된 문자열을 출력.
		System.out.println(list);
		
		/* 문자열A 를 입력받아 리스트에 A 를 포함하는 문자열들을 출력하는 예제. 
		 * */
		
		// 문자열 A를 입력받아 변수에 저장.
		System.out.println("검색 문자열 입력 : ");
		String search = scan.next();
		// 반복문을 이용하여 전체 탐색 : 향상된 for문
		for ( String tmp : list ) {
			if(tmp.contains(search)) {
				System.out.println(tmp);
			}
		}
			// 리스트에서 꺼낸 문자열에 문자열 A가 포함되어 있으면 문자열을 출력.
		
	}

}
