package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.service.LoginService;
import kr.co.sist.vo.LoginVO;

public class LoginProcessAction implements Action {
	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pw= request.getParameter("passwd");
		
		LoginVO lVO=new LoginVO(id, pw);
		
		//로그인 서비스
		LoginService ls= new LoginService();
		String name = ls.loginProcess(lVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("sessionName", name);
		session.setAttribute("sessionId", id);
		
		url="login/login_result.jsp";
		
		forwardFlag = true;
		
	}

	@Override
	public String moveURL() {
		// TODO Auto-generated method stub
		return url;
	}

	@Override
	public boolean forwardFlag() {
		// TODO Auto-generated method stub
		return forwardFlag;
	}

}
