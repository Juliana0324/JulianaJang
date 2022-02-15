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
				fis = new FileInputStream(file); //파일에 스트림을 사용하여 연결하고
				
				//연결된 파일에서 최초 1byte만 읽어들임
//				int data = fis.read(); //연결된 스트림에서 1byte씩가져온다
//				System.out.println("읽어들인 데이터: "+(char)data );
				
				//연결된 파일에서 모든 데이터를 1byte씩 읽어드린다
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
			System.out.println(file.getAbsolutePath() + "이 존재하지 않습니다.");
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
