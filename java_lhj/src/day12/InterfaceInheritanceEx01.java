package day12;

public class InterfaceInheritanceEx01 {

	public static void main(String[] args) {

	}

}

interface InterfacePA {
	void print();
	void test1();
	
}
interface InterfacePB {
	void print();
	void test1();
}
// print() 메소드가 겹치는데, 상속을 받으면 어차피 구현부가 없어서 하나로 합치면 되기 때문에 다중 상속이 가능하다. ( interface )
interface InterfaceC extends InterfacePA, InterfacePB {
	
}

class ClassA {
	void print() {}
	void test2() {}
}
class ClassB {
	void print() {}
	void test2() {}
}
class ClassC extends ClassA {} // 클래스에서는 다중 상속을 허용하지 않는다. 같은 메소드가 있는 경우 구분할 수 없다.