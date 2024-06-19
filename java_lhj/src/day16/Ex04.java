package day16;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class Ex04 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1, "홍길동", 100, 20, 30));
		list.add(new Student(1,1,2, "고길동", 100, 100, 100));
		list.add(new Student(1,2,1, "둘리", 60, 60, 70));

		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요. */
		/* 가능하면 함수형 인터페이스와 메소드를 이용해보세요.*/

		// list.get(i).getKor(); - 학생 각각의 국어성적

		// list.get(0).getKor() + list.get(1).getKor() + list.get(2).getKor() : 각 학생 국어성적의 합.

		double avgK = (list.get(0).getKor() + list.get(1).getKor() + list.get(2).getKor())/(double)list.size();

		// list.get(i).getEng(); - 학생 각각의 영어성적

		// list.get(0).getEng() + list.get(1).getEng() + list.get(2).getEng() : 각 학생 영어성적의 합.

		double avgE = (list.get(0).getEng() + list.get(1).getEng() + list.get(2).getEng()) / (double)list.size();

		// list.get(i).getMath(); - 학생 각각의 수학성적

		// list.get(0).getMathg() + list.get(1).getMath() + list.get(2).getMath() : 각 학생 수학성적의 합.

		double avgM = (list.get(0).getMath() + list.get(1).getMath() + list.get(2).getMath()) / (double)list.size();

		System.out.println("국어 성적 평균 : " + avgK);
		System.out.println("영어 성적 평균 : " + avgE);
		System.out.println("수학 성적 평균 : " + avgM);


		System.out.println("------------------------------");

		/* 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요.*/

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + " 국어성적 : "+ list.get(i).getKor());
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + " 영어성적 : "+ list.get(i).getEng());
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + " 수학성적 : "+ list.get(i).getMath());
		}

		System.out.println("-----");
		
		// 국어 성적이 80점 이상인 학생을 출력하는 코드를 작성하세요.
		
		for (Student tmp : list) {
			if(tmp.getKor() >= 80) {
				System.out.println(tmp.getName() + ", 국어성적 : " + tmp.getKor());
			}
		}
		
		System.out.println("-----");
		
		// 1학년 1반 학생들을 출력하는 코드를 작성하세요.
		
		for (Student tmp : list) {
			if(tmp.getGrade() == 1 && tmp.getClassNum() == 1 ) {
				System.out.println("1학년 1반 : " + tmp.getName());
			}
		}
		
		System.out.println("-----");
		
		// 1학년 1반 1번 학생을 출력하는 코드를 작성하세요.
		
		for (Student tmp : list) {
			if(tmp.getGrade() == 1 && tmp.getClassNum() == 1 && tmp.getNum() == 1) {
				System.out.println("1학년 1반 1번 : " + tmp.getName());
			}
		}
		
	}

}
@Data
@AllArgsConstructor
class Student {
	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;
	private int kor, eng, math;
}
