package day11;

public class InheritanceEx01 {

	public static void main(String[] args) {
		// 상속 예제
		HighSchoolStudent std = new HighSchoolStudent();
		std.print();
		std.setAge(10);
		std.print();
	}
	
}

class HighSchoolStudent extends Student{
	
	public void test() {
		// System.out.println(schoolName); // 접근제어자가 private 여서 자식 클래스에서 사용할 수 없다.
		System.out.println(name); // 접근제어자가 protected 여서 자식 클래스에서 사용할 수 있다.
		System.out.println(age); // 나이는 접근제어자가 기본인데 같은 패키지여서 사용할 수 있다.
		System.out.println(birthday); // 생일은 접근제어자가 public 이어서 자식 클래스에서 사용할 수 있다.
	}
	
}
