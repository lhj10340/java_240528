package day24;

import lombok.Setter;

public class Ex09 {

	public static void main(String[] args) {
		
		PointA p1 = new PointA(10,20);
		p1.print();
		
		/* x 의 값을 100, y의 값을 200으로 수정하려 했다.
		 * 원인 : 접근 제어자가 private
		 * 해결방법 : 접근 제어자를 public 으로 바꾸거나, setter 를 추가.
		 * */
		
		p1.setX = 100;
		p1.setY = 200;
		
		p1.print();
		
		/* 기본 생성자를 이용해서 객체를 생성하려했다.
		 * 원인 : 기본 생성자가 없다. 생성자가 1ㄱ라도 있으면 기본 생성자가 자동으로 추가되지 않는다.
		 * 해결방법 : 기본 생성자를 추가.
		 * */
		
		PointA p2 = new PointA();
		p2.print();
		
	}

}

class PointA{
	
	public int setY;
	public int setX;
	
	@Setter
	
	private int x, y;
	
	public PointA() {}
	
	PointA(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print () {System.out.println(x + ", " + y);
	
	}
}
