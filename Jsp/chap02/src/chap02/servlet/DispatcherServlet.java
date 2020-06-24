package chap02.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.handler.*;

public class DispatcherServlet<CommandHandler> extends HttpServlet {
	//ctrl+shift+o
	private Map<String, CommandHandler> cmdMap=new HashMap<>(); 
	
	//���ο� URL�� ���涧���� web.xml�� ����ϱ� �Ⱦ ���� ����
	
	@Override
	public void init() throws ServletException {
		//init() ==>servlet�� ó�� �����ɶ� ������� ȣ��Ǵ� �Լ�
		System.out.println("init() ȣ���");
		cmdMap.put("/join",new JoinHandler());
		cmdMap.put("/login",new LoginHandler());
		
}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get,Post ��� �����ϴ� �Լ�
		//��û�� ������ ������� ������ ȣ��Ǵ� �޼���
		//doGet,doPost,doPut.... ������ ���������� ó���� �� �ִ� �޼ҵ�
		
		System.out.println("service() ȣ���");
		
		String cmd=req.getRequestURI().replace("/chap02/mvc/","/");
		System.out.println("����ڰ� ���� �������� "+cmd);
		
		//cmd��  join�̸� joinó��
		//cmd��  login �̸� loginó��
		//cmd�� ...�̸� ...ó��
		//���⼭ /mvc/*�� ��� ó���� ������ ���� ������ 
		//�ҽ��ڵ带 �����ϴ� ���� ���� ���� ���鿡�� ����
		
		String viewPage=null;
		try {
			cmdMap.get(cmd).process(req,resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(viewPage==null) {
			req.getRequestDispatcher("/WEB-INF/error/404.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher(viewPage).forward(req, resp);
		}
		System.out.println("�� ������ Context���: "+req.getContextPath());
		System.out.println("����ڰ� ��û�� ���: "+req.getRequestURI());
		System.out.println("����ڰ� ��û�� ���: "+req.getMethod());
		System.out.println("����ڰ� ��û�� Query: "+req.getQueryString());
		System.out.println("������� IP�ּ�:"+req.getRemoteAddr());
		System.out.println("��û�� header: "+req.getHeaderNames());
		System.out.println("��û�� �Ķ���͵�: "+req.getParameterNames());
		System.out.println("��û�� �Ǹ� ��Ʈ����Ʈ��: "+req.getAttributeNames());
		
		//getParameter(name),getAttribute(name),getHeader(name)
		
		
		//���� service����
		//- ��û�� method�� Ȯ���ϰ� �˸��� do�޼��带 ȣ�����ִ� ����
		//- ex:Get�ڽ� ��û�̶�� doGetȣ��
		super.service(req, resp);
	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()ȣ���");
	}

}
