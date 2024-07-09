package shoppingBag;

import java.util.Scanner;

import program.Program;

public class ShoppingBagManeger implements Program {

	private Scanner scan = new Scanner(System.in);
	
	private String fileName = "src/shoppingBag/data.txt";
	
	public static void main(String[] args) {

	}

	@Override
	public void printMenu() {
		System.out.println("장바구니 메뉴");
		System.out.println("1. 장바구니 확인");
		System.out.println("2. 장바구니 선택삭제");
		System.out.println("3. 장바구니 전체삭제");
		System.out.println("4. 이전으로");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {

		case 1: check();
		
		break;

		case 2: selectAndDelete();
		
		break;

		case 3: deleteAll();
			
		break;

		case 4: exit();
			
		break;
			
		}
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

		} while ( menu != 4 );

		save(fileName);
		
	}

	private void check() {
		// 고객의 장바구니를 확인하는 메소드
		// 아이디 입력 시, 상품의 번호(순서), 이름, 가격, 전체 상품가격의 합계 출력.
	}

	private void selectAndDelete() {
		// 고객의 장바구니를 확인 후, 고객의 희망에 따라 일부 물품을 삭제하는 메소드
		// 물품 선택 시, 확인 문구 출력 후, 삭제 또는 돌아가기.
	}

	private void deleteAll() {
		// 고객의 장바구니를 확인 후, 고객이 희망하는 경우 전체 장바구니를 비우는 메소드
		// 확인 문구 출력, 여부 선택 후, 삭제 또는 돌아가기.
	}

	private void exit() {
		// 뒤로 돌아가는 메소드
	}

}
