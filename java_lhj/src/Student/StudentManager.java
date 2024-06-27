package Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class StudentManager implements Program {

	private List<Student> list = new ArrayList<Student>();
	private Scanner scan = new Scanner(System.in);
	private List<Subject> subjectList = new ArrayList<Subject>();

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
		list.remove();

	}

	private void studentUpdate() {

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

}
