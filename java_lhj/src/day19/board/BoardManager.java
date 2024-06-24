package day19.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class BoardManager implements Program {

	private Scanner scan = new Scanner(System.in);

	private String fileName = "src/day19/board/data.txt";

	List <Board> list = new ArrayList<Board>();

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	public static void main(String[] args) {

		/* 회원가입 없이 게시글을 등록/수정/삭제/조회하는 프로그램을 작성하세요.
		 * 
		 * */

		// 메뉴 출력
		// 게시글 등록.
		// 게시글 수정.
		// 게시글 삭제.
		// 게시글 조회.

		// 메뉴 입력을 위한 스캐너 작성.
		Scanner scan = new Scanner(System.in);
		// 내용을 저장할 리스트 작성.

		// 여러가지 내용이 들어가기 때문에 클래스를 작성하여 날짜,제목,내용을 묶을 것.

		// 메뉴별 기능 구현.

		// 게시글 등록
		// 작성자, 제목, 내용을 각각 나눠서 입력할 수 있도록 구현.
		// 작성자 ( 문자열을 입력하여 구현할 수 있도록 할 것. )
		// 제목 ( 문자열을 입력하여 구현할 수 있도록 할 것. )
		// 내용 ( 문자열을 입력하여 구현할 수 있도록 할 것. )

		// 게시글 수정.
		// 제목 또는 날짜를 검색하여 해당하는 게시글을 검색
		// 수정하고 싶은 게시글 선택
		// 날짜,제목,내용을 입력받고, 수정이 완료되도록.

		// 게시글 삭제.
		// 제목 또는 날짜를 검색하여 해당하는 게시글을 검색
		// 삭제하고 싶은 게시글 선택
		// 삭제처리

		// 게시글 조회.
		// 제목 또는 날짜를 검색하여 해당하는 게시글을 검색
		// 조회하고 싶은 게시글 선택
		// 해당 게시글 출력
		// 엔터를 눌러 메뉴로 다시 돌아가도록 할 것.

	}

	@Override
	public void printMenu() {

		System.out.println("-----메뉴-----");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 검색");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴 선택 : ");

	}

	@Override
	public void run() {

		int menu;

		load(fileName);

		do {

			printMenu();
			menu = scan.nextInt();

			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생하였습니다.");
				e.printStackTrace();
			}

		} while ( menu != EXIT );

		save(fileName);

	}

	public void save(String fileName) {

	}

	public void load(String fileName) {

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
			exit();
			break;
		default:

		}

	}

	private void exit() {
		System.out.println("----------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------");
	}

	private void search() {
		// 검색어 입력
		scan.nextLine(); // 공백 제거
		String tmp = scan.nextLine();
		// 게시글에서 검색어가 제목 또는 내용에 들어간 게시글 리스트를 가져온다.
		List<Board> tmps = list.stream().filter(b->b.getTitle().contains(tmp) || b.getDetail().contains(tmp))
				.collect(Collectors.toList());
		// 게시글 리스트가 비어있으면 안내문구 출력 후 종료.
		if (tmps.size() == 0) {
			System.out.println("해당하는 게시글이 없습니다.");
			return;
		}
		// 가져온 게시글 리스트를 출력한다.
		for ( int i = 0; i < list.size() ; i++ ) {
			System.out.println((i+1) + ". " + tmps.get(i));
		}
		// 게시글을 확인할 것인지 선택.
		System.out.println("---------------");
		System.out.println("게시글을 확인하시겠습니까? (y/n) : ");
		System.out.println("---------------");
		
		char chr = scan.next().charAt(0);
		
		// 확인하지 않겠다고 하면 종료.
		if( chr == 'n') {
			System.out.print("확인을 종료합니다.");
		}
		// 확인하면 게시글 번호를 입력 받는다.
		else if( chr == 'y' ) { 
			System.out.println("확인할 게시글의 번호 입력 : ");
			int num = scan.nextInt();
		// 입력받은 게시글 번호로 객체를 생성
			Board b1 = new Board(num);
		// 검색 리스트에서 생성된 객체와 일치하는 번지를 확인
			int index = list.indexOf(b1);
		// 번지가 유효하지 않으면 안내문구 출력 후 종료
			if(index < 0) {
				System.out.println("등록되지 않거나 삭제된 게시글입니다. ");
			}
		// 번지에 있는 게시글을 가져온다.
			
		// 가져온 게시글을 출력
			System.out.println(b1);
		// 메뉴로 돌아가려면 ... 문구 출력
		}
		
		System.out.println("--------------------------");
		System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
		System.out.println("--------------------------");

		// 엔터를 입력받도록 처리
		scan.nextLine();
	}

	private void delete() {

		// 삭제할 게시글 번호를 입력
		System.out.print("삭제할 게시글의 번호 입력 : ");
		int num = scan.nextInt();
		
		// 게시글 번호에 맞는 게시글을 가져온다.
		
		// 게시글이 없으면 종료

		// 리스트에서 게시글을 삭제


	}

	private void update() {

		// 수정할 게시글 번호 입력.
		// 해당 게시글 작성자 아이디와 비밀번호를 입력.
		// 제목과 내용 수정
		// 수정 전 게시글을 리스트에서 삭제.
		// 수정을 마친 제목,내용,아이디,비밀번호을 새로운 객체에 저장하고, 리스트에 추가.

		///////////////////////////////////////////////////////////////

		// 수정할 게시글 번호를 입력

		System.out.print("수정할 게시글의 번호 : ");
		int num = scan.nextInt();
		// 입력한 게시글 번호를 이용하여 게시글 객체를 생성
		Board b2 = new Board(num);
		// 리스트에서 생성한 객체가 몇 번지에 있는지 번지를 가져온다
		int index = list.indexOf(b2);
		// 일치하는 객체가 없으면 ( 가져온 번지가 0보다 작으면 ) 알림문구 출력 후 종료
		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 글입니다.");
		}
		// 아이디와 비밀번호를 입력받는다.
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pw = scan.next();
		
		// 가져온 객체의 아이디와 비밀번호가 입력받은 아이디와 비밀번호와 일치한지 확인해서
		b2 = list.get(index);
		// 같지 않으면 안내문구 출력 후 종료.

		// 같으면 새 제목과 내용을 입력.

		// 가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정

		// 안내문구 출력

	}

	private void insert() {

		// 입력을 위한 안내문구 출력 및 변수 선언. ( 게시글 정보 입력 )

		scan.nextLine();
		System.out.println("제목 : ");
		String title = scan.nextLine();
		System.out.println("내용 : ");
		String detail = scan.nextLine();
		System.out.println("작성자 : ");
		String id = scan.next();
		System.out.println("비밀번호 : ");
		String pw = scan.next();

		// 작성 내용 저장을 위한 객체 생성.

		Board b = new Board(title, detail, id, pw);

		// 리스트에 추가(저장).

		list.add(b);

		// 저장을 할 때, 번호를 부여 ( 이건 할 필요가 없다, 클래스에서 생성자 생성할 때, 설정을 다 해놓았다. )


		// 알림문구 출력.

		System.out.println("-----------------");
		// 클래스의 num 이 아니라 새로 추가된 글의 번호를 불러와야해서 객체의 이름을 적어야 한다.
		System.out.println(b.getNum() + "번 게시글이 추가되었습니다."); 
		System.out.println("-----------------");

		System.out.println(list);

	}

}
