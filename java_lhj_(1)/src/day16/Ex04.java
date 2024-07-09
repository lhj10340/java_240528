package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class Ex04 {

	public static void main(String[] args) {
		
		/* 강사님 풀이 */
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1,2,1, "둘리", 60, 60, 70));
		list.add(new Student(1,1,1, "홍길동", 100, 20, 30));
		list.add(new Student(1,1,2, "고길동", 100, 100, 100));
		
		
		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요.*/
		
		// 이건 메소드 3개로 해결.
		
		int sumKor = sumKor(list);
		System.out.println("국어 평균 : " + sumKor / (double)list.size());
		int sumEng = sumEng(list);
		System.out.println("영어 평균 : " + sumEng / (double)list.size());
		int sumMath = sumMath(list);
		System.out.println("수학 평균 : " + sumMath / (double)list.size());
		
		System.out.println("-----");
		
		// 이건 메소드 1개로 해결. ( 더 효율적이다. )
		
		int sumKor2 = sum(list, s->s.getKor());
		System.out.println("국어 평균 : " + sumKor / (double)list.size());
		int sumEng2 = sum(list, s->s.getEng());
		System.out.println("영어 평균 : " + sumEng / (double)list.size());
		int sumMath2 = sum(list, s->s.getMath());
		System.out.println("수학 평균 : " + sumMath / (double)list.size());
		
		
		/* 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요.*/
		
		// 메소드 3개로 해결.
		
		printKor(list);
		printEng(list);
		printMath(list);
		
		System.out.println("-----");
		
		// 메소드 1개로 해결.
		
		print(list, s->System.out.println("이름 : "+ s.getName() +", 국어 : " + s.getKor()));
		print(list, s->System.out.println("이름 : "+ s.getName() +", 영어 : " + s.getEng()));
		print(list, s->System.out.println("이름 : "+ s.getName() +", 수학 : " + s.getMath()));
		
		// 국어 성적이 80점 이상인 학생을 출력하는 코드를 작성하세요.
		printStudent(list, (s->s.getKor() >= 80));
		System.out.println("-----");
		// 1학년 1반 학생들을 출력하는 코드를 작성하세요.
		printStudent(list, s->s.getGrade() == 1 && s.getClassNum() == 1);
		// 1학년 1반 1번 학생을 출력하는 코드를 작성하세요.
		printStudent(list, s->s.getGrade() == 1 && s.getClassNum() == 1 && s.getNum() == 1);
		
		Collections.sort(list, (o1, o2) -> {
			if(o1.getGrade() != o2.getGrade())
				return o1.getGrade() - o2.getGrade();
			if(o1.getClassNum() != o2.getClassNum())
				return o1.getClassNum() - o2.getClassNum();
			return o1.getNum() - o2.getNum();
		});
		System.out.println("-----");
		
		printStudent(list,s->true);
		
		// 국어 성적 순으로 정렬
		Collections.sort(list, (o1, o2)-> o2.getEng() - o1.getEng());
		
		
	}
	
	public static void printStudent(List<Student> list, Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void print(List<Student> list, Consumer<Student> c) {
		for(Student tmp : list) {
			c.accept(tmp);
		}
	}

	private static void printKor(List<Student> list) {
		for(Student tmp : list) {
			System.out.println("이름 : "+ tmp.getName() +", 국어 : " + tmp.getKor() );
		}
	}
	
	private static void printEng(List<Student> list) {
		for(Student tmp : list) {
			System.out.println("이름 : "+ tmp.getName() +", 영어 : " + tmp.getEng() );
		}
	}
	
	private static void printMath(List<Student> list) {
		for(Student tmp : list) {
			System.out.println("이름 : "+ tmp.getName() +", 수학 : " + tmp.getMath() );
		}
	}

	public static int sum(List<Student> list, Function<Student, Integer> f) {
		int sum = 0;
		for(Student tmp : list) {
			sum += f.apply(tmp);
		}
		return sum;
	}
	
	public static int sumKor(List<Student> list) {
		int sum = 0;
		for(Student tmp : list) {
			sum += tmp.getKor();
		}
		return sum;
	}
	
	public static int sumEng(List<Student> list) {
		int sum = 0;
		for(Student tmp : list) {
			sum += tmp.getEng();
		}
		return sum;
	}
	
	public static int sumMath(List<Student> list) {
		int sum = 0;
		for(Student tmp : list) {
			sum += tmp.getMath();
		}
		return sum;
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
	
	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name + "국어 : " + kor
				+ "점, 영어" + eng + "점, 수학" + math + "점";
	}
	
	
	
}