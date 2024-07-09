package day02;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("한 글자를 입력하세요 : ");
		char chr1 = scan.next().charAt(0);
		System.out.println(chr1);
		
		System.out.print("한 글자를 입력하세요 : ");
		char chr2 = scan.next().charAt(0);
		System.out.println(chr2);
		
		System.out.print('\n');
		
		System.out.println("" + chr1 + chr2);
		
	}

}
