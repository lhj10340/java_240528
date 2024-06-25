package day20.socket4;

import java.net.Socket;

public class ClientEx04 {

	public static void main(String[] args) {
		
		int port = 5001;
		String ip = "192.168.30.213";
		
		try{
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 성공]");
			Client client = new Client(socket);
			client.receive();
			client.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
