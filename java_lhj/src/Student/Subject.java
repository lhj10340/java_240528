package Student;

import java.util.Objects;

import lombok.Data;

@Data
public class Subject {
	
	// 과목명, 학년, 학기, 중간, 기말, 수행평가
	
	private String subjectName;
	private int grade;
	private int semester;
	private int midterm;
	private int finals;
	private int performance;
	
	public Subject(int grade, int semester, String subjectName, int midTerm, int finals, int performance) {
		this.grade = grade;
		this.semester = semester;
		this.subjectName = subjectName;
		this.midterm = midterm;
		this.finals = finals;
		this.performance = performance;
	}
	public Subject(String subjectName, int grade, int semester) {
		this.subjectName = subjectName;
		this.grade = grade;
		this.semester = semester;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && semester == other.semester && Objects.equals(subjectName, other.subjectName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, semester, subjectName);
	}
	
	// 한 학생에게 같은 과목명, 학년, 학기 성적이 여러 개 있을 수 없기 때문에
	// equals 를 과목명, 학년, 학기를 이용하여 오버라이딩
	
	
	
}
