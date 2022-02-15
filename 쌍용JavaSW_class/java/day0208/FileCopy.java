package day0208;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FileCopy extends JFrame{
	private JButton copyFile;
	private JLabel jlblOutput;
	private FileCopy fc;
	
	public FileCopy() {
		super("파일복시");
		
		jlblOutput = new JLabel("출력");
		copyFile = new JButton("파일복사");
		
		jlblOutput.setFont(new Font("궁서체", Font.BOLD, 20));
		fc = this;
		copyFile.addActionListener(new BtnEventProcess());
		
		JPanel jpCenter= new JPanel();
		jpCenter.add(copyFile);
		
		add("Center", jpCenter);
		add("South", jlblOutput);
		
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//버튼이벤트 위한 inner class
	public class BtnEventProcess implements ActionListener{
		public void copyFile(File originalFile) throws IOException{
			//스트림연결
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				//원본파일 스트림연결
				fis = new FileInputStream(originalFile);
				
				//2. 복사 파일명 : 원본파일명_copy의 이름으로 설정
				StringBuilder copyFileName =new StringBuilder(originalFile.getAbsolutePath());
				copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");
				
				File copyFiles = new File(copyFileName.toString());
				//3. 출력스트림 생성
				fos = new FileOutputStream(copyFiles);
				jlblOutput.setText(copyFiles.getAbsolutePath());
				
				//5.데이터 읽기
				byte[] data = new byte[512];
				int dataSize = 0;
				while ((dataSize=fis.read(data) )!= -1) {
					//6.배열에 저장된 데이터의 크기를 스트림에 기록
					fos.write(data,0,dataSize);
				}
				
				
///////////////////////////////////(성능저하)HDD를 고려하지 않는 코드///////////////////////////////////////////////////////////////////////
//				//원본파일에서 1byteㅅ씩 읽어들여
//				int readData = 0;
//				while((readData = fis.read())!=-1) {
//					//복사할 파일에 쓴다. (추력할 파일에 연결된 스트림에 쓴다)
//					fos.write(readData);
//				}
//				//6.스트림에 남아있는 데이터를 분출
//				fos.flush();
//				JOptionPane.showMessageDialog(fc, copyFileName.toString()+"이 만들어졌습니다");
			}finally {
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			}
		}
		
		//16byte사용 - txt파일은 상관없지만 이미지같은경우애는 복사가 안됨
		public void copyFile16(File originalFile) throws IOException{
			//스트림연결
			BufferedReader br = null;
			FileWriter fw = null;
			
			try {
				//원본파일 스트림연결
				br = new BufferedReader(new FileReader(originalFile));
				
				//2. 복사 파일명 : 원본파일명_copy의 이름으로 설정
				StringBuilder copyFileName =new StringBuilder(originalFile.getAbsolutePath());
				copyFileName.insert(copyFileName.lastIndexOf("."), "_copy16");
				
				File copyFiles = new File(copyFileName.toString());
				//3. 출력스트림 생성
				fw = new FileWriter(copyFiles);
				jlblOutput.setText(copyFiles.getAbsolutePath());
				
				
				//원본파일에서 1byteㅅ씩 읽어들여
				String readData = "";
				while((readData = br.readLine())!=null) {
					//복사할 파일에 쓴다. (추력할 파일에 연결된 스트림에 쓴다)
					fw.write(readData);
				}
				//6.스트림에 남아있는 데이터를 분출
				fw.flush();
				JOptionPane.showMessageDialog(fc, copyFileName.toString()+"이 만들어졌습니다");
			}finally {
				if(fw != null) {
					fw.close();
				}
				if(br != null) {
					br.close();
				}
			}
		}
		public void openDialog() {
			FileDialog fdOpen = new FileDialog(fc, "파일선택", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			
			File originalFile = new File(path+name);
			if(originalFile.exists()) {
				//파일 복사
				try {
					copyFile( originalFile );
				} catch (IOException ie) {
					JOptionPane.showMessageDialog(fc, "파일복사중 문제 발생!");
					ie.printStackTrace();
				}
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			openDialog();
		}		
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
