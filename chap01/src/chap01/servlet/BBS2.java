package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBS2")
public class BBS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BBS2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String tel=request.getParameter("tel");
		String gender=request.getParameter("gender");
		String [] email=request.getParameterValues("email");
		String date=request.getParameter("birth");
		SimpleDateFormat tool=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date birth=null;
		try{
			birth=tool.parse(date);
		}catch(ParseException e) {

		}
		String job=request.getParameter("job");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out= response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>출력결과</TITLE></HEAD>");
		out.println("<BODY>");
		out.printf("이름: %s <BR>", name);
		out.printf("아이디: %s <BR>", id);
		out.printf("비밀번호: %s <BR>", pw);
		out.printf("연락처: %s <BR>", tel);
		out.printf("성별: %s <BR>", gender);
		out.print("메일 수신여부:");
		for(String val:email) {
			out.printf("%s ", val);
		}
		out.print("<BR>");
		out.printf("날짜: %s <BR>", birth);
		out.printf("직업: %s<BR>", job);
		out.println("----------------<BR>");
		
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
