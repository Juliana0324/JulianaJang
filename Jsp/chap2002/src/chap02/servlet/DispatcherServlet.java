package chap02.servlet;

import java.util.*;

import javax.jws.soap.InitParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import chap02.handler.*;


public class DispatcherServlet extends HttpServlet{
	private Map<String, CommandHandler> cmdMap=new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() »£√‚µ ");
		cmdMap.put("/join", new JoinHandler());
		cmdMap.put("/login", new LoginHandler());
	}
}
