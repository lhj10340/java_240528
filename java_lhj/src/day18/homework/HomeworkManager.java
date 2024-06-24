package day18.homework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class HomeworkManager implements Program {

	private Scanner scan = new Scanner(System.in);

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	List<Homework> list = new ArrayList<Homework>();

	/* 일정을 관리하는 프로그램을 작성하세요. 
	 * -----------
	 * 쉬운 버전 : 한 사람의 일정을 관리하는 프로그램
	 * -----------
	 * 메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 날짜(yyyy-MM-dd hh:mm) : 2024-06-21 17:50
	 * 일정 : 퇴근
	 * 상세 : 없음
	 * -----------
	 * 일정이 추가되었습니다.
	 * -----------
	 * 메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 2
	 * -----------
	 * 날짜(yyyy-MM-dd) : 2024-06-21
	 * 2024-06-21 일정 리스트
	 * 1. 2024-06-21 17:50 퇴근 없음
	 * ----------
	 * 수정할 일정 선택 : 1
	 * ----------
	 * 날짜(yyyy-MM-dd hh:mm) : 2024-06-21 17:51
	 * 일정 : 퇴근
	 * 상세 : 없음
	 * ----------
	 * 수정이 완료되었습니다.
	 * ----------
	 *  메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 3
	 * -----------
	 * 날짜(yyyy-MM-dd) : 2024-06-21
	 * 2024-06-21 일정 리스트
	 * 1. 2024-06-21 17:50 퇴근 없음
	 * ----------
	 * 삭제할 일정 선택 : 1
	 * ----------
	 * 삭제되었습니다.
	 * ----------
	 *  메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 4
	 * -----------
	 * 날짜(yyyy-MM-dd) : 2024-06-21
	 * -----------
	 * 2024-06-21 일정 리스트
	 * -----------
	 * 1. 2024-06-21 17:50 퇴근 없음
	 * -----------
	 * 메뉴로 가시려면 엔터를 입력하세요
	 * -----------
	 *  메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 5
	 * -----------
	 * 프로그램을 종료합니다.
	 * -----------
	 * 어려운 버전 : 여러 사람의 일정을 관리하는 프로그램
	 * -----------
	 * 메인 메뉴
	 * 1. 회원 관리
	 * 2. 일정 관리
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 회원 메뉴
	 * 1. 회원 추가
	 * 2. 회원 수정
	 * 3. 회원 삭제
	 * 4. 이전으로
	 * -----------
	 * 메뉴 선택 : 1
	 * -----------
	 * 추가할 회원 정보 입력
	 * 아이디 : abc123 ( 수정이 안 되도록 )
	 * 이름 : 홍길동
	 * -----------
	 * 회원이 추가되었습니다.
	 * -----------
	 * 회원 메뉴
	 * 1. 회원 추가
	 * 2. 회원 수정
	 * 3. 회원 삭제
	 * 4. 이전으로
	 * -----------
	 * 메뉴 선택 : 2
	 * -----------
	 * 아이디 : abc123
	 * -----------
	 * 수정할 이름 : 고길동
	 * -----------
	 * 회원 정보를 수정했습니다.
	 *  회원 메뉴
	 * 1. 회원 추가
	 * 2. 회원 수정
	 * 3. 회원 삭제
	 * 4. 이전으로
	 * -----------
	 * 메뉴 선택 : 3
	 * -----------
	 * 아이디 : abc123
	 * -----------
	 * 회원 정보를 삭제했습니다.
	 * 회원 메뉴
	 * 1. 회원 추가
	 * 2. 회원 수정
	 * 3. 회원 삭제
	 * 4. 이전으로
	 * -----------
	 * 메뉴 선택 : 4
	 * -----------
	 * 메인 메뉴
	 * 1. 회원 관리
	 * 2. 일정 관리
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 2
	 * -----------
	 * 아이디 : admin
	 * -----------
	 * 등록되지 않은 회원입니다.
	 * 메인 메뉴
	 * 1. 회원 관리
	 * 2. 일정 관리
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 2
	 * -----------
	 * 아이디 : abc123
	 * -----------
	 * 일정 메뉴
	 * 1. 일정 추가
	 * 2. 일정 수정
	 * 3. 일정 삭제
	 * 4. 일정 확인
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 
	 * -----------
	 * 쉬운 버전과 동일
	 * */

	@Override
	public void printMenu() {

		/* 메뉴
		 * 1. 일정 추가
		 * 2. 일정 수정
		 * 3. 일정 삭제
		 * 4. 일정 확인
		 * 5. 프로그램 종료
		 * 메뉴 선택 :
		 */

		System.out.println("메뉴");
		System.out.println("1. 일정 추가");
		System.out.println("2. 일정 수정");
		System.out.println("3. 일정 삭제");
		System.out.println("4. 일정 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) throws Exception {

		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("메뉴를 다시 선택하세요.");
			break;

		}

	}

	private void search() {
		// 날짜 입력.

		System.out.println("날짜를 입력하세요. (yyyy-MM-dd) : ");
		String ymd1 = scan.next();

		// 입력한 날짜를 포함하는 날짜별 일정을 리스트로 출력. ( 새로운 리스트에 만들어서 .. )

		List<Homework> tmp = list.stream().filter(h->h.getYmd().contains(ymd1)).collect(Collectors.toList());

		// 입력한 날짜에 일정이 아무것도 없다면?

		if(tmp.size() == 0) {
			System.out.println("해당 날짜에 일정이 없습니다.");
			return;
		}

		// 일정 순서대로 번호를 입력.

		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + tmp.get(i));
		}

		// 고민 더 해보는 걸로 .. ( 잘 모르겠다 ) 
		// 공백을 처리하기 위해서는 nextLine 이 필요하다. 다만, 위에 next 를 이용하여 처리한 것이 있어서 공백 처리를 위해 한번 더 적어야 한다.
		// 그래서 아래에 2번 적었다.
		
		scan.nextLine();
		
		System.out.println("-------------------------");
		System.out.println("메뉴로 가시려면 엔터를 입력하세요.");
		System.out.println("-------------------------");
		
		scan.nextLine();
		
	}

	private void delete() {

		// 날짜 입력.

		System.out.println("날짜를 입력하세요. (yyyy-MM-dd) : ");
		String ymd1 = scan.next();

		// 입력한 날짜를 포함하는 날짜별 일정을 리스트로 출력. ( 새로운 리스트에 만들어서 .. )

		List<Homework> tmp = list.stream().filter(h->h.getYmd().contains(ymd1)).collect(Collectors.toList());

		// 입력한 날짜에 일정이 아무것도 없다면?

		if(tmp.size() == 0) {
			System.out.println("해당 날짜에 일정이 없습니다.");
			return;
		}

		// 일정 순서대로 번호를 입력.

		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + tmp.get(i));
		}

		// 번호를 입력하고 선택할 수 있게 ...
		// 위에서 번지에 + 1을 붙이는 식으로 번호를 배정했으므로, 해당 번지를 선택하기 위해서는 번호 - 1이 들어가야한다.

		System.out.println("삭제할 번호를 입력하세요. : ");
		int index = scan.nextInt() - 1; 

		// 입력한 번호가 0보다 작거나 ( 번지는 0보다 작은 번호가 없다 ) , 검색해서 나온 일정의 개수보다 클 수가 없다. ( 검색해서 나온 리스트에 일정이 3개 있다면, 4개는 나올 수가 없다. )

		if(index < 0 || tmp.size() < index) {
			System.out.println("번호를 다시 입력하세요.");
			return;
		}

		// 선택한 걸 가져온다, 객체를 새로해서.

		Homework tmps = tmp.get(index);

		// 선택한 것을 삭제한다.

		list.remove(tmps);
		
		System.out.println("---------------");
		System.out.println("일정이 삭제되었습니다.");
		System.out.println("---------------");
		
		System.out.println(list);
	}

	private void update() {

		// 날짜 입력.

		System.out.println("날짜를 입력하세요. (yyyy-MM-dd) : ");
		String ymd1 = scan.next();

		// 입력한 날짜를 포함하는 날짜별 일정을 리스트로 출력. ( 새로운 리스트에 만들어서 .. )

		List<Homework> tmp = list.stream().filter(h->h.getYmd().contains(ymd1)).collect(Collectors.toList());

		// 입력한 날짜에 일정이 아무것도 없다면?

		if(tmp.size() == 0) {
			System.out.println("해당 날짜에 일정이 없습니다.");
			return;
		}

		// 일정 순서대로 번호를 입력.

		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + tmp.get(i));
		}

		// 번호를 입력하고 선택할 수 있게 ...
		// 위에서 번지에 + 1을 붙이는 식으로 번호를 배정했으므로, 해당 번지를 선택하기 위해서는 번호 - 1이 들어가야한다.

		System.out.println("수정할 번호를 입력하세요. : ");
		int index = scan.nextInt() - 1; 

		// 입력한 번호가 0보다 작거나 ( 번지는 0보다 작은 번호가 없다 ) , 검색해서 나온 일정의 개수보다 클 수가 없다. ( 검색해서 나온 리스트에 일정이 3개 있다면, 4개는 나올 수가 없다. )

		if(index < 0 || tmp.size() < index) {
			System.out.println("번호를 다시 입력하세요.");
			return;
		}

		// 선택한 걸 가져온다, 객체를 새로해서.

		Homework tmps = tmp.get(index);

		// 날짜, 일정, 상세 를 수정한다.

		System.out.println("날짜 입력 : ");

		Date date = new Date();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newYmd = format1.format(date);
		System.out.println(newYmd);

		scan.nextLine();
		
		System.out.println("일정 입력 : ");
		String newSchedule = scan.nextLine();
		System.out.print("상세 입력 : ");
		String newDetail = scan.next();

		list.remove(tmps);

		Homework newHomework = new Homework(newYmd, newSchedule, newDetail);

		list.add(newHomework);
		
		System.out.println(list);

	}

	private void insert() {

		System.out.println("날짜 입력 : ");

		Date date = new Date();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ymd = format1.format(date);
		System.out.println(ymd);


		System.out.print("일정 입력 : ");
		String schedule = scan.next();
		System.out.print("상세 입력 : ");
		String detail = scan.next();

		Homework h = new Homework(ymd, schedule, detail);

		list.add(h);

		System.out.println("---------------");
		System.out.println("일정이 추가되었습니다.");
		System.out.println("---------------");

		System.out.println(list);
	}

	@Override
	public void run() {

		int menu = INSERT;

		do {

			printMenu();
			menu = scan.nextInt();

			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		} while (menu != EXIT);

	}

}
