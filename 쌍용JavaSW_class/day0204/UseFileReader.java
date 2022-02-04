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
 * 16bit ��Ʈ���� ����� �ٴ��� �б�
 * @author user
 *
 */
public class UseFileReader extends JFrame{
	
	public void readFile() throws IOException {
		FileDialog fd = new FileDialog(this, "���ϼ���", FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory();
		String name = fd.getFile();
		
		//1. ������ ������ ������ ��� ��ü����
		File file = new File(path + name);
		if(file.exists()) {
			BufferedReader br = null;
			try {
				//���Ͽ� �����ϴ� ����� ���� ��Ʈ���� �����ؾ���
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
			JOptionPane.showMessageDialog(this, file+"������ �������� ����");
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
