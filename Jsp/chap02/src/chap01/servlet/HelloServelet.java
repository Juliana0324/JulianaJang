package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap01.util.Shortcuts;

@WebServlet("/hi")
public class HelloServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloServelet() {
        super();
       
    }
    private int add(int A,int B) {
    	return A+B;
    }
    
    //get방식 요청: 주소창에 직접 주소를 처서 들어오는 방식
    //클라이언트로 부터 GET방식 요청이 도착하면 자동으로  servlet의 doGet을 실행한다
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	//매개변수 HttpServletRequest request 객체에 요청정보가 실려온다
	//매개 변수 HttpServletRequest respons 객체에 요청정보가 실려온다
	
	response.setCharacterEncoding("EUC-KR");
//	response.getWriter()
//	.append("<h1 style='color:skyblue;'>Hello Servelet!!</h1>")
//	.append("<p style='color:red;'>처음만든 페이지 입니다.</p>");

	//자바 문법을 활용하여 HTML코드를 생성하는 프레임워크
	// - servelet 만으로는 HTML코드 작성하기 불편
	// - 소스가 매우 지저분함
	
		PrintWriter out = response.getWriter();
		out.print("<h1 style='color:skyblue;'>Hello Servelet!!</h1>");
		out.print("<p style='color:red;'>처음만든 페이지 입니다.</p>");
		
		out.print("<ol>");
		for(int i=0; i<10;++i) {
			out.print("<li>반복되는 내용"+add(i,99)+"</li>");
		}
		out.print("</ol>");
		out.print("<div id='time'>현재 시간: "+Shortcuts.getCurrentTime("yyyy-MM-dd/hh:mm:ss")+"</div>");
		
		out.print("<style>#time{font - size: 1.5em;}</style>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
