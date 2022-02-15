package day0204;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 16bit 스트림을 사용한 줄단위 읽기
 * @author user
 *
 */
public class UseFileReader extends JFrame{
	
	public void readFile() throws IOException {
		FileDialog fd = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory();
		String name = fd.getFile();
		
		//1. 연결할 파일의 정보를 얻는 객체생성
		File file = new File(path + name);
		if(file.exists()) {
			BufferedReader br = null;
			try {
				//파일에 연결하는 기능을 가진 스트링과 연결해야함
				br = new BufferedReader(new FileReader(file));
				String data = "";
				StringBuilder outputData = new StringBuilder();
				while((data = br.readLine())!= null) {
					outputData.append(data).append("\n");
				}
				
				JTextArea jta = new JTextArea(outputData.toString(), 10, 40);
				JScrollPane jsp = new JScrollPane(jta);
				JOptionPane.showMessageDialog(this, jsp);
				
				
			} 
			finally {
				if(br != null) {
					br.close();
				}
			}
			
		}else {
			JOptionPane.showMessageDialog(this, file+"파일이 존재하지 않음");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		UseFileReader ufr = new UseFileReader();
		try {
			ufr.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			ufr.dispose();			
		}
	}

}
