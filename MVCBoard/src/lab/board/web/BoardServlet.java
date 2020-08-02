package lab.board.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.web.domain.BoardVO;
import lab.web.domain.MemberVO;

@WebServlet("/Board.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		BoardDAO dao;
		MemberDAO mdao;
		
    public BoardServlet() {
        super();

    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init();
    	dao =new BoardDAO();
    	mdao=new MemberDAO();
    }
    
    public void destroy() {
    	dao=null;
    	mdao=null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = new MemberVO();
		String action = request.getParameter("action");
		String url="";
		if("write".equals(action)) {
			request.setAttribute("message", "새 글 입력");
			url=url+"/board/write.jsp";
			request.setAttribute("action", "write_do");
		}else if("list".equals(action)) {
			String pageStr=request.getParameter("page");
			int page=1;
			if(pageStr !=null){
				page=Integer.parseInt(pageStr);
			}
			Collection<BoardVO> lists = dao.selectArticleList(page);
			request.setAttribute("lists", lists);
			url=url+"/board/list.jsp";
		
			int bbsCount = dao.selectTotalBbsCount();
			double totalPage =0;
			if(bbsCount>0) {
				totalPage=bbsCount/10.0;
			}if((totalPage%1 != 0)) {
				totalPage= totalPage+1;
			}
			request.setAttribute("totalPageCount", (int)totalPage);
			request.setAttribute("page", page);
		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request,response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
