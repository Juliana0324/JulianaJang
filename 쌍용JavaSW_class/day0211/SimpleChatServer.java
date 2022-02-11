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
	private DataInputStream disReadStream; //�������� �޼����� �б����� ��Ʈ��
	private DataOutputStream dosOutputStream; //�����ڿ��� �޼����� ������ ���� ��Ʈ��
	
	public SimpleChatServer() {
		super(":::::::::ä�ü���::::::::::");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jtfTalk=new JTextField();
		
		jtaTalkDisplay.setEditable(false);

		jspJtaTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		jtfTalk.setBorder(new TitledBorder("��ȭ"));
		
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
			jtaTalkDisplay.setText("���� ������..\n �����ڰ� �����⸦ ��ٸ�\n");
			
			
			client = server.accept(); //������ ������ �޴´�
			jtaTalkDisplay.append("������ ����\n");
			disReadStream= new DataInputStream(client.getInputStream());
			dosOutputStream = new DataOutputStream(client.getOutputStream());
			jtaTalkDisplay.append("��ſ� ä�õǼ���\n");
//			run();
			Thread thread = new Thread(this);
			thread.run();
		}
	}
	
	private void setScrollBar() {
		//��ũ�ѹ��� �ִ� ����
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
	}//setScrollbar
	
	public void run() {
		try {
			while(true){
				jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
				setScrollBar();
			}			
		}catch (IOException e) {
			jtaTalkDisplay.append("��ȭ��밡 ä���� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
		
	}//readMsg
	
	public void sendMsg() throws IOException{
		String msg = jtfTalk.getText();
		//�г���
		dosOutputStream.writeUTF("�Ǹ����� :"+ msg);
		dosOutputStream.flush();
		
		jtaTalkDisplay.append("�Ǹ����� : "+msg+"\n");
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
