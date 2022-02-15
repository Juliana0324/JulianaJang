package day0204;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 문자열 데이터를 목적지 파일로 보내기
 * @author user
 *
 */
public class UseFileWriter {
	private FileWriter fw = null;
	private String msg = "오늘은 즐거운 금요일 입니다.";
	private File file = new File("e:/dev/temp/write_data.txt");
	
	public void writeData() throws IOException {
		
		
		//파일이 존재하면 confirmDialog로 예가 눌리면 
		if(file.exists()) {
			int ask = JOptionPane.showConfirmDialog(null, file+"을 저장하시겠습니까?");
			switch(ask) {
			case JOptionPane.OK_OPTION:
				//1. 스트림영결
				try {
//					fw =new FileWriter(file); //스트림 생성되면 파일을 덮어쓴다.
//					//2. 스트림의 데이터를 기록
//					fw.write(msg);
//					//3. 스트림에 기록된 데이터를 목적지로 분출
//					fw.flush();
//					System.out.println("파일로 데이터를 기록");
					write();
				}finally {
					//4. 메모리 누수방지
					if(fw!=null) {fw.close();}
				}//end try catch
				
			}//end switch
		}
		else {
			write();
		}
		
		
	}//write
	
	public void write() throws IOException {
		fw =new FileWriter(file); //스트림 생성되면 파일을 덮어쓴다.
		//2. 스트림의 데이터를 기록
		fw.write(msg);
		
		//3. 스트림에 기록된 데이터를 목적지로 분출
		fw.flush();
		System.out.println("파일로 데이터를 기록");
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
