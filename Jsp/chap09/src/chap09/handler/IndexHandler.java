package chap09.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap09.controller.CommandHandler;
import chap09.service.IndexService;

public class IndexHandler implements CommandHandler{
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setAttribute("ulist", IndexService.getAllUser());

		//controller : ������� ��û�� ���� 
		//handler ��Ű�� : ��û�� ������ � ����Ͻ� ������ �����ѵ� ��� �������� ���� �ᤸ��
		// service ��Ű��: ��û���� ������ �����ؾ��ϴ� ����Ͻ� ��¡(conn)
		//dao ��Ű��: DB�� CRUD����� �����ϴ� ��ü>(pstmt, rs)
		//dto ��Ű��: �����͸� ���ϰ� �����ϱ� ���� ��ü()
		
		
		return "/WEB-INF/view/index.jsp";

}
}
