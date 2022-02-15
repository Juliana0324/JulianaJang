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
 * 파일 클래스 쓰기
 * @author user
 *
 */
public class UseFile {
	
	public UseFile() {
		File file = new File("E:/dev/temp/java_read.txt");
		
		System.out.println(file.exists());
		System.out.println(file.length()+"byte");
		System.out.println(file.isDirectory()?"디렉토리": "파일");
		System.out.println(file.canRead()? "읽기 가능": "읽기 불가능");
		System.out.println(file.canWrite()? "쓰기 가능": "쓰기 불가능");
		System.out.println(file.canExecute()? "실행 가능": "실행 불가능");
		System.out.println(file.isHidden()? "숨겨진 파일": "숨겨진 파일");
		long lm = file.lastModified();
		Date d = new Date(lm);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("마지막으로 수정된 날짜: "+sm.format(d));
		
		System.out.println("파일경로 : " +file.getPath());
		System.out.println("파일 절대경로: "+file.getAbsolutePath());
		try {
			System.out.println("파일 규볌경로: "+file.getCanonicalPath());
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		System.out.println("파일을 가진 폴더명: "+file.getParent());
		System.out.println("파일명: "+file.getName());
		
		//파일 이름변경
//		File rename= new File(file.getParent()+"/java_read_1.txt");
//		System.out.println(file.renameTo(rename));
		
		//파일 삭제
//		System.out.println(file.delete());
		
		//디렉터리 생성
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
