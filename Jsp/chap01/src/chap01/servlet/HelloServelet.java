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
    
    //get��� ��û: �ּ�â�� ���� �ּҸ� ó�� ������ ���
    //Ŭ���̾�Ʈ�� ���� GET��� ��û�� �����ϸ� �ڵ�����  servlet�� doGet�� �����Ѵ�
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	//�Ű����� HttpServletRequest request ��ü�� ��û������ �Ƿ��´�
	//�Ű� ���� HttpServletRequest respons ��ü�� ��û������ �Ƿ��´�
	
	response.setCharacterEncoding("EUC-KR");
//	response.getWriter()
//	.append("<h1 style='color:skyblue;'>Hello Servelet!!</h1>")
//	.append("<p style='color:red;'>ó������ ������ �Դϴ�.</p>");

	//�ڹ� ������ Ȱ���Ͽ� HTML�ڵ带 �����ϴ� �����ӿ�ũ
	// - servelet �����δ� HTML�ڵ� �ۼ��ϱ� ����
	// - �ҽ��� �ſ� ��������
	
		PrintWriter out = response.getWriter();
		out.print("<h1 style='color:skyblue;'>Hello Servelet!!</h1>");
		out.print("<p style='color:red;'>ó������ ������ �Դϴ�.</p>");
		
		out.print("<ol>");
		for(int i=0; i<10;++i) {
			out.print("<li>�ݺ��Ǵ� ����"+add(i,99)+"</li>");
		}
		out.print("</ol>");
		out.print("<div id='time'>���� �ð�: "+Shortcuts.getCurrentTime("yyyy-MM-dd/hh:mm:ss")+"</div>");
		
		out.print("<style>#time{font - size: 1.5em;}</style>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
