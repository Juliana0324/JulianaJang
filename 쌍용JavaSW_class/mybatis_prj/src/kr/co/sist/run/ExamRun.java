package kr.co.sist.run;

import kr.co.sist.service.ExamService;
import kr.co.sist.vo.MyTabVO;

public class ExamRun {

	public static void main(String[] args) {

		ExamService es=new ExamService();
		
		MyTabVO mtVO= new MyTabVO();
		mtVO.setId("kim2");//pk
		mtVO.setName("±è¿¹Áø");
		mtVO.setAge(21);
		mtVO.setEmail("kim1@test.com");//unique
				
//		System.out.println( es.addMyTab(mtVO) );
//		System.out.println( es.modifyMyTab(mtVO) );
		System.out.println( es.removeMyTab("kim2") );
		
	}//main

}//class
