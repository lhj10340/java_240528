package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class ClientManager implements Program {

	private Scanner scan = new Scanner(System.in);
	
	// <> 사이를 String 으로 해놓아서 연락처 추가 시, 에러 발생했다.
	// 작성해놓은 클래스가 있다면 그 클래스를 입력해야한다.
	
	private List <Client> list = new ArrayList<Client>();

	private String fileName = "src/day21/socket2/client.txt";
	
	private String ip = "192.168.30.213";
	
	private int port = 5001;
	
	public static void main(String[] args) {

		// 연락처 관리 프로그램을 구현하세요.
		// 단, 불러오기와 저장은 소켓 통신을 활용해서 작성.

		/* 메뉴 
		 * 1. 연락처 추가
		 * 2. 연락처 수정
		 * 3. 연락처 삭제
		 * 4. 연락처 확인
		 * 5. 프로그램 종료
		 * 메뉴 선택 : 
		 * */

	}

	@Override
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void run() {
		
		int menu = 1;
		
		load(fileName);
		
		do {
			
			printMenu();
			menu = scan.nextInt();
			
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외 발생!!");
			}
			
		} while (menu != 5);
		
		System.out.println("프로그램을 종료합니다.");
		
		save(fileName);
	}
	
	public void load () {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<Client>)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			load(fileName);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Client>)ois.readObject();
		} catch (Exception e) {

		} 
	}

	public void save() {
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
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {

		}
	}
	
	@Override
	public void runMenu(int menu) throws Exception {

		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			print();
			break;
		case 5:
			exit();
			break;
		default:
		}
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void print() {
		
		// 이름 입력
		scan.nextLine();
		System.out.println("이름 입력 : ");
		String tmp = scan.nextLine();
		// 이름이 없다면, 등록된 연락처가 없습니다. 출력.
		
		// 이름이 있다면, 앞에 번호와 함께 출력.
		
		// 엔터를 누르면 돌아가도록 할 것.
		
	}

	private void delete() {
		
		System.out.println("이름 입력 : ");
		String name = scan.next();
		
		List<Client> tmps = list.stream().filter(c->c.getName().contains(name))
										 .collect(Collectors.toList());
		
		if(tmps == null) {
			System.out.println("삭제할 연락처가 없습니다.");
		}
		
		for( int i = 0; i < tmps.size(); i++ ) {
			System.out.println(i+1 + ". " + tmps.get(i));
		}
		
		System.out.println("삭제할 번호 : ");
		int index = scan.nextInt() - 1;
		
		list.remove(index);
		System.out.println("번호가 삭제되었습니다.");
		
	}

	private void update() {
		
		System.out.println("이름 : ");
		String name = scan.next();
		
		List<Client> tmps = list.stream().filter(c->c.getName().contains(name))
								  	.collect(Collectors.toList());
		
		if(tmps.size() == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return;
		}
		
		for( int i = 0; i < tmps.size(); i++ ) {
			System.out.println(i+1 + ". " + tmps.get(i));
		}
		
		System.out.println("수정할 이름 입력 : ");
		String newName = scan.next();
		System.out.println("수정할 번호 입력 : ");
		String newPnum = scan.next();
		
		Client client = new Client(newName, newPnum);
		
	}

	private void insert() {
		
		// 연락처 입력, 이름 입력
		System.out.println("연락처 입력 : ");
		scan.nextLine();
		String pNum = scan.nextLine();
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		
		// 입력한 연락처와 이름이 리스트에 없다면 새로운 객체를 만들어 리스트에 추가
		
		Client c1 = new Client(pNum,name);
		
		if(list.equals(name) && list.equals(pNum)) {
			System.out.println("이미 등록된 연락처입니다.");
			return;
		}
		
		list.add(c1);
		
		// 안내문구 출력
		System.out.println("등록이 완료되었습니다.");
	}


}
