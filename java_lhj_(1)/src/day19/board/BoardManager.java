package day19.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class BoardManager implements Program {

	private Scanner scan = new Scanner(System.in);
	private List<Board> list = new ArrayList<Board>();

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	private String fileName = "src/day19/board/data.txt";

	public static void main(String[] args) {

	}

	@Override
	public void printMenu() {

	}

	@Override
	public void run() {
		int menu;

		load(fileName);

		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 선택한 메뉴 실행
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
		} while (menu != EXIT);

		save(fileName);

	}

	@Override
	public void save(String fileName) {

	}

	@Override
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
		
		// 게시글에서 검색어가 제목 또는 내용에 들어간 게시글 리스트를 가져온다.
		
		// 게시글 리스트가 비어있으면 안내문구 출력 후 종료.
		
		// 가져온 게시글 리스트를 출력한다.
		
		// 게시글을 확인할 것인지 선택.

		// 확인하지 않겠다고 하면 종료.
		
		// 확인하면 게시글 번호를 입력 받는다.
		
		// 입력받은 게시글 번호로 객체를 생성
		
		// 검색 리스트에서 생성된 객체와 일치하는 번지를 확인
		
		// 번지가 유효하지 않으면 안내문구 출력 후 종료
		
		// 번지에 있는 게시글을 가져온다.
		
		// 가져온 게시글을 출력
		
		// 메뉴로 돌아가려면 ... 문구 출력
		
		// 엔터를 입력받도록 처리
		
	}

	private void delete() {
		
		// 삭제할 게시글 번호를 입력
		
		// 게시글 번호에 맞는 게시글을 가져온다.
		
		// 게시글이 없으면 종료
		
		// 리스트에서 게시글을 삭제
		
	}

	private void update() {
		
		// 수정할 게시글 번호를 입력
		System.out.print("수정할 게시글 번호");
		int num = scan.nextInt();
		
		Board b = selectBoard(num);
		if(b == null) {
			return;
		}
		
		// 같으면 새 제목과 내용을 입력.
		scan.nextLine(); // 공백처리
		System.out.print("아이디 : ");
		String title = scan.nextLine();
		System.out.print("비밀번호 : ");
		String detail = scan.nextLine();
		
		// 가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		b.update(title, detail);
		
		// 안내문구 출력
		System.out.println("----------");
		System.out.println(b.getNum() + "번 게시글이 수정되었습니다.");
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
	
	// 게시글 번호가 주어지면
	
	public Board selectBoard(int num) {
	// 입력한 게시글 번호를 이용하여 게시글 객체를 생성 ( Main 에서
			Board b = new Board(num);
			
			// 리스트에서 생성한 객체가 몇 번지에 있는지 번지를 가져온다
			int index = list.indexOf(b);
			
			// 일치하는 객체가 없으면 ( 가져온 번지가 0보다 작으면 ) 알림문구 출력 후 종료
			if(index < 0) {
				System.out.println("----------");
				System.out.println("등록되지 않거나 삭제된 게시글입니다.");
				return null;
			}
			
			// 아이디와 비밀번호를 입력받는다.
			System.out.print("아이디 : ");
			String id = scan.next();
			System.out.print("비밀번호 : ");
			String pw = scan.next();
			
			// 가져온 객체의 아이디와 비밀번호가 입력받은 아이디와 비밀번호와 일치한지 확인해서
			b = list.get(index);
			// 같지 않으면 안내문구 출력 후 종료.
			if(!b.checkWriter(id,pw)) {
				System.out.println("----------");
				System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
				return null;
			}
			return b;
	}
}
