package day0204;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 문자열 데이터를 목적지 파일로 기록.
 * @author user
 */
public class UseFileWriter1 {

	public void writeData() throws IOException {
		String msg="오늘은 즐거운 금요일 입니다.";
		
		File file=new File("e:/dev/temp/write_data.txt");
		//파일이 존재하면 ConfirmDialog로 덮어쓸 것이지 물어보고 "예" 가 눌리는 경우에만 
		//덮어 쓴다. 파일이 존재하지 않으면 파일을 생성한다. 
		//아래의 코드를 제어하기위한 flag변수 사용
		boolean createFlag = false;
		if(file.exists()) {
			switch(JOptionPane.showConfirmDialog(null, file.getAbsolutePath()+"이 존재합니다. 덮어쓰시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				createFlag = true;
			}//end switch
		}else {
			createFlag = true;			
		}
		
		if(createFlag) {
			FileWriter fw=null;
			try {
				//1.스트림 연결.
				fw=new FileWriter(file);//스트림 생성되면 파일을 덮어 쓴다.
				//2. 스트림에 데이터를 기록.
				fw.write(msg);
				//3. 스트림에 기록된 데이터를 목적지로 분출.
				fw.flush();
				
				System.out.println("파일로 데이터를 기록하였습니다.");
			}finally {
				//4. 스트림을 끊는다. ( 메모리 누수 방지 )
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
