package day22;

import java.util.Objects;

import lombok.Data;

@Data
public class Subject {
	
	// 과목명, 학년, 학기, 중간, 기말, 수행평가
	
	private String name;
	private int grade;
	private int semester;
	private int midterm;
	private int finals;
	private int performance;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Objects.equals(name, other.name) && semester == other.semester;
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, name, semester);
	}
	
	// 한 학생에게 같은 과목명, 학년, 학기 성적이 여러 개 있을 수 없기 때문에
	// equals 를 과목명, 학년, 학기를 이용하여 오버라이딩
	
	
	
}
