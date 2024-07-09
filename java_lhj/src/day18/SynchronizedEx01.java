package day18;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronizedEx01 {

	public static void main(String[] args) {
		// 은행 잔고를 통한 동기화 메소드 예제
		
		BankBook bankBook = new BankBook("홍길동", 0);
		CustomerAction1 c1 = new CustomerAction1("홍길동", bankBook);
		CustomerAction1 c2 = new CustomerAction1("홍동길", bankBook);
		
		c1.start();
		c2.start();
	}

}

@AllArgsConstructor

class CustomerAction1 extends Thread {
	private String name;
	private BankBook bankBook;
	
	@Override
	public void run() {
		System.out.println(name + "님이 입금 중 입니다.");
		bankBook.deposit(name, 10000);
	}
	
}

@Data
@AllArgsConstructor

class BankBook {
	
	private String name;
	private int balance;
	
	// 입금 기능
	public synchronized void deposit(String name, int money) {
		this.balance += money;
		
		// 현재 스레드를 2초간 정지.
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("이름 : " + name);
		System.out.println(name + " : " + money + " : " + this.balance + "원");
	}
}
