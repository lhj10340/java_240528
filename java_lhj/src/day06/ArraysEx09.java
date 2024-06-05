package day06;

import java.util.Scanner;

public class ArraysEx09 {

	public static void main(String[] args) {
		String [] list = {"dog", "cat", "java", "cup", "computer"};
		
		// 문자열을 받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요.
		
		/* 결과로 나올 화면을 예상해보는 것이 좋다. ( 정답 유무와 관계없이 )
		 * 
		 * 예시1.
		 * 찾을 문자열 입력 :
		 * '단어' 가 있습니다.
		 * 
		 * 예시2.
		 * 찾을 문자열 입력 :
		 * '단어' 가 없습니다.
		 * 
		 * */
		
		// 안내문구 출력.
		System.out.print("문자열을 입력하세요 : ");
		
		// 단어를 입력.
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		
		// 1. list 에서 입력받은 단어가 있는지 없는지 하나씩 탐색해서 찾은 후,
		// 1-1. 원하는 단어가 있는지? 없는지? 확인하기 위한 변수를 선언한다. (boolean)
		boolean result = false;
		// 1-2. list에서 하나씩 커내서 입력받은 단어와 같은지 비교하여 같으면 변수를 있다고 만들고 빠져나온다.
		// 전체 탐색을 해야하되 번지를 알 필요가 없을 때 ( 향상된 for문 )
		for(String tmp : list) {
			if(word.equals(tmp)) {
				result = true;
				break;
			}
		}
		// 2. 있으면 '있습니다' , 없으면 '없습니다' 라고 출력.
		if(result) {
			System.out.println(word + "가 있습니다.");
		}
		else {
			System.out.println(word + "가 없습니다.");
		}
		
	}

}
