package day0428;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//1. HTTPservlet���
public class FormParameter extends HttpServlet {
	
	//2.��û��� ó���� �� �ִ� method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. ���� ��ļ���=> mine type����
		response.setContentType("text/html;charset=UTF-8");
		
		//4. ��½�Ʈ�� ���
		PrintWriter out=response.getWriter();
		
		//��� ���� ������
		out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<!-- ���� CSS -->\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.130/jsp_prj/common/css/main_20220321.css\">\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("\r\n");
	      out.write("</style>\r\n");
	      out.write("<!-- jQuery CDN -->\r\n");
	      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
	      out.write("<!-- bootstrap CDN -->\r\n");
	      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
	      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
	      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>\r\n");
	      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>\r\n");
	      out.write("\r\n");
	      out.write("<script type=\"text/javascript\">\r\n");
	      out.write("$(function(){\r\n");
	      out.write("	$(\"#btn\").click(function(){\r\n");
	      out.write("		//var param=\"name=\"+$(\"#name\").val()+\"&bYear=\"+$(\"#bYear\").val();\r\n");
	      out.write("		$.ajax({\r\n");
	      out.write("			url:\"param_ajax.jsp\",\r\n");
	      out.write("			//data: param,\r\n");
	      out.write("			data:{ name:$(\"#name\").val(), bYear:$(\"#bYear\").val()  },\r\n");
	      out.write("			async:true,\r\n");
	      out.write("			dataType:\"json\",\r\n");
	      out.write("			error : function( xhr ){\r\n");
	      out.write("				$(\"#output\").html(\"��� �� �ٽ� �õ����ּ���.<br/>\"+xhr.status);\r\n");
	      out.write("				for(var i= 0; i < 5 ; i++){\r\n");
	      out.write("					$(\"#output\").fadeOut(1000).fadeIn(1000);\r\n");
	      out.write("				}//end for\r\n");
	      out.write("			},\r\n");
	      out.write("			success:function( jsonObj ){\r\n");
	      out.write("				var output=\"\";\r\n");
	      out.write("				output+=\"<strong>\"+ jsonObj.name+\"</strong>\";\r\n");
	      out.write("				output+=\"<strong>\"+ jsonObj.year+\"</strong>\";\r\n");
	      out.write("				output+=\"<marquee scrollamount='50'>\"+ jsonObj.age+\"</marquee>\";\r\n");
	      out.write("					$(\"#output\").html( output );\r\n");
	      out.write("			}\r\n");
	      out.write("		});\r\n");
	      out.write("	});//click\r\n");
	      out.write("});//ready\r\n");
	      out.write("</script>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("\r\n");
	      out.write("<div>\r\n");
	      //HTML Form Control �Է°� �ޱ�
	      //http://localhost/servlet_prj/form_param.do?text=asd&password=asd&hid=%EC%88%A8%EA%B9%80%EA%B0%92&date=2022-04-08&file=%EA%B4%80%EB%A6%AC%EC%9E%90.PNG&ta=adasd&gender=%EC%97%AC%EC%9E%90&domain=none&age=
	      //�̸��� ������ ���: request.getParameter
	      String text=request.getParameter("text");
	      String password=request.getParameter("password");
	      String hid=request.getParameter("hid");
	      String date=request.getParameter("date");
	      String file=request.getParameter("file");
	      String gender= request.getParameter("gender");
	      String domain= request.getParameter("domain");
	      String flag= request.getParameter("flag");
	      String age= request.getParameter("age");
	      
	      //�̸��� �ߺ�: request.getParameterValues
	      String[] loc= request.getParameterValues("loc");
	      
	      out.println("<h2>GET Method</h2>");
	      out.println("<ul>");
	      out.println("<li>text: <strong>"+text+"</strong></li>");
	      out.println("<li>password:<strong>"+password+"</strong></li>");
	      out.println("<li>hid: <strong>"+hid+"</strong></li>");
	      out.println("<li>date: <strong>"+date+"</strong></li>");
	      out.println("<li>file: <strong>"+file+"</strong></li>");
	      out.println("<li>gender: <strong>"+gender+"</strong></li>");
	      out.println("<li>select: <strong>"+domain+"</strong></li>");
	      out.println("<li>flag: <strong>"+flag+"</strong></li>");
	      out.println("<li>age: <strong>"+age+"</strong></li>");
	      
	      //checkBox�� �������� ������ parameter�� ����� �����ʴ´�. null�� ����
	      if(loc!=null) {
		      for(String location: loc) {
		    	  out.println("<li>location(checkBox): <strong>"+location+"</strong></li>");
		      }
	      }else {
	    	  out.println("<li>������ ��������</li>");
	      }
	      out.println("</ul>");
	      out.println("<a href='javascript:history.back()'>�ٽ��Է�</a>");
	      
	      out.write("</div>\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//2. ��û��� ó���� �� �ִ� method Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3. ���� ��ļ���=> mine type����
				response.setContentType("text/html;charset=UTF-8");
				
				//4. ��½�Ʈ�� ���
				PrintWriter out=response.getWriter();
				
				//��� ���� ������
				out.write("<!DOCTYPE html>\r\n");
			      out.write("<html>\r\n");
			      out.write("<head>\r\n");
			      out.write("<meta charset=\"UTF-8\">\r\n");
			      out.write("<title>Insert title here</title>\r\n");
			      out.write("<!-- ���� CSS -->\r\n");
			      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://211.63.89.130/jsp_prj/common/css/main_20220321.css\">\r\n");
			      out.write("<style type=\"text/css\">\r\n");
			      out.write("\r\n");
			      out.write("</style>\r\n");
			      out.write("<!-- jQuery CDN -->\r\n");
			      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
			      out.write("<!-- bootstrap CDN -->\r\n");
			      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
			      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
			      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>\r\n");
			      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>\r\n");
			      out.write("\r\n");
			      out.write("<script type=\"text/javascript\">\r\n");
			      out.write("$(function(){\r\n");
			      out.write("	$(\"#btn\").click(function(){\r\n");
			      out.write("		//var param=\"name=\"+$(\"#name\").val()+\"&bYear=\"+$(\"#bYear\").val();\r\n");
			      out.write("		$.ajax({\r\n");
			      out.write("			url:\"param_ajax.jsp\",\r\n");
			      out.write("			//data: param,\r\n");
			      out.write("			data:{ name:$(\"#name\").val(), bYear:$(\"#bYear\").val()  },\r\n");
			      out.write("			async:true,\r\n");
			      out.write("			dataType:\"json\",\r\n");
			      out.write("			error : function( xhr ){\r\n");
			      out.write("				$(\"#output\").html(\"��� �� �ٽ� �õ����ּ���.<br/>\"+xhr.status);\r\n");
			      out.write("				for(var i= 0; i < 5 ; i++){\r\n");
			      out.write("					$(\"#output\").fadeOut(1000).fadeIn(1000);\r\n");
			      out.write("				}//end for\r\n");
			      out.write("			},\r\n");
			      out.write("			success:function( jsonObj ){\r\n");
			      out.write("				var output=\"\";\r\n");
			      out.write("				output+=\"<strong>\"+ jsonObj.name+\"</strong>\";\r\n");
			      out.write("				output+=\"<strong>\"+ jsonObj.year+\"</strong>\";\r\n");
			      out.write("				output+=\"<marquee scrollamount='50'>\"+ jsonObj.age+\"</marquee>\";\r\n");
			      out.write("					$(\"#output\").html( output );\r\n");
			      out.write("			}\r\n");
			      out.write("		});\r\n");
			      out.write("	});//click\r\n");
			      out.write("});//ready\r\n");
			      out.write("</script>\r\n");
			      out.write("</head>\r\n");
			      out.write("<body>\r\n");
			      out.write("\r\n");
			      out.write("<div>\r\n");
			      //POST����� ���ڵ� ����
			      request.setCharacterEncoding("UTF-8");

			      //HTML Form Control �Է°� �ޱ�
			      //http://localhost/servlet_prj/form_param.do?text=asd&password=asd&hid=%EC%88%A8%EA%B9%80%EA%B0%92&date=2022-04-08&file=%EA%B4%80%EB%A6%AC%EC%9E%90.PNG&ta=adasd&gender=%EC%97%AC%EC%9E%90&domain=none&age=
			      //�̸��� ������ ���: request.getParameter
			      
			      String text=request.getParameter("text");
			      String password=request.getParameter("password");
			      String hid=request.getParameter("hid");
			      String date=request.getParameter("date");
			      String file=request.getParameter("file");
			      String gender= request.getParameter("gender");
			      String domain= request.getParameter("domain");
			      String flag= request.getParameter("flag");
			      String age= request.getParameter("age");
			      
			      //�̸��� �ߺ�: request.getParameterValues
			      String[] loc= request.getParameterValues("loc");
			      out.println("<h2>POST Method</h2>");
			      out.println("<ul>");
			      out.println("<li>text: <strong>"+text+"</strong></li>");
			      out.println("<li>password:<strong>"+password+"</strong></li>");
			      out.println("<li>hid: <strong>"+hid+"</strong></li>");
			      out.println("<li>date: <strong>"+date+"</strong></li>");
			      out.println("<li>file: <strong>"+file+"</strong></li>");
			      out.println("<li>gender: <strong>"+gender+"</strong></li>");
			      out.println("<li>select: <strong>"+domain+"</strong></li>");
			      out.println("<li>flag: <strong>"+flag+"</strong></li>");
			      out.println("<li>age: <strong>"+age+"</strong></li>");
			      
			      //checkBox�� �������� ������ parameter�� ����� �����ʴ´�. null�� ����
			      if(loc!=null) {
				      for(String location: loc) {
				    	  out.println("<li>location(checkBox): <strong>"+location+"</strong></li>");
				      }
			      }else {
			    	  out.println("<li>������ ��������</li>");
			      }
			      out.println("</ul>");
			      out.println("<a href='javascript:history.back()'>�ٽ��Է�</a>");
			      
			      out.write("</div>\r\n");
			      out.write("</body>\r\n");
			      out.write("</html>");
	}

}
