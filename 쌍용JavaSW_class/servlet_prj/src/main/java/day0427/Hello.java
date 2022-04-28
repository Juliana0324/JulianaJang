package day0427;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@SuppressWarnings("serial")
//1. HttpServlet상송
public class Hello extends HttpServlet {

	//2. 요청방식을 처리할 수 있는 method Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. 접속자에게 제공할 응답방식 설정
		response.setContentType("text/html;charset=UTF-8");
		
		//4. 출력 스트림 얻기
		PrintWriter out=response.getWriter();
		
		//5. 접속자에게 재공할 내용생성.
		out.println("<!DOCTYPE>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>안녕 서블릿</title>");
		out.println("</head>");
		out.println("<body>");
		
		String name="테스트";
		out.println("<strong>");
		out.println(name);
		out.println("</strong>님 안냐세여");

		out.println("</body>");
		out.println("</html>");
	}

}
