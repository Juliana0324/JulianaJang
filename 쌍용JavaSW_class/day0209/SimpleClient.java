package day0209;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 설정한 IP주소와 포트를 가지고 서버를 찾아 연결하는 일.(Client)
 * @author user
 *
 */
public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		Socket client= null;
		DataInputStream dis = null;
		
		try {
			String ip = JOptionPane.showInputDialog("IP를 넣어주세요");
			//2. 소켓을 생성하여 서버에 연결을 시도
			client = new Socket("211.63.89."+ip, 65500);
			System.out.println("서버에 접속시도하여 접속성공");
			
			//4. 서버에서 보내오는 메세지를 읽기위해 스트림을 연결
			dis = new DataInputStream(client.getInputStream());
			
			//5.메세지를 원래대로 디코딩해서 읽어들인다
			String revMsg = dis.readUTF();
			System.out.println("서버에서 온 메세지 "+revMsg);
		
		}finally {
			if(dis!=null) {dis.close();}
			if(client!=null) {client.close();}
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
