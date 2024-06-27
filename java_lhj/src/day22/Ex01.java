package day22;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01 {

	public static void main(String[] args) {
		
		/* 콘솔에서 한 문장(영어)을 입력하고 // 한 문장에 몇 개의 단어로 구성되어 있는지 확인하는 코드를 작성하세요.
		 * 
		 * Hi My name is Hong Hi
		 * 
		 * */
		
		// 입력
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("영어 문장 입력 : ");
		
		String str = scan.nextLine();
		
		// 구분 후, 개수 출력 ( 구분 기준? 구분하는 코드? ) // 스트링 클래스의 split 기능을 이용, day12 String Ex01 참고.
		
		String [] words = str.split(" ");
		System.out.println("단어의 개수 : " + words.length);
		
		StringTokenizer st = new StringTokenizer(str, " ");
		int count = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		System.out.println("단어의 개수 : " + count);
	}

}
