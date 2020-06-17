import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class JoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Get방식 요청이 왔습니다.");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//req: 클라이언트가 보낸 데이터 및 정보를 가진 객체
		String name= request.getParameter("m_name");
		String age= request.getParameter("m_age");
		String email= request.getParameter("m_email");
		
		//resp: 응답페이지를 생성한뒤 응답
		response.setCharacterEncoding("EUC-KR");
		response.getWriter().append("<html><h3>Post방식 요청이 왔습니다.</h3>")
		.append("이름: "+name+"<br>")
		.append("나이: "+age+"<br>")
		.append("이메일: "+email+"<br></html>")
		;
	}
}
