package day0429;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddCookie extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      // 1. ��Ű ����
      Cookie name = new Cookie("cookieName", "�׽�Ʈ�̸�");
      Cookie age = new Cookie("cookieAge", "20");
      // 2. �����ð� ����
      name.setMaxAge(60*2);
      age.setMaxAge(60*2);
      // 3. �ɱ�
      response.addCookie(name);
      response.addCookie(age);
      
      // ��Ű�б� ���� �����̷�Ʈ������� �̵�
      response.sendRedirect("http://localhost/servlet_prj/read_cookie");
   }

}