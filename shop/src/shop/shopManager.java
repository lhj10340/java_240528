package shop;

import java.util.Scanner;

import program.program;

public class shopManager implements program {

private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
	}

	@Override
	public void printMenu() {
		System.out.println("나의 장바구니");
		System.out.println("1. 장바구니 확인");
		System.out.println("2. 일부 비우기 ");
		System.out.println("3. 전체 비우기");
		System.out.println("4. 이전으로");
		System.out.println("메뉴 선택 : ");
	}
	
	@Override
	public void run() {
		
		int menu;
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			
		} while(menu != 4);
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		
		case 1:
			checkBag();
			break;
			
		case 2:
			emptySome();
			break;
			
		case 3:
			empty();
			break;
			
		case 4:
			prev();
			break;
			
		default:
			
		}
		
	}

	private void checkBag() {
		// 아이디 별로 등록된 상품의 리스트(장바구니) 및 구매의사 여부를 확인하는 메소드.
		// 아이디 입력 시, 번호·상품명·가격 출력 후, 마지막으로 가격의 총액 및 구매하기 버튼 출력.
		
		// 검색
		// 1. 이름 입력
		System.out.print("이름 : ");
		String search = scan.next();
		// 2. 입력한 이름이 포함된 연락처들을 번호와 함께 출력
		int i = 0, count = 0;
		for (Contact contact : list) {
			++i;;
			if(contact.getName().contains(search)) {
				count++;
				System.out.println(i + ". " + contact);
			}
		}

		//검색 결과가 없으면
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
	}

	private void emptySome() {
		// 아이디를 입력하여 확인된 상품의 리스트(장바구니) 중에서 일부를 선택하여 삭제하는 메소드.
		// 아이디 입력 시, 출력되는 내용은 checkBag() 와 동일.
		// 삭제를 희망하는 상품의 번호를 입력하여 해당 상품의 삭제.
		// 마지막으로 변동된 총액 출력.
		
		// 검색
		
		// 1. 이름 입력
		System.out.print("이름 : ");
		String search = scan.next();
		
		// 2. 입력한 이름이 포함된 들을 번호와 함께 출력
		int i = 0, count = 0;
		for (Contact contact : list) {
			++i;;
			if(contact.getName().contains(search)) {
				count++;
				System.out.println(i + ". " + contact);
			}
		}

		//검색 결과가 없으면
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		// 입력한 이름이 포함된 연락처들을 번호와 함께 출력
		
		// 번호를 선택
		System.out.println("삭제할 번호 : ");
		int index = scan.nextInt() - 1;
		// 선택한 번호의 연락처를 삭제

		if(list.remove(index) != null) {
			System.out.println("연락처를 삭제했습니다.");
			return;
		}
		System.out.println("연락처를 삭제하지 못했습니다.");
	
		
	}

	private void empty() {
		// 아이디를 입력하여 상품의 리스트(장바구니) 확인 후, 전체를 삭제하는 메소드.
		// 아이디 입력 시, 출력되는 내용은 checkBag() 와 동일.
		// 안내문구 출력 후, 선택 시 전체 삭제처리.
	}

	private void prev() {
		// 이전 메뉴로 이동하는 메소드
	}

	private void printBar() {
		System.out.println("------------------------------");
	}
	
}
