package day0420;

import java.io.File;

import kr.co.sist.util.img.ImageResize;

/**
 * sist.util.jar 제공하는 이미지크기를 변경하여 생성하는 일의 클래스를 사용
 * 
 * @author user
 *
 */
public class UseImgResize {
	
	
	
	
	public static void main(String[] args) {
		//1. 변경할 이미지 파일에 접근
		File file=new File("E:/dev/workspace/jsp_prj/src/main/webapp/common/imgs/daum_logo.png");
		
		if(file.exists()) {
			ImageResize.resizeImage(file.getAbsolutePath(), 400, 200);
			System.out.println("이미지 생성");
		}
		
	}//main

}
