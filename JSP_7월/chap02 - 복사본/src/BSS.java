

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BSS")
public class BSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BSS() {
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
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>��°��</title></head>");
		out.println("<body>");
		out.printf("�̸�: %s",name);
		out.printf("���̵�: %s", id);
		out.printf("��й�ȣ: %s", pw);
		out.printf("��ȭ��ȣ: %s", tel);
		
		out.println("</body>");
		out.println("</html>");
	
	}

}
