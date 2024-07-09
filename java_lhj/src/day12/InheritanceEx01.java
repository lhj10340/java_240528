package day12;

public class InheritanceEx01 {

	public static void main(String[] args) {
		
		Child c = new Child();
		run(c); // 매개변수 다형성에 의해 실행된다.
		
	}
	// main 메소드에서 호출할 run 메소드를 만드는데,
	// 누가 어떻게 구현할지를 모르는 상황.
	public static void run (Parent parent) {
		if(parent != null) {
			parent.run();
		}
	}
}
// Parent 는 개발자들이 자주 쓰는 클래스라고 가정. => 다른 패키지에 있다고 가정.
// 이 클래스에는 run 이라는 메소드가 있다고 가정.
class	Parent {

	public void run () {
		System.out.println("실행합니다.");
	}
}

class Child extends Parent{
	
	@Override // 부모 클래스를 재정의해서 사용하는 것.
	public void run() {
		System.out.println("오버라이드하여 실행합니다. (내가 구현하기를 원하는 기능이라 가정.");
	}
	
}