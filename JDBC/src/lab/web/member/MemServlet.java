package lab.web.member;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.web.member.MemDAO;

@WebServlet("/Member.do")
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		MemDAO dao;
	public MemServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		dao=new MemDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String url="";
		if("insert".equals(action)) {
			request.setAttribute("action", action);
			request.setAttribute("message", "ют╥б");
			url="/MemberInsert.jsp";
		}
		else if("view".equals(action)) {
			String userId= request.getParameter("userId");
			request.setAttribute("mem", dao.selectMember(userId));
			url="/MemberView.jsp";
	}
		request.getRequestDispatcher(url).forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	if("insert".equals(action)) {
		String userId=request.getParameter("userId");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		MemberVO mem=new MemberVO();
		mem.setUserId(userId);
		mem.setName(name);
		mem.setPassword(password);
		mem.setEmail(email);
		mem.setAddress(address);
		dao.insertMember(mem);
		response.sendRedirect("/JDBC/Member.do?action=list");
	}

	}

}
