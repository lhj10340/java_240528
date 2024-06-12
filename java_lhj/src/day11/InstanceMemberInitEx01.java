package day11;

public class InstanceMemberInitEx01 {

	public static void main(String[] args) {
		// 객체를 생성하지 않아서 static 초기화 블록까지만 초기화 된다.
		System.out.println(B.max);
		// 객체를 생성할 때, 생성자에서 max 도 초기화 한다.
		B b = new B (); // 이 때, num 과 max 의 값은?
		System.out.println(b.num);
		System.out.println(B.max);
	}

}

// { } : 초기화 블록

class B {
	public int num = 10; 
	public static int max = 10;
	
	{
		num = 20;
	}
	static {
		max = 20;
	}
	public B() {
		num = 20;
		max = 30;
	}
}
