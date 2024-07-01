package day24;

public class Ex08 {

	public static void main(String[] args) {
		
		/* 좌표 10, 20 을 이용하여 객체를 생성했는데, (0,0) 으로 출력되었다.
		 * 원인 : 생성자에서 매개 변수 값을 필드(멤버 변수)에 저장하지 않았다.
		 * 해결 방법 : 매개 변수 값을 필드에 저장. ( this 입력 )
		 * */
	
		Point p1 = new Point(10, 20);
		
		p1.print();
		
		/* 기본 생성자를 이용하여 객체를 생성하려고 했는데, 에러가 발생
		 * 원인 : 기본 생성자가 없다. 기본 생성자 대신 Point 메소드가 있다. ( 생성자는 리턴 타입이 없다. )
		 * 해결 방법 :
		 * */
		
		Point p2 = new Point();
		
		p2.print();
	}

}

class Point {
	
	private int x, y;
	
	public Point (int x, int y) {
		
		/* x = x;
		y = y; */
		
		this.x = x;
		this.y = y;
		
	}
	
	// 수정 전 : 생성자가 아닌 메소드
	// public void Point() {}
	
	// 수정 후
	
	public Point() {}
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
	
}
