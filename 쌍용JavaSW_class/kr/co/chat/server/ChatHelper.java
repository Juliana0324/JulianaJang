package kr.co.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import day0211.ChatClient;

/**
 * ������ ������ �޾� �޼����� ������ �б����� Stream�� �����ϰ�
 * �޼����� ������ �Ͱ� ���ÿ� �����ϱ� ���ؼ� Thread�� �����Ͽ� �ڵ��Ѵ�.
 * @author user
 *
 */
public class ChatHelper extends Thread {

	private String nickName;
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	private DefaultListModel<String> dlmServerMoniter;
	private int count;
	private JScrollPane jspServerMoniter;
	
	public ChatHelper(Socket client, DefaultListModel<String> dlmServerMoniter, String nickName, JScrollPane jspServerMoniter) throws IOException{
		
		this.someClient = client;
		this.dlmServerMoniter = dlmServerMoniter;
		this.nickName = nickName;
		this.jspServerMoniter = jspServerMoniter;
		
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		//������ ����Ϳ� �����ڰ� �������� ������
		dlmServerMoniter.addElement(nickName+"���� �����Ͽ����ϴ�.");
		//ip������ ����
		dlmServerMoniter.addElement(nickName+"���� ������ ����["+someClient.getInetAddress()+"]");
		setScrollbar();
		
		//��� �����ڿ��� ���� �����ڰ� �������� �˷��ش�
		broadcast(nickName+"��° �����ڰ� �����Ͽ����ϴ�.");
	}	
	
	private void setScrollbar() {
		jspServerMoniter.getVerticalScrollBar().setValue(jspServerMoniter.getVerticalScrollBar().getMaximum());
	}
	
	/**
	 * �޼����� ���ѷ����� �о�鿩, ��� �����ڿ��� �����ش�
	 */
	@Override
	public void run() { //chatserver run�޼ҵ忡�� startȣ��
		String revMsg = "";
		try {
			while (true) {
				revMsg = disReadStream.readUTF();//�޼����� �о�鿩
				broadcast(revMsg);
			}//while
		}catch (IOException ie) {
			//�޼����� �о������ ���ϴ� ���´� �����ڰ� ������ ������ ����
			//�����ڸ� �����ϴ� ����Ʈ���� ���� ��ü�� ����,
			ChatServer.connectList.remove(this);
			
			//����â�� �����ڰ� �������� �˷��ش�
			dlmServerMoniter.addElement(count+"��° �����ڰ� ����Ͽ����ϴ�.");
			setScrollbar();
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
