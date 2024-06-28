package Student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable {
	
	private static final long serialVersionUID = -8805385944367790657L;
	
	// 과목명, 학년, 학기, 중간, 기말, 수행평가
	
	private String name;
	private int grade;
	private int semester;
	private int midTerm;
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
	public void update(int midTerm, int finals, int performance) {
		this.midTerm = midTerm;
		this.finals = finals;
		this.performance = performance;
	}
	@Override
	public String toString() {
		return "과목 : " + name + ", " + grade + "학년 " + semester + "학기\n중간 : " + midTerm 
				+ "기말 : " + finals + "\n수행 : " + performance + "\n총점 : " + getTotal();
	}
	private double getTotal() {
		
		return (midTerm * 0.4 + finals * 0.5 + performance * 0.1);
	}
	
	// 한 학생에게 같은 과목명, 학년, 학기 성적이 여러 개 있을 수 없기 때문에
	// equals 를 과목명, 학년, 학기를 이용하여 오버라이딩
	
	
	
}
