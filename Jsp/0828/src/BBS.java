

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBS")
public class BBS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BBS() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String [] fruit =request.getParameterValues("fruit");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		String data=request.getParameter("data");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>테그결과출력</TITLE></HEAD>");
		out.println("<BODY>");
		out.printf("아이디: %s <BR>", id);
		out.printf("비밀번호: %s <BR>", pwd);
		out.println("과일: ");
		for(String val:fruit) {
			out.printf(" %s", val);
		}
		out.print("<BR>");
		out.printf("성별: %s <BR>", sex);
		out.printf("직업: %s <BR>", job);
		out.println("--------------------<BR>");
		out.printf("<PRE>%s</PRE>", data);
		out.println("--------------------<BR>");
		out.println("저장되었습니다.");
		out.println("</BODY></HTML>");
	
	}

}
