package lab.web.filter;

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
@WebFilter({"/hr/*","/Emp.do"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    public void destroy() {
	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq=(HttpServletRequest)request;
		HttpServletResponse hres=(HttpServletResponse)response;
		HttpSession session = hreq.getSession();
		if(session.getAttribute("userId")==null) {
			hres.sendRedirect("/JDBC/Login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	}
