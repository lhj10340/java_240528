package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamEx01 {

	public static void main(String[] args) {
		// 바이트 기반 입출력 스트림 예제
		
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		
		try {
			fis = new FileInputStream("src/day17/byteStream.txt"); // 프로젝트 기준으로 검색을 한다.
			/* 파일에 "1" 이라는 문자열이 저장되어 있으면 처음 read 로 읽어올 떄, 문자 1을 읽어오고
			 * 두번째 read 로 읽어올 때, 더 읽어올 내용이 없어서 -1 을 반환.
			 * */
			int data = fis.read();
			System.out.println(data);
			data = fis.read();
			System.out.println(data); // 데이터를 읽어오지 못 하면 -1 이 나온다.
			
			fis2 = new FileInputStream("src/day17/byteStream2.txt");
			do {
				data = fis2.read();
				System.out.print((char)data);
			} while (data != -1);
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 읽기에 실패했습니다.");
		}
		finally {
			
			try {
				if(fis != null) {
					fis.close();
				}
				if(fis2 != null) {
					fis.close();
				}
			} catch (IOException e) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}
	}

}
