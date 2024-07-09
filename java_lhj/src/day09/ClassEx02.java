package day09;

public class ClassEx02 {

	public static void main(String[] args) {
		
		Student2 std = new Student2();
		std.setGrade(1);
		System.out.println(std.getGrade() + "학년");
		
	}

}


class Student2{
	private int grade, classNum, num;
	private String name;
	// grade 에 대한 getter // 리턴 타입이 있다.
	public int getGrade() {
		return grade;
	}
	// grade 에 대한 setter // 리턴 타입이 없어서 void, 다만 매개변수가 있다.
	public void setGrade(int g) {
		grade = g;
	}
	
	// 빈칸을 우클릭 후, source -> generate getter and setter 를 통하여 코드를 자동으로 생성할 수 있다.
	
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}