package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* 전화번호를 5번 입력받아, 리스트에 저장하는 코드를 작성하세요. */

		Scanner scan = new Scanner(System.in);

		System.out.println("전화번호 입력 : ");

		int phoneNum = scan.nextInt();

		ArrayList<String> list = new ArrayList<String>();

		/* 삭제할 전화번호를 입력받아 삭제하는 코드를 작성하세요. */

		System.out.println("삭제할 번지를 입력하세요. : ");

		int i = scan.nextInt();

	}

}
