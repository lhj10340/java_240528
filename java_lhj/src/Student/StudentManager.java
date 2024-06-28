package Student;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import day21.socket2.Client;
import program.Program;

public class StudentManager implements Program {

	private List<Student> list = new ArrayList<Student>();
	private Scanner scan = new Scanner(System.in);
	private List<String> subjectList = new ArrayList<String>();
	private String fileName = "src/student/student.txt";

	private String ip = "192.168.30.213";
	
	private int port = 5001;
	
	@Override
	public void printMenu() {

		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 과목 관리");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 :");

	}

	@Override
	public void run() {
		load(fileName);
		int menu;

		do {

			printMenu();

			menu = nextInt();

			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while(menu != 3);
		save(fileName);
	}
	
	@Override
	public void save (String fileName) {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			oos.flush();

		} catch (Exception e) {

		} finally {
			save(fileName);
		}
	}
	
	@Override
	public void load (String fileName) {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<Student>)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			load(fileName);
		}
	}

	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못 입력하면 (문자열) 정수의 가장 작은 수를 반환
	 * @return 입력한 정수 또는 정수의 가장 작은 수
	 * */

	public int nextInt() {
		try {
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에서 비운다.
			return Integer.MIN_VALUE; // int 의 가장 작은 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {

		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default:
		}

	}

	private void exit() {

	}

	private void subject() {
		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
			
		} while(menu != 5);
	}

	private void printSubjectMenu() {
		System.out.println("과목 관리 메뉴");
		System.out.println("1. 과목 추가");
		System.out.println("2. 과목 수정");
		System.out.println("3. 과목 삭제");
		System.out.println("4. 과목 확인");
		System.out.println("5. 이전으로");
		System.out.println("메뉴 선택 : ");		
	}

	private void runSubjectMenu(int menu) {
		switch(menu) {
		case 1:
			insertSubject();
			break;
		case 2:
			updateSubject();
			break;
		case 3:
			deleteSubject();
			break;
		case 4:
			searchSubject();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
	}

	private void insertSubject() {
		
		// 과목명을 입력
		System.out.print("과목명 입력 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		// 과목 리스트에 등록된 과목인지 확인해서 등록되었으면 안내문구 출력 후 종료.
		if(subjectList.equals(subjectName)) {
			System.out.println("등록된 과목입니다.");
			return;
		}
		// 과목 리스트에 과목을 추가
		subjectList.add(subjectName);
		System.out.println("과목을 추가했습니다.");
	}

	private void updateSubject() {
		
		// 수정할 과목 입력
		System.out.println("과목 입력 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		
		// 새 과목명 입력
		System.out.println("새 과목 입력 : ");
		String newSubjectName = scan.nextLine();
		
		// 새 과목명이 이미 등록되어있으면 안내문구 출력 후 종료
		if(subjectList.equals(newSubjectName)) {
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		
		// 아니면 수정할 과목명 삭제
		subjectList.remove(subjectName);
		
		// 새 과목명 추가
		subjectList.add(newSubjectName);
		
	}

	private void deleteSubject() {
		
		// 삭제할 과목명 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		
		// 리스트에서 과목을 삭제해서 성공하면 알림문구 출력 후 종료
		
		
		// 실패하면 알림문구 출력
		
	}

	private void searchSubject() {
		System.out.println("과목 목록 : ");
		for(String subject : subjectList) {
			System.out.println(subject);
		}
	}

	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runtStudentMenu(menu);
		} while (menu != 5);

	}

	private void runtStudentMenu(int menu) {

		switch (menu) {
		case 1:
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studentSearch();
			break;
		case 5:
			prev();
			break;
		default :

		}
	}

	private void prev() {
		System.out.println("이전으로 돌아갑니다.");
	}

	private void studentSearch() {
		// 학년, 반, 번호를 입력 후 객체를 생성.
		System.out.print("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.print("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		Student std = new Student(grade, classNum, num, "");
		
		// 생성된 객체와 일치하는 객체를 가져온다.
		// 리스트에서 객체와 일치하는 번지를 가져온다.
		// 번지가 0보다 작으면 객체에 null 을 저장.
		// null이 아니면 학생 정보를 출력.
		
		List<Student> tmp = list.stream().filter(p->p.equals(std))
										 .collect(Collectors.toList());
		
		if (tmp.size() == 0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(i+1 + ". " + tmp.get(i));
		}
		
		// 가져온 객체가 null 이면 안내문구 출력 후, 종료

		// null 이 아니면 학생 정보를 출력
	}

	private void studentDelete() {
		// 학생을 삭제하는 기능을 구현하세요.

		// 학생의 이름 입력

		System.out.println("이름 입력 : ");
		scan.nextLine();
		String name = scan.nextLine();

		// 입력한 이름을 가지고 있는 학생의 리스트를 번호붙여서 출력
		List <Student> tmp = list.stream().filter(p->p.getName().contains(name))
				.collect(Collectors.toList());

		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + tmp.get(i));
		}

		// 삭제할 학생의 번호 입력
		System.out.println("삭제할 학생 번호 : ");
		int index = scan.nextInt() - 1;

		// 선택한 것을 가져온다. 

		// 삭제 처리
		// list.remove();

	}

	private void studentUpdate() {
		int menu;

		do {

			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);

		} while(menu != 5);
	}

	private void printStudentUpdateMenu() {
		
	}

	private void runStudentUpdateMenu(int menu) {
		switch(menu) {
		case 1:
			studentInfoUpdate();
			break;
		case 2:
			insertSubjectScore();
			break;
		case 3:
			updateSubjectScore();
			break;
		case 4:
			deleteSubjectScore();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
	}

	private void studentInfoUpdate() {
		// 수정하려는 학년, 반, 번호를 입력
		System.out.print("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.print("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		// 입력한 정보를 이용하여 학생 객체를 생성
		//	=> indexOf 또는 contains 등을 이용해서 객체를 쉽게 비교하기 위해.

		Student std1 = new Student(grade, classNum, num, "");
		
		// 생성한 학생 객체를 이용해서 리스트 몇 번지에 있는지 가져온다.
		if ( list.indexOf(std1) < 0 ) {
		// 번지가 유효하지 않은 번지이면 => 번지가 0보다 작으면 알림문구 출력 후 종료.
			System.out.println("등록된 학생이 없습니다.");
		}
		// 유효한 번지라면 수정할 학년, 반, 번호, 이름을 입력.
		System.out.print("학년 입력 : ");
		int newGrade = scan.nextInt();
		System.out.print("반 입력 : ");
		int newClassNum = scan.nextInt();
		System.out.print("번호 입력 : ");
		int newNum = scan.nextInt();
		System.out.println("이름 입력 : ");
		scan.nextLine();
		String newName = scan.nextLine();
		
		// 위에서 입력한 학년, 반, 번호, 이름으로 객체를 생성.
		Student std2 = new Student(newGrade, newClassNum, newNum, newName);
		
		// 수정할 객체를 리스트에서 번지에 있는 객체를 삭제해서 가져오고,
		// => 번지를 이용해서 삭제하면 삭제된 객체를 반환
		
		list.remove(list.indexOf(std1));
		
		// 생성한 객체가 리스트에 있는지 확인해서 있으면 알림문구 출력 후 종료.

		// 가져온 객체의 update 메소드를 이용해서 학년, 반, 번호, 이름을 수정.
		// update 메소드는 Student 클래스에서 새로 추가해야한다.
		
		// 리스트에 삭제되었던 객체를 추가
		
	}

	private void insertSubjectScore() {
		
		// 학생 정보 입력 (학년, 반, 번호) 해서 학생 객체를 생성
		System.out.println("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.println("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 입력 : ");
		int num = scan.nextInt();
		
		Student std1 = new Student(grade, classNum, num, "");
		
		// 리스트에 입력한 학생 객체가 몇 번지에 있는지 번지를 가져온다.
		int index = list.indexOf(std1);
		
		// 번지가 유효하지 않으면 안내문구 출력 후, 종료.
		if(index < 0) {
			System.out.println("등록된 학생이 없습니다.");
		}
		// 리스트에서 번지에 있는 학생 정보를 가져온다.
		// 등록된 과목 리스트를 출력
		
		List<Subject> tmp = list.get(index).getSubjectList();
		
		// 학년, 학기, 과목명, 중간, 기말, 수행평가를 입력한 후, 과목 객체를 생성
		System.out.print("학년 입력 : ");
		grade = scan.nextInt();
		System.out.print("학기 입력 : ");
		int semester = scan.nextInt();
		System.out.print("과목 입력 : ");
		String subjectName = scan.next();
		System.out.print("중간 입력 : ");
		int midTerm = scan.nextInt();
		System.out.print("기말 입력 : ");
		int finals = scan.nextInt();
		System.out.print("수행평가 입력 : ");
		int performance = scan.nextInt();
		
		Subject sub1 = new Subject(grade, semester, subjectName, midTerm, finals, performance);
		
		// 학생의 과목 리스트를 가져오고,
		
		// 학생의 과목 리스트에 생성한 과목 객체가 있으면 안내문구 출력 후 종료
		
		// 없으면 없으면 학생의 과목 리스트에 추가
		
	}

	private void updateSubjectScore() {
		// 학생 정보를 입력
		System.out.println("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.println("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 입력 : ");
		int num = scan.nextInt();
		
		Student std1 = new Student(grade, classNum, num, "");

		// 학생 리스트에서 학생 객체가 몇 번지에 있는지 가져오고
		int index = list.indexOf(std1);

		// 번지가 유효하지 않으면 알림문구 출력 후 종료
		if (index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
		}

		// 번지에 있는 학생 객체를 가져온다.
		std1 = list.get(index);

		// 학생의 과목 리스트를 가져온다.
		List<Subject> subjects = std1.getSubjectList();

		// 삭제할 과목, 학년, 하기 정보를 입력.
		// 과목, 학년, 학기를 이용해서 객체를 생성.
		Subject subject = inputRequiredSubject();

		// 과목이 과목리스트에 없으면 안내문구 출력 후 종료.
		if(!subjectList.contains(subject.getSubjectName())) {
			System.out.println("등록되지 않은 과목이어서 삭제할 수 없습니다.");
			return;
		}

		// 과목 객체가 학생 성적 리스트에 없으면 안내문구 출력 후 종료.
		if(!subjectList.contains(subject)) {
			System.out.println("등록된 과목이 리스트에 없습니다.");
		}
		// 중간, 기말, 수행평가를 입력
		System.out.print("중간 : ");
		int midTerm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행평가 : ");
		int performance = scan.nextInt();

		// 과목 객체의 성적을 수정


		// 제거하고 추가하는 이유는 이렇게 하지 않으면, subjects 에서 해당 과목이 몇 번에 있는지 확인해서
		// 해당 과목 정보를 가져오고 성적을 수정해야하는데 번거롭기 때문에 아래와 같이 작성

		// 리스트에서 과목 객체를 제거

		// 리스트에서 과목 객체를 추가
	}

	private void deleteSubjectScore() {
		
		// 학생 정보를 입력
		System.out.print("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.print("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		Student std1 = new Student(grade, classNum, num, "");
		
		// 학생 리스트에서 학생 객체가 몇 번지에 있는지 가져오고
		int index = list.indexOf(std1);
		
		// 번지가 유효하지 않으면 알림문구 출력 후 종료	
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		// 번지에 있는 학생 객체를 가져온다.
		list.get(index);
		
		// 학생의 과목 리스트를 가져온다.
		searchSubject();
		
		// 삭제할 과목, 학년, 학기 정보를 입력.
		System.out.print("과목 입력 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		System.out.print("학년 입력 : ");
		grade = scan.nextInt();
		System.out.print("번호 입력 : ");
		int semester = scan.nextInt();
		
		// 과목이 과목리스트에 없으면 안내문구 출력 후 종료.
		if(!subjectList.contains(subjectName)){
			System.out.println("해당 과목이 없습니다.");
		}
		
		// 과목, 학년, 학기를 이용해서 객체를 생성.
		Subject sub1 = new Subject (subjectName, grade, semester);
		
		// 학생 과목 리스트에서 과목 객체를 삭제하여 성공하면 안내문구 출력 후 종료
		if(subjectList.remove(sub1)) {
			System.out.println("과목 삭제를 성공하였습니다.");
		}
		
		// 실패하면 안내문구 출력 후 종료
		System.out.println("등록되지 않은 점수입니다.");
	}

	private void defaultPrint() {
		System.out.println("올바른 메뉴를 선택하세요.");		
	}

	private void studentInsert() {

		// 학생을 추가하는 기능을 구현하세요.

		// 학생의 학년, 반, 번호, 이름 입력
		System.out.println("학년 입력 : ");
		int grade = scan.nextInt();
		System.out.println("반 입력 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 입력 : ");
		int num = scan.nextInt();
		System.out.println("이름 입력 : ");
		scan.nextLine();
		String name = scan.nextLine();

		// 입력받은 정보를 담고 있는 객체 생성
		Student std = new Student(grade, classNum, num, name);

		// 객체를 리스트에 추가

		if(list.contains(std)) {
			System.out.println("이미 등록된 반, 번호, 이름입니다.");
		}

		list.add(std);

		System.out.println(list);
	}

	private void printStudentMenu() {

		System.out.println("학생 관리 메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 조회");
		System.out.println("5. 이전으로");
		System.out.println("메뉴 선택 : ");

	}
	
	public Subject inputRequiredSubject() {

		System.out.print("과목 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("학기 : ");
		int semester = nextInt();

		return new Subject(name, grade, semester);
	}

}
