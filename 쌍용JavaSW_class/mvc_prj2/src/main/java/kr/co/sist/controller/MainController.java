package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.action.InfoAction;
import kr.co.sist.action.LoginAction;
import kr.co.sist.action.LoginProcessAction;
import kr.co.sist.action.MainAction;


@SuppressWarnings("serial")
public class MainController extends HttpServlet {
   //요청 URL을 가지고 Action클래스를 찾아서 실행할 때 사용하기 위한 Map
   private static Map<String, Action> map;
   
   //static 영역 : class가 실행되면 호출하지 않더라도 자동 호출되는 영역
   //별도의 호출작업이 필요없다.
   static {
      //영역 : method안의 코드작성
      map = new HashMap<String, Action>();
      //키(cmd)는 요청했을 때 입력받아 Action을 찾아서 실행 (커맨드패턴)
      map.put("M001", new MainAction());
      map.put("I001", new InfoAction());
      map.put("L001", new LoginAction()); //로그인 폼
      map.put("L002", new LoginProcessAction()); //로그인 처리
   }//static


   
   //최초 요청이나 get방식의 요청이 있다면 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //doPost로 가서 처리
      doPost(request,response);   
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      //Action을 찾아서 실행하기 위한 cmd를 받는다.
      String cmd = request.getParameter("cmd");
      if (cmd == null) { //최초 호출되었을 때
         cmd = "M001";
      }
      
      //Map에서 cmd에 해당하는 Action을 얻는다.
      Action action = map.get(cmd);
      
      //에러방지
      if(action ==null) {
    	  action=map.get("M001");
      }
      System.out.println("==cmd is ="+ cmd );
      action.execute(request, response); // 파라미터 처리
      String url = action.moveURL(); // 보여줄 페이지명 얻기
      boolean moveFlag = action.forwardFlag(); // view페이지로 이동 방식
      //설정정보를 입력하여 페이지 이동
      movePage(request,response,url,moveFlag);
      
   }
   
   /**
    * 페이지이동
    * @param request
    * @param response
    * @param moveURL
    * @param fowardFlag
    * @throws ServletException
    * @throws IOException
    */
   private void movePage(HttpServletRequest request, HttpServletResponse response, String moveURL, boolean forwardFlag) throws ServletException, IOException {
      if (forwardFlag) {
         RequestDispatcher rd = request.getRequestDispatcher(moveURL);
         rd.forward(request, response);
      } else {
         response.sendRedirect(moveURL);
      }
   }

}