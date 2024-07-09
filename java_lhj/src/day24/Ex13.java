package day24;

import lombok.Data;

public class Ex13 {

	public static void main(String[] args) {
		PointC [] pts = new PointC[3];
		
		/* 세점 (1,1) , (2,2) , (3,3) 을 저장하기 위해 다음과 같이 코드를 작성.
		 * 원인 : 객체를 생성하지 않고 메소드들을 호출했기 때문이다.
		 * 해결방법 : 객체 생성
		 * */
		
		for(int i = 0; i < pts.length; i++) {
			pts[i] = new PointC(0,0); // 이 줄이 추가되었다.
			pts[i].setX(i+1);
			pts[i].setY(i+1);
			pts[i].print();
		}
	}

}

@Data
class PointC {
	
	private int x, y;
	
	public PointC(int x, int y ) {
		this.x = x;
		this.y = y;
	}
	public void print() {
		System.out.println(x + "," + y);
	}
}
