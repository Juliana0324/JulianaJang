package kr.co.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.chat.client.ChatClient;



@SuppressWarnings("serial")
public class ChatServer extends JFrame implements ActionListener, Runnable {

	private JButton jbtnOpenServer, jbtnClose;
	
	private JScrollPane jspServerMonitor;
	private JList<String> jlServerMonitor;
	private DefaultListModel<String> dlmServerMonitor;
		
	private Thread serverThread;
	public static List<ChatHelper> connectList;
	private ServerSocket server;
	
	ChatClient c = new ChatClient();
	
	public ChatServer() {
		super(":::::::채팅방 관리자::::::::::");
		
		connectList = new ArrayList<ChatHelper>();
		
		 jbtnOpenServer=new JButton("서버가동");
		 jbtnClose=new JButton("서버 종료");
			
		dlmServerMonitor=new DefaultListModel<String>();
		
		jlServerMonitor=new JList<String>( dlmServerMonitor );
		jspServerMonitor=new JScrollPane( jlServerMonitor);
				
		jspServerMonitor.setBorder(new TitledBorder("접속자 정보"));
		
		JPanel jpSouth=new JPanel();
		
		jpSouth.add( jbtnOpenServer);
		jpSouth.add( jbtnClose);
		
		add("Center",jspServerMonitor);
		add("South", jpSouth);
		
		jbtnClose.addActionListener(this);
		jbtnOpenServer.addActionListener(this);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing

			@Override
			public void windowClosed(WindowEvent we) {
				try {
					if(server!= null) {server.close();}
					System.exit(JFrame.ABORT);
				}catch (IOException ie) {
					ie.printStackTrace();
				}
			}//windowClosed
			
		});
		
		setBounds(100,100,500, 800);
		setVisible(true);
		
	}//ChatServer
	
	/**
	 * 접속자 소켓을 받고, 헬퍼에 넣고 접속자가 보내오는 메세지를 읽을수 있는 상태로 만들기
	 * 
	 */
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(25000);//포트연다
			dlmServerMonitor.addElement("서버가 가동중입니다.");
			
			ChatHelper helper = null;
			for(int cnt=0;connectList.size()<20;cnt++) {
				//접속자 들어오면 받아주기
				helper = new ChatHelper(server.accept(), dlmServerMonitor, c.getJtfNickName().getText(), jspServerMonitor);
				connectList.add(helper);
				//생성된 helper의 대화를 읽어들여, 보내줄수 있는 상태로 만든다.
				helper.start(); //start() => run
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
	}//run

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnClose) {
			dispose();
		}
		if(e.getSource() == jbtnOpenServer) {
			
			if(serverThread != null) {
				JOptionPane.showMessageDialog(this,"서버가 이미 가동중입니다.");
				return;
			}//if
			
			serverThread = new Thread(this);
			serverThread.start();
			
		}
	}//actionPerformed

	public static void main(String[] args) {
		new ChatServer();
	}//main

}//class
