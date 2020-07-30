package lab.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		MemDAO dao;
    public LoginServlet() {
        super();
        dao=new MemDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect("/JDBC/Login.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String dbpw=dao.getPassword(userId);
		if(password.equals(dbpw)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("/JDBC/EmpMain.jsp");
		}else {
			request.setAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다.");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	
	}

}
