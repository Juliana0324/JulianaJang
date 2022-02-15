package kr.co.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
	private DataOutputStream dosWriteStream;
	
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
				try {
					if(disReadStream!=null) {disReadStream.close();}
					if(dosWriteStream!=null) {dosWriteStream.close();}
					if(someClient!=null) {someClient.close();}
				}catch (IOException ie) {
					ie.printStackTrace();
				}finally {
					System.exit(JFrame.ABORT);
				}
			}//windowClosed
			
		});
		
		setBounds(100, 100, 700, 500);
		setVisible(true);
		
	}//ChatClient
	
	@Override
	public void run() {
		try {
			while(true) {
				jtaTalkDisplay.append(disReadStream.readUTF());
				jtaTalkDisplay.append("\n");
				//��ȭâ ��ũ�ѹ� ���� �Ʒ��� ����
				jspJtaTalkDisplay.getVerticalScrollBar().setValue(jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�.");
		}
	}//run
	
	private void talkCapture() throws IOException{
		File directory = new File("e:/javachat/capture/");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(directory.getAbsoluteFile()+"/cap_"+System.currentTimeMillis()+".dat");
		System.out.println(file);
		
		BufferedWriter bw = null;
		try {
			//ĸ�������� �����ϱ� ���� ��Ʈ�� ����
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(jtaTalkDisplay.getText());
			bw.flush();
			JOptionPane.showMessageDialog(this, file.getName()+"�� ��ȭ������ ����Ǿ����ϴ�.");
		}finally {
			if(bw!=null) {
				bw.close();
			}
		}
	
	}
	
	private void connectToServer() throws UnknownHostException, IOException {
		if(someClient != null && someClient.isConnected()) {
			JOptionPane.showMessageDialog(this, "������ ���ӵǾ��ֽ��ϴ�.");
			return;
		}//end if
		//������ �����Ͽ� ������ �����ϰ� 
		String serverIpAddress = jtfServerIp.getText().replaceAll(" ", "");
		someClient = new Socket(serverIpAddress, 25000);
		//��Ʈ���� �����Ͽ� �����͸� �аų� ������ �ֵ��� �����
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		//�����͸� �о���ϼ� �ִ� ����(������)
		threadClient = new Thread(this);
		threadClient.start(); //=>run
	
		jtaTalkDisplay.setText("������ �����Ͽ����ϴ�.\n��ſ� ä�õǼ���\n");
		
		//Ŀ���� ��ȭ�Է�â�� �ֱ�
		jtfTalkInput.requestFocus();
	}
	
	private void sendMsg() throws IOException {
		String talk = jtfTalkInput.getText();
		String nick = jtfNickName.getText();
		//�����ڿ��� �޼����� ������
		dosWriteStream.writeUTF("["+nick+"] "+talk);

		jtfTalkInput.setText("");
		dosWriteStream.flush();
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
			try {
				connectToServer();
			}catch (UnknownHostException ue) {
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
				ue.printStackTrace();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == jtfTalkInput) {
			try {
				sendMsg();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
				e1.printStackTrace();
			}
		}
	}//actionPerformed

	public static void main(String[] args) {
		new ChatClient();
	}//main
	
	
	public JTextField getJtfNickName() {
		return jtfNickName;
	}
}//class
