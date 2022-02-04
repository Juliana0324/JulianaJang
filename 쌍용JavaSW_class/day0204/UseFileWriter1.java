package day0204;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * ���ڿ� �����͸� ������ ���Ϸ� ���.
 * @author user
 */
public class UseFileWriter1 {

	public void writeData() throws IOException {
		String msg="������ ��ſ� �ݿ��� �Դϴ�.";
		
		File file=new File("e:/dev/temp/write_data.txt");
		//������ �����ϸ� ConfirmDialog�� ��� ������ ����� "��" �� ������ ��쿡�� 
		//���� ����. ������ �������� ������ ������ �����Ѵ�. 
		//�Ʒ��� �ڵ带 �����ϱ����� flag���� ���
		boolean createFlag = false;
		if(file.exists()) {
			switch(JOptionPane.showConfirmDialog(null, file.getAbsolutePath()+"�� �����մϴ�. ����ðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				createFlag = true;
			}//end switch
		}else {
			createFlag = true;			
		}
		
		if(createFlag) {
			FileWriter fw=null;
			try {
				//1.��Ʈ�� ����.
				fw=new FileWriter(file);//��Ʈ�� �����Ǹ� ������ ���� ����.
				//2. ��Ʈ���� �����͸� ���.
				fw.write(msg);
				//3. ��Ʈ���� ��ϵ� �����͸� �������� ����.
				fw.flush();
				
				System.out.println("���Ϸ� �����͸� ����Ͽ����ϴ�.");
			}finally {
				//4. ��Ʈ���� ���´�. ( �޸� ���� ���� )
				if( fw != null ) { fw.close(); }//end if
			}//end finally
			
		}//end if
		
	}//writeData
	
	public static void main(String[] args) {
		UseFileWriter1 ufw=new UseFileWriter1();
		try {
			ufw.writeData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
