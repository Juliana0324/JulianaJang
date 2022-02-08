package day0208;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class UseObjectStream {
	

	public void writeObject() throws IOException{
		MyData md = new MyData("김현우", 182.5, 70.2); //직렬화 대상객체
		
		//객체를 파일에 출력할 수 있는 파일 생성
		ObjectOutputStream oos = null;
		
		try{
			//1. 스트림생성
			oos = new ObjectOutputStream(new FileOutputStream(new File("E:/dev/temp/writeObj.dat")));
			//2. 객체쓰고,
			oos.writeObject(md);
			//3. 스트림의 내용을 분출
			oos.flush();
			JOptionPane.showMessageDialog(null, "객체를 스트림에 기록하였음");
		}finally {
			if(oos!=null) {
				oos.close();
			}
		}
		
		
	}//readObject
	
	public void readObject() throws IOException, ClassNotFoundException {
		//System.out.println("객체 읽기");
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File("E:/dev/temp/writeObj.dat")));
			
			//2. 객체읽기
			MyData md = (MyData) ois.readObject();
			
			///읽어들인 객체 사용
			StringBuilder readData = new StringBuilder();
			readData.append("이름: ").append(md.getName()).append("\n");
			readData.append("키: ").append(md.getHeight()).append("\n");
			readData.append("몸무게: ").append(md.getWeight()).append("\n");
			JOptionPane.showMessageDialog(null, readData.toString());
			
		}finally {
			if(ois !=null) {
				ois.close();
			}
		}
		
		
	}//readObject

	public static void main(String[] args) {
		UseObjectStream uos = new UseObjectStream();
		String inputMenu ="";
		boolean exitFlag = false;
		do {
			inputMenu = JOptionPane.showInputDialog("1. 객체 쓰기 || 2. 객체 읽기 || 3. 종료");

			switch(inputMenu) {
			case "1":
				try {
					uos.writeObject();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "객체를 쓸수 없습니다.");
				}
				break;
			case "2":
				try {
					uos.readObject();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "객체를 읽을 수 없습니다.");
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "읽어들인 파일에 객체가 존재하지 않음");
				}
				break;
			
			case "3":
				exitFlag = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "메뉴는 1,2,3번중 하나만 입력하세요");
			}
			
		} while (!exitFlag);
	}

}
