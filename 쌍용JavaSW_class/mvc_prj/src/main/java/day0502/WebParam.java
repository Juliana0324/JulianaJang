package day0502;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * �Ϲ� Ŭ������ web Parameteró��
 * @author user
 *
 */
public class WebParam {
	
	public void method(HttpServletRequest request)throws ServletException{
	
		System.out.println("�Ϲ� Ŭ������ �ޱ�: "+request.getParameter("name"));

	}//method
}
