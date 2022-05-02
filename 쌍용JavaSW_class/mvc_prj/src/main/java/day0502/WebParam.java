package day0502;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * 일반 클래스로 web Parameter처리
 * @author user
 *
 */
public class WebParam {
	
	public void method(HttpServletRequest request)throws ServletException{
	
		System.out.println("일반 클래스로 받기: "+request.getParameter("name"));

	}//method
}
