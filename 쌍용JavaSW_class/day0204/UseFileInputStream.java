package day0204;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UseFileInputStream {
	
	public UseFileInputStream() throws IOException {
		File file = new File("E:/dev/temp/java_read.txt");
		if(file.exists()) {
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(file); //���Ͽ� ��Ʈ���� ����Ͽ� �����ϰ�
				
				//����� ���Ͽ��� ���� 1byte�� �о����
//				int data = fis.read(); //����� ��Ʈ������ 1byte�������´�
//				System.out.println("�о���� ������: "+(char)data );
				
				//����� ���Ͽ��� ��� �����͸� 1byte�� �о�帰��
				BufferedReader br = new BufferedReader(new FileReader(file));
				int data =0;
				while((data = fis.read())!= -1) {
					System.out.print((char)data);
				}
				
			} finally {
				if(fis!= null) {
					fis.close();					
				}
			}
			
		}else {
			System.out.println(file.getAbsolutePath() + "�� �������� �ʽ��ϴ�.");
		}
	}
		
	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
