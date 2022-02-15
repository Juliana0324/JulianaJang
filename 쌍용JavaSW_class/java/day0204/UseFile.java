package day0204;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���� Ŭ���� ����
 * @author user
 *
 */
public class UseFile {
	
	public UseFile() {
		File file = new File("E:/dev/temp/java_read.txt");
		
		System.out.println(file.exists());
		System.out.println(file.length()+"byte");
		System.out.println(file.isDirectory()?"���丮": "����");
		System.out.println(file.canRead()? "�б� ����": "�б� �Ұ���");
		System.out.println(file.canWrite()? "���� ����": "���� �Ұ���");
		System.out.println(file.canExecute()? "���� ����": "���� �Ұ���");
		System.out.println(file.isHidden()? "������ ����": "������ ����");
		long lm = file.lastModified();
		Date d = new Date(lm);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("���������� ������ ��¥: "+sm.format(d));
		
		System.out.println("���ϰ�� : " +file.getPath());
		System.out.println("���� ������: "+file.getAbsolutePath());
		try {
			System.out.println("���� �ԓٰ��: "+file.getCanonicalPath());
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		System.out.println("������ ���� ������: "+file.getParent());
		System.out.println("���ϸ�: "+file.getName());
		
		//���� �̸�����
//		File rename= new File(file.getParent()+"/java_read_1.txt");
//		System.out.println(file.renameTo(rename));
		
		//���� ����
//		System.out.println(file.delete());
		
		//���͸� ����
		File mk = new File("E:/dev_1/temp/test");
		System.out.println(mk.mkdir());
//		FileReader fr = new FileReader(file);
//		int ch;
//		while((ch=fr.read())!=-1) {
//			System.out.print((char)ch);
//		}
	}
	
	public static void main(String[] args){
		UseFile uf = new UseFile();
	}

}
