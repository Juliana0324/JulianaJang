package lab.web.model;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmpDAO dao;
	public EmpServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		dao=new EmpDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url= "";
		if("list".equals(action)) {
			request.setAttribute("list", dao.selectEmployeeList());	
			url="/EmpList.jsp";
		}else if("view".equals(action)) {
			int empId= Integer.parseInt(request.getParameter("empId"));
			request.setAttribute("emp", dao.selectEmployee(empId));
			url="/EmpView.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
