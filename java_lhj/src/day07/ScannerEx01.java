package day07;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 next()와 nextLine()의 차이를 살펴보는 예제
		 * next() 
		 * - 문자열
		 * - 공백을 제외한 연속된 문자열.
		 * - 문자열을 입력하기 전 입력 버퍼에 엔터가 있으면 버린다.
		 * nextLine()
		 * - 문자열
		 * - 공백을 포함한 한 줄의 문자열.
		 * - 문자열을 입력하기 전 입력 버퍼에 엔터가 있으면 가져와서 실행한다.
		 * - 문자열을 입력한 마지막에 입력한 엔터를 가져가고 가져간 엔터를 버린다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		// next(), nextLine() 모두 여러번 연속으로 나와도 문제가 없다.
		System.out.print("문자열 입력(next) : ");
		String str1 = scan.nextLine();
		System.out.print("문자열 입력(next) : ");
		String str2 = scan.next();
		System.out.print("문자열 입력(next) : ");
		String str3 = scan.nextLine();
	}

}

// next 연속 3개일 때, 
// abc + 엔터 : abc 를 가져가서 str1 에 저장한다, 엔터가 남아있다 버퍼에. 다음 scan.next()가 버퍼에 남아있는 것을 버린다.
// def + 엔터
// xyz + 엔터 : 마지막에 버퍼에 엔터만 남는다.

// abc def xyz 로 입력한 경우.
// abc 를 str1 에 저장

// nextLine() 연속 3개.
// 다 빼가고 엔터를 버린다.

// 중간에 next 가 있으면 3번째가 공백으로 출력.
// 그래서 중간에 필요한 경우에는 엔터 제거를 위해
// scan.nextLine(); 한번 더 입력한다. 따로 변수 설정은 필요가 없다.