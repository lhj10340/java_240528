package day24;

import java.io.FileWriter;
import java.io.IOException;

public class Ex17 {

	public static void main(String[] args) {
		
		try (FileWriter fw = new FileWriter("src/day24/ex17.txt", true );) { // 뒤에 true 를 붙이면 이어쓰기.
			fw.write('a');
			fw.write('b');
			fw.write('c');
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
