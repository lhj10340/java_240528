package day16;

public class LamdaEx01 {

	public static void main(String[] args) {
		
		// 기존에 알던 방식
		
		A a1 = new A() {
			
			@Override
			public int sum(int n1, int n2) {
				return n1 + n2;
			}
			
		};
		
		// 람다식을 이용한 방식
		
		A a2 = (n1, n2)->{
			return n1 + n2;
		};
		// 구현부가 1줄이면 중괄호 생략이 가능, 중괄호 생략할 때, return 이 있으면 return 을 생략해야한다.
		A a3 = (n1, n2)-> n1+n2; 
		// 매개변수가 1개이면 () 를 생략할 수 있다.
		B b1 = (n1)->System.out.println(n1);
		
		b1.print(10);
		System.out.println(a3.sum(10, 20));
		
	}

	
}

interface A{
	int sum(int num1, int num2);
}

interface B{
	void print(int num1);
}
@FunctionalInterface
interface C{
	void test();
	// int test(int a); // @FunctionalInterface 를 추가했기 때문에 추상 메소드가 2개가 되면 에러 발생.
}