package kr.co.sist.run;

import kr.co.sist.service.TestService;
import kr.co.sist.vo.CpEmp4VO;

/**
 *MyBatis Framework 사용
 * @author user
 */
public class UseMyBatis {

	public static void main(String[] args) {
		CpEmp4VO cp=new CpEmp4VO(7,3200,100,"황성준","개발자");
		TestService ts=new TestService();
		System.out.println(ts.addEmp(cp));
		
	}//main

}//class
