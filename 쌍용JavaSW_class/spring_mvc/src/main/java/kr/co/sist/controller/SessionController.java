package kr.co.sist.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.service.DataService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Session사용
 * @author user
 *
 */
@Controller
@SessionAttributes({"sesName","sesAge"})
public class SessionController {
	
	@RequestMapping(value="/day0512/session.do", method=GET)
	public String sessionDo(HttpSession session) {
		System.out.println(session);
		//값 설정
		session.setAttribute("name", "장정우");
		DataService ds=new DataService();
		
		session.setAttribute("data", ds.searchData());
		
		return "day0512/use_session";
	}

	
	@RequestMapping(value="/day0513/set_session.do", method=GET)
	public String setSessionValue(Model model) {
		//model에 @sessionAttribute와 같은 이름으로 값 설정
		model.addAttribute("sesName", "정인선");
		model.addAttribute("sesAge", 20);
		
		return "day0513/set_session";
	}
	

	/**
	 * 세샨에 설정된 값
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/day0513/get_session.do", method=GET)
	public String getSessionValue(HttpSession session) {
		String sesName = (String)session.getAttribute("sesName");
		String url="day0513/get_session";
		
		if(sesName==null) {
			url="redirect:http://localhost/spring_mvc/index.html";
		}else{
			System.out.println(sesName);
			System.out.println(session.getAttribute("sesAge"));
		}
		
		return url;
	}

	
	/**
	 * 값 삭제
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/day0513/remove_session.do", method=GET)
	public String removeSession(SessionStatus status) {
		/*
		 * 불가능!
	public String removeSession(HttpSession session) {
		 session.removeAttribute("sesName"); 
		 session.removeAttribute("sesAge");
		 session.invalidate();
		System.out.println("이름: "+session.getAttribute("sesName"));
		System.out.println("나이: "+session.getAttribute("sesAge"));
		 */
		//세션만 삭제
		System.out.println("삭제전: "+status.isComplete());
		status.setComplete();
		System.out.println("세션삭제");
		System.out.println("삭제후: "+status.isComplete());

		return "day0513/remove_session";
	}

	//쿠키
	@RequestMapping(value="/day0513/add_cookie.do", method=GET)
	public String addCookie(HttpServletResponse response) {
		
		Cookie cookieName = new Cookie("name", "테스트");
		Cookie cookieAddr = new Cookie("addr", "서울시");
		
		//생존시간 설정(1hour)
		cookieName.setMaxAge(60*60*1);
		cookieAddr.setMaxAge(60*60*1);
		
		response.addCookie(cookieName);
		response.addCookie(cookieAddr);
		
		return "day0513/add_cookie";
	}
	
	@RequestMapping("/day0513/get_cookie.do")
	public String getCookieValue(@CookieValue(value="name", defaultValue="이름없음") String name, @CookieValue(value="addr", defaultValue="주소없음")  String addr) {
		System.out.println("name값: "+name);
		System.out.println("addr값: "+addr);
		return "day0513/get_cookie";
	}

	/**
	 * 쿠키 삭제
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/day0513/remove_cookie.do")
	public String removeCookie(HttpServletResponse response) {
		Cookie cookieName = new Cookie("name", "테스트");
		Cookie cookieAddr = new Cookie("addr", "서울시");
		
		//생존시간 설정(같은 이름의 쿠키를 0으설정)
		cookieName.setMaxAge(0);
		cookieAddr.setMaxAge(0);
		
		response.addCookie(cookieName);
		response.addCookie(cookieAddr);
		
		return "day0513/get_cookie";
	}
}
