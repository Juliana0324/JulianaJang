package day0420;

import java.io.File;

import kr.co.sist.util.img.ImageResize;

/**
 * sist.util.jar �����ϴ� �̹���ũ�⸦ �����Ͽ� �����ϴ� ���� Ŭ������ ���
 * 
 * @author user
 *
 */
public class UseImgResize {
	
	
	
	
	public static void main(String[] args) {
		//1. ������ �̹��� ���Ͽ� ����
		File file=new File("E:/dev/workspace/jsp_prj/src/main/webapp/common/imgs/daum_logo.png");
		
		if(file.exists()) {
			ImageResize.resizeImage(file.getAbsolutePath(), 400, 200);
			System.out.println("�̹��� ����");
		}
		
	}//main

}
