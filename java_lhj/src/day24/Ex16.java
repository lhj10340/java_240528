package day24;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex16 {

	private static String fileName = "src/day24/ex16.txt";
	
	public static void main(String[] args) {
		
		/* 1. 이름과 나이를 저장하고 관리하는 클래스를 생성하세요.
		 * 2. 이름이 홍길동, 나이는 21인 객체를 생성하세요.
		 * 3. src/day24/ex16.txt에 2번에서 저장한 객체를 저장하세요.
		 * */
		
		Info i1 = new Info ("홍길동", 21);
		
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream("src/day24/ex16.txt"))){ // 보조 스트림은 기반 스트림이 꼭 필요하다.
			oos.writeObject(i1);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* 4. src/day24/ex16.txt 에 저장된 객체를 불러온 후, 콘솔창에 출력하는 코드를 작성하세요.
		 * */
		
		try(ObjectInputStream ois 
		= new ObjectInputStream (new FileInputStream("src/day24/ex16.txt"))) {
			/* (Info) 를 생략하면 에러 발생
			 * 원인 : readObject 는 리턴에 Object 인데, 다운 캐스팅은 자동으로 이루어지지 않는다.
			 * 그래서 명시적으로 클래스 형 변환을 해야한다.
			 * */
			Info i2 = (Info)ois.readObject();
			System.out.println(i2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
	}
	
}

@Data
@AllArgsConstructor

class Info implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1574786818594657585L;
	private String name;
	private int age;

}