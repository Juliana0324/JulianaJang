package chap01.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.web.model.DataVO;

@WebServlet("/Data.do")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<DataVO> list=new ArrayList<>();
    public DataServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("/DataList.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		String name= request.getParameter("name");
		String tel= request.getParameter("tel");
		String add= request.getParameter("add");
		DataVO data=new DataVO();
		data.setName(name);
		data.setTel(tel);
		data.setAdd(add); 
		list.add(data);
		response.sendRedirect("/DataSuccess.jsp");
	
		
		
	}

}
