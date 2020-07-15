package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/BBS")
public class BBS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BBS() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String date=request.getParameter("birth");
		SimpleDateFormat tool=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date birth=null;
		try{
			birth=tool.parse(date);
		}catch(ParseException e) {

		}
		int grade=Integer.parseInt(request.getParameter("grade"));
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String [] fruit =request.getParameterValues("fruit");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		String data=request.getParameter("data");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("<HTML");
		out.println("<HEAD><TITLE> �±װ�����ȭ�� </TITLE></HEAD>");
		out.println("<BODY>");
		out.printf("�г�: %s <BR>",grade);
		out.printf("�̸���: %s <BR>",email);
		out.printf("��ȭ��ȣ: %s<BR>",tel);
		out.printf("���̵� : %s <BR>", id);
		out.printf("��й�ȣ : %s <BR>", pw);
		out.print("���� :");
		for(String val : fruit ) {
			out.printf("%s ", val);
		}
		out.print("<BR>");
		out.printf("���� : %s <BR>", sex);
		out.printf("���� : %s <BR>", job);
		out.println("----------------<BR>");
		out.printf("<PRE>%s</ PRE>", data);
		out.println("----------------<BR>");
		
		out.println("����Ǿ����ϴ�");
		out.println("</BODY>");
		out.println("</HTML>");
	}


}
