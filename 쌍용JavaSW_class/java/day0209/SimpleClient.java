package day0209;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * ������ IP�ּҿ� ��Ʈ�� ������ ������ ã�� �����ϴ� ��.(Client)
 * @author user
 *
 */
public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		Socket client= null;
		DataInputStream dis = null;
		
		try {
			String ip = JOptionPane.showInputDialog("IP�� �־��ּ���");
			//2. ������ �����Ͽ� ������ ������ �õ�
			client = new Socket("211.63.89."+ip, 65500);
			System.out.println("������ ���ӽõ��Ͽ� ���Ӽ���");
			
			//4. �������� �������� �޼����� �б����� ��Ʈ���� ����
			dis = new DataInputStream(client.getInputStream());
			
			//5.�޼����� ������� ���ڵ��ؼ� �о���δ�
			String revMsg = dis.readUTF();
			System.out.println("�������� �� �޼��� "+revMsg);
		
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
