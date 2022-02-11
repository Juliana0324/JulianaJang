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
		super("::::::::::::: 채팅 클라이언트 :::::::::::::::::::");
		jtfServerIp=new JTextField("211.63.89.",8);
		jtfNickName=new JTextField(10);
		jtfTalkInput=new JTextField();
		
		jbtnConnectServer=new JButton("서버접속");
		jbtnCapture=new JButton("대화저장");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkDisplay=new JScrollPane( jtaTalkDisplay );
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("서버주소"));
		jpNorth.add( jtfServerIp);
		jpNorth.add(new JLabel("대화명"));
		jpNorth.add( jtfNickName);
		jpNorth.add( jbtnConnectServer);
		jpNorth.add( jbtnCapture);
		
		jpNorth.setBorder(new TitledBorder("접속정보"));
		jspJtaTalkDisplay.setBorder(new TitledBorder("대화내용"));
		jtfTalkInput.setBorder(new TitledBorder("대화"));
		
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
				//대화창 스크롤바 가장 아래로 내림
				jspJtaTalkDisplay.getVerticalScrollBar().setValue(jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버가 접속을 종료하였습니다.");
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
			//캡쳐파일을 저장하기 위해 스트림 연결
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(jtaTalkDisplay.getText());
			bw.flush();
			JOptionPane.showMessageDialog(this, file.getName()+"로 대화내용이 저장되었습니다.");
		}finally {
			if(bw!=null) {
				bw.close();
			}
		}
	
	}
	
	private void connectToServer() throws UnknownHostException, IOException {
		if(someClient != null && someClient.isConnected()) {
			JOptionPane.showMessageDialog(this, "서버에 접속되어있습니다.");
			return;
		}//end if
		//소켓을 생성하여 서버에 접속하고 
		String serverIpAddress = jtfServerIp.getText().replaceAll(" ", "");
		someClient = new Socket(serverIpAddress, 25000);
		//스트림을 연결하여 데이터를 읽거나 보낼수 있도록 만들고
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		//데이터를 읽어들일수 있는 상태(스레드)
		threadClient = new Thread(this);
		threadClient.start(); //=>run
	
		jtaTalkDisplay.setText("서버에 접속하였습니다.\n즐거운 채팅되세요\n");
		
		//커서를 대화입력창에 넣기
		jtfTalkInput.requestFocus();
	}
	
	private void sendMsg() throws IOException {
		String talk = jtfTalkInput.getText();
		String nick = jtfNickName.getText();
		//접속자에게 메세지를 보내자
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
		
		if(e.getSource() == jbtnConnectServer) { //서버접속
			try {
				connectToServer();
			}catch (UnknownHostException ue) {
				JOptionPane.showMessageDialog(this, "서버가 존재하지 않습니다.");
				ue.printStackTrace();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == jtfTalkInput) {
			try {
				sendMsg();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "서버가 존재하지 않습니다.");
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
