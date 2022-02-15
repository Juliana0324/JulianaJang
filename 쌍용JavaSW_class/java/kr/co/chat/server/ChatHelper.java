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
 * 접속자 소켓을 받아 메세지를 보내고 읽기위한 Stream을 연결하고
 * 메세지를 보내는 것과 동시에 실행하기 위해서 Thread를 도입하여 코딩한다.
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
		
		//관리자 모니터에 접속자가 들어왔음을 보여줌
		dlmServerMoniter.addElement(nickName+"님이 접속하였습니다.");
		//ip접속자 저보
		dlmServerMoniter.addElement(nickName+"님의 접속자 정보["+someClient.getInetAddress()+"]");
		setScrollbar();
		
		//모든 접속자에게 현재 접속자가 들어왔음을 알려준다
		broadcast(nickName+"번째 접속자가 접속하였습니다.");
	}	
	
	private void setScrollbar() {
		jspServerMoniter.getVerticalScrollBar().setValue(jspServerMoniter.getVerticalScrollBar().getMaximum());
	}
	
	/**
	 * 메세지를 무한루프로 읽어들여, 모든 접속자에게 보내준다
	 */
	@Override
	public void run() { //chatserver run메소드에서 start호출
		String revMsg = "";
		try {
			while (true) {
				revMsg = disReadStream.readUTF();//메세지를 읽어들여
				broadcast(revMsg);
			}//while
		}catch (IOException ie) {
			//메세지를 읽어들이지 못하는 상태는 접속자가 접속을 종료한 상태
			//접속자를 관리하는 리스트에서 현재 객체를 삭제,
			ChatServer.connectList.remove(this);
			
			//서버창에 접속자가 나갔음을 알려준다
			dlmServerMoniter.addElement(count+"번째 접속자가 퇴실하였습니다.");
			setScrollbar();
			try {
				broadcast(count+"번째 접속자가 퇴실하였습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ie.printStackTrace();
		}
		
	}//run
	
	/**
	 * 입력받은 메세지를 모든 접속자에게 보내주는 일
	 * @param msg 접속자들에게 보내줄 메세지
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) throws IOException{
		for(ChatHelper ch : ChatServer.connectList) {
			//모든 접속자에게 메세지 날려줌
			ch.dosWriteStream.writeUTF(msg);
		}
	}//broadcast
	
}
