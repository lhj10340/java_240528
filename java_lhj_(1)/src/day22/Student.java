package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data

public class Student {
	
	 // 학년, 반, 번호, 이름
		
	private int grade, classNum, num;
	private String name;
	
	 // 각 과목의 점수
	
	private List<Subject> subjectList = new ArrayList<Subject>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}

	// 같은 학교에 특정 년도에 같은 학년, 반, 번호를 가진 학생은 1명이기 때문에
	// equals 를 오버라이딩
	
	
	
}
