package day21.socket2;

import lombok.Data;

@Data

public class Client {
	
	String pNum;
	String name;
	
	public Client(String pNum, String name) {
		this.pNum = pNum;
		this.name = name;
	}

	@Override
	public String toString() {
		return "연락처 : " + pNum + " / " + "이름 : " + name;
	}
	
}
