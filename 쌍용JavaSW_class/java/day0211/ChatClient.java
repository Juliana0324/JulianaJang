package day0211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNickName, jtfTalkInput;
	private JButton jbtnConnectServer, jbtnCapture;
	
	private JScrollPane jspJtaTalkDisplay;
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosReadStream;
	
	private Thread threadClient;
	
	public ChatClient() {
		super("::::::::::::: ä�� Ŭ���̾�Ʈ :::::::::::::::::::");
		jtfServerIp=new JTextField("211.63.89.",8);
		jtfNickName=new JTextField(10);
		jtfTalkInput=new JTextField();
		
		jbtnConnectServer=new JButton("��������");
		jbtnCapture=new JButton("��ȭ����");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkDisplay=new JScrollPane( jtaTalkDisplay );
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("�����ּ�"));
		jpNorth.add( jtfServerIp);
		jpNorth.add(new JLabel("��ȭ��"));
		jpNorth.add( jtfNickName);
		jpNorth.add( jbtnConnectServer);
		jpNorth.add( jbtnCapture);
		
		jpNorth.setBorder(new TitledBorder("��������"));
		jspJtaTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		jtfTalkInput.setBorder(new TitledBorder("��ȭ"));
		
		add("North", jpNorth );
		add("Center", jspJtaTalkDisplay );
		add("South",jtfTalkInput);

		jbtnCapture.addActionListener(this);
		jbtnConnectServer.addActionListener(this);
		jtfTalkInput.addActionListener(this);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing

			@Override
			public void windowClosed(WindowEvent we) {
			}//windowClosed
			
		});
		
		setBounds(100, 100, 700, 500);
		setVisible(true);
		
	}//ChatClient
	
	@Override
	public void run() {
		while(true) {
			try {
				jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�.");
			}
		}
	}//run

	private void talkCapture() throws IOException{
		File directory = new File("e:/javachat/capture/");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(directory.getAbsoluteFile()+"/cap_"+System.currentTimeMillis()+".dat");
		System.out.println(file);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnCapture) {
			try {
				talkCapture();
			}catch (IOException ie) {
				ie.printStackTrace();
			}
		}
		
		if(e.getSource() == jbtnConnectServer) { //��������
			
		}
		if(e.getSource() == jtfTalkInput) {
			
		}
	}//actionPerformed

	public static void main(String[] args) {
		new ChatClient();
	}//main

}//class
