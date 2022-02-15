package day0211;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * ������ ������ �޾� �޼����� ������ �б����� Stream�� �����ϰ�
 * �޼����� ������ �Ͱ� ���ÿ� �����ϱ� ���ؼ� Thread�� �����Ͽ� �ڵ��Ѵ�.
 * @author user
 *
 */
public class ChatHelper extends Thread {
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	private DefaultListModel<String> dlmServerMoniter;
	private int count;
	
	public ChatHelper(Socket client, DefaultListModel<String> dlmServerMoniter, int cnt) throws IOException{
		
		this.someClient = client;
		this.dlmServerMoniter = dlmServerMoniter;
		this.count = cnt;
		
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		//������ ����Ϳ� �����ڰ� �������� ������
		dlmServerMoniter.addElement(cnt+"��° �����ڰ� �����Ͽ����ϴ�.");
		//ip������ ����
		dlmServerMoniter.addElement(cnt+"��° ������ ����["+someClient.getInetAddress()+"]");
		
		//��� �����ڿ��� ���� �����ڰ� �������� �˷��ش�
		broadcast(cnt+"��° �����ڰ� �����Ͽ����ϴ�.");
	}	
	
	/**
	 * �޼����� ���ѷ����� �о�鿩, ��� �����ڿ��� �����ش�
	 */
	@Override
	public void run() { //chatserver run�޼ҵ忡�� startȣ��
		String revMsg = "";
		try {
			while (true) {
				revMsg = disReadStream.readUTF()+"\n";//�޼����� �о�鿩
				broadcast(revMsg);
			}//while
		}catch (IOException ie) {
			//�޼����� �о������ ���ϴ� ���´� �����ڰ� ������ ������ ����
			//�����ڸ� �����ϴ� ����Ʈ���� ���� ��ü�� ����,
			ChatServer.connectList.remove(this);
			//����â�� �����ڰ� �������� �˷��ش�
			dlmServerMoniter.addElement(count+"��° �����ڰ� ����Ͽ����ϴ�.");
			try {
				broadcast(count+"��° �����ڰ� ����Ͽ����ϴ�.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ie.printStackTrace();
		}
		
	}//run
	
	/**
	 * �Է¹��� �޼����� ��� �����ڿ��� �����ִ� ��
	 * @param msg �����ڵ鿡�� ������ �޼���
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) throws IOException{
		for(ChatHelper ch : ChatServer.connectList) {
			//��� �����ڿ��� �޼��� ������
			ch.dosWriteStream.writeUTF(msg);
		}
	}//broadcast
	
}
