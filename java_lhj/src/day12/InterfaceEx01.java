package day12;

public class InterfaceEx01 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.bark();
		dog.sleep();
		// 인터페이스는 객체를 만들 수 없고, 구현 클래스를 이용하여 객체를 만들 수 있다. ( 포함 다형성 )
		AnimalAction aa = new Dog1();
		aa.bark();
		System.out.println(AnimalAction.num); // AnimalAction 에 있는 10과 20이 출력되도록 코드를 작성.
		System.out.println(AnimalAction.num2); // static 으로 되어있어서 클래스로 호출해야한다. 상수 출력.
		AnimalAction.print();
	}

}

interface AnimalAction {
	public static final int num = 10;
	int num2 = 20;
	public abstract void bark();
	default void sleep () { System.out.println("잠을 잡니다.");} // default 입력을 하지 않고는 할 수 없다. ( 내용 추가를 할 수 없다. )
	void eat(String food); // public abstract 가 자동으로 붙는다.
	public static void print() {
		System.out.println("동물의 동작입니다.");
	}
}

abstract class Animal2 implements AnimalAction { // 오버라이딩을 하지 않을거라 추상 클래스 생성.
	String name;
}

class Dog1 extends Animal2 {

	@Override
	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}

	@Override
	public void eat(String food) {
		System.out.println(food + "를 먹습니다.");
	}
	
}

