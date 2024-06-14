package day13;

import java.text.MessageFormat;

public class MessageFormatEx01 {

	public static void main(String[] args) {

		String format = "({0}, {1})";
		int x = 1, y = 10;
		String result1 = MessageFormat.format(format, x,y);
		System.out.println(result1);
		
		int grade = 1, classNum = 1, num = 1;
		String name = "홍길동";
		String format2 = "{0}학년 {1}반 {2}번 {3}";
		String result2 = MessageFormat.format(format2, grade, classNum, num, name);
		System.out.println(result2);
		
	}

}
