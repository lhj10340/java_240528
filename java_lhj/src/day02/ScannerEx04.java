package day02;

import java.util.Scanner;

public class ScannerEx04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("사는 곳(시)를 적어주세요 : ");
		String str1 = scan.next();
		System.out.println(str1);
		
		System.out.print("사는 곳(구)를 적어주세요 : ");
		String str2 = scan.next();
		System.out.println(str2);
		
		System.out.print('\n');
		
		System.out.print(str1 + " " + str2);
	}

}
