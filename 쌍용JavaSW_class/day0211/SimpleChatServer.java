package day0211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener,Runnable {
	
	private JTextArea jtaTalkDisplay;
	private JTextField jtfTalk;
	private JScrollPane jspJtaTalkDisplay;
	private ServerSocket server;
	private Socket client;
	private DataInputStream disReadStream; //접속자의 메세지를 읽기위한 스트림
	private DataOutputStream dosOutputStream; //접속자에게 메세지르 보내기 위한 스트림
	
	public SimpleChatServer() {
		super(":::::::::채팅서버::::::::::");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jtfTalk=new JTextField();
		
		jtaTalkDisplay.setEditable(false);

		jspJtaTalkDisplay.setBorder(new TitledBorder("대화내용"));
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		add("Center",jspJtaTalkDisplay);
		add("South",jtfTalk);
		setBounds(100, 100, 400, 600);
		setVisible(true);
		
		try {
			openServer();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		jtfTalk.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {				
				dispose();
			}//windowClosing

			@Override
			public void windowClosed(WindowEvent wed) {
				try {
					if(disReadStream != null) {disReadStream.close();}
					if(dosOutputStream != null) {dosOutputStream.close();}
					if(client != null) {client.close();}
					if(server != null) {server.close();}
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					System.exit(JFrame.ABORT);
				}
			}	
			
		});

		
	}//SimpleChatServer

	private void openServer() throws IOException {
		if(server == null) {
			server= new ServerSocket(50000);
			jtaTalkDisplay.setText("서버 가동중..\n 접속자가 들어오기를 기다림\n");
			
			
			client = server.accept(); //접속자 들어오면 받는다
			jtaTalkDisplay.append("접속자 들어옴\n");
			disReadStream= new DataInputStream(client.getInputStream());
			dosOutputStream = new DataOutputStream(client.getOutputStream());
			jtaTalkDisplay.append("즐거운 채팅되세요\n");
//			run();
			Thread thread = new Thread(this);
			thread.run();
		}
	}
	
	private void setScrollBar() {
		//스크롤바의 최대 높이
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
	}//setScrollbar
	
	public void run() {
		try {
			while(true){
				jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
				setScrollBar();
			}			
		}catch (IOException e) {
			jtaTalkDisplay.append("대화상대가 채팅을 종료하였습니다.");
			e.printStackTrace();
		}
		
	}//readMsg
	
	public void sendMsg() throws IOException{
		String msg = jtfTalk.getText();
		//닉네임
		dosOutputStream.writeUTF("또리눈나 :"+ msg);
		dosOutputStream.flush();
		
		jtaTalkDisplay.append("또리눈나 : "+msg+"\n");
		jtfTalk.setText("");
		setScrollBar();
	}//sendMsg
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			sendMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//actionPerformed

	public static void main(String[] args) {
		new  SimpleChatServer();
	}//main

}//class
