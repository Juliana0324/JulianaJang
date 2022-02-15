package day0204;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ���ڿ� �����͸� ������ ���Ϸ� ������
 * @author user
 *
 */
public class UseFileWriter {
	private FileWriter fw = null;
	private String msg = "������ ��ſ� �ݿ��� �Դϴ�.";
	private File file = new File("e:/dev/temp/write_data.txt");
	
	public void writeData() throws IOException {
		
		
		//������ �����ϸ� confirmDialog�� ���� ������ 
		if(file.exists()) {
			int ask = JOptionPane.showConfirmDialog(null, file+"�� �����Ͻðڽ��ϱ�?");
			switch(ask) {
			case JOptionPane.OK_OPTION:
				//1. ��Ʈ������
				try {
//					fw =new FileWriter(file); //��Ʈ�� �����Ǹ� ������ �����.
//					//2. ��Ʈ���� �����͸� ���
//					fw.write(msg);
//					//3. ��Ʈ���� ��ϵ� �����͸� �������� ����
//					fw.flush();
//					System.out.println("���Ϸ� �����͸� ���");
					write();
				}finally {
					//4. �޸� ��������
					if(fw!=null) {fw.close();}
				}//end try catch
				
			}//end switch
		}
		else {
			write();
		}
		
		
	}//write
	
	public void write() throws IOException {
		fw =new FileWriter(file); //��Ʈ�� �����Ǹ� ������ �����.
		//2. ��Ʈ���� �����͸� ���
		fw.write(msg);
		
		//3. ��Ʈ���� ��ϵ� �����͸� �������� ����
		fw.flush();
		System.out.println("���Ϸ� �����͸� ���");
	}

	public static void main(String[] args) {
		UseFileWriter ufw = new UseFileWriter();
		try {
			ufw.writeData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}//class
