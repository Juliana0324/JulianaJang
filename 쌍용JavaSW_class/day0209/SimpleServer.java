package day0209;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public SimpleServer() throws IOException {
		//���� ���ϻ��� (Port�� ����) PORT�� �����̿��� �ι������ϸ� ����
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null;
//		try {
			server = new ServerSocket(65500);
			System.out.println("���� ������");
			//taskkill /pid ��ȣ
		
		while(true) {
			//2.������ ������ �㰡�Ͽ� ����
			client = server.accept();
			System.out.println("������ ����"+client.getInetAddress());
		
			//3. �����ڿ��� ������ �޼���
			String sendMsg ="[������] �ȳ��ϼ���?";
			
			//4. �����ڿ��� �޼����� ���������� ��Ʈ���� ����
			dos = new DataOutputStream(client.getOutputStream());
			
			//5. ��Ʈ���� ������ ����
			dos.writeUTF(sendMsg);
			dos.flush(); //��Ʈ���� �������� ����
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
