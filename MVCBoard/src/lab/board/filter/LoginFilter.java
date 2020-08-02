package lab.board.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter({"/Board.do","/board/*"})
public class LoginFilter implements Filter {
    public LoginFilter() {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session= req.getSession();
		HttpServletResponse res=(HttpServletResponse)response;
		String userid =(String)session.getAttribute("userid");
		if(userid==null) {
			if(req.getParameter("action").equals("contact_do")) {
				
			}else {
				res.sendRedirect("/MVC/login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
