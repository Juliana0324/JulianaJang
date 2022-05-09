package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.LoginService;

public class LoginAction implements Action {
	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 폼으로 이동
		url="login/login_form.jsp";
		
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
