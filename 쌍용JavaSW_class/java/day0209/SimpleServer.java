package day0209;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public SimpleServer() throws IOException {
		//서버 소켓생성 (Port가 열림) PORT는 선점이여서 두번실행하면 에러
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null;
//		try {
			server = new ServerSocket(65500);
			System.out.println("서버 가동중");
			//taskkill /pid 번호
		
		while(true) {
			//2.접속자 소켓을 허가하여 받음
			client = server.accept();
			System.out.println("접속자 있음"+client.getInetAddress());
		
			//3. 접속자에게 보내줄 메세지
			String sendMsg ="[장정우] 안녕하세요?";
			
			//4. 접속자에게 메세지를 보내기위한 스트림을 연결
			dos = new DataOutputStream(client.getOutputStream());
			
			//5. 스트림에 데이터 쓰기
			dos.writeUTF(sendMsg);
			dos.flush(); //스트림을 목적지로 분출
		}
//		}finally {
//			if(dos!= null) {dos.close();}
//			if(client!= null) {client.close();}
//			if(server!= null) {server.close();}
//		}
		
	}
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
