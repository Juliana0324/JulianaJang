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
 * Session���
 * @author user
 *
 */
@Controller
@SessionAttributes({"sesName","sesAge"})
public class SessionController {
	
	@RequestMapping(value="/day0512/session.do", method=GET)
	public String sessionDo(HttpSession session) {
		System.out.println(session);
		//�� ����
		session.setAttribute("name", "������");
		DataService ds=new DataService();
		
		session.setAttribute("data", ds.searchData());
		
		return "day0512/use_session";
	}

	
	@RequestMapping(value="/day0513/set_session.do", method=GET)
	public String setSessionValue(Model model) {
		//model�� @sessionAttribute�� ���� �̸����� �� ����
		model.addAttribute("sesName", "���μ�");
		model.addAttribute("sesAge", 20);
		
		return "day0513/set_session";
	}
	

	/**
	 * ������ ������ ��
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
	 * �� ����
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/day0513/remove_session.do", method=GET)
	public String removeSession(SessionStatus status) {
		/*
		 * �Ұ���!
	public String removeSession(HttpSession session) {
		 session.removeAttribute("sesName"); 
		 session.removeAttribute("sesAge");
		 session.invalidate();
		System.out.println("�̸�: "+session.getAttribute("sesName"));
		System.out.println("����: "+session.getAttribute("sesAge"));
		 */
		//���Ǹ� ����
		System.out.println("������: "+status.isComplete());
		status.setComplete();
		System.out.println("���ǻ���");
		System.out.println("������: "+status.isComplete());

		return "day0513/remove_session";
	}

	//��Ű
	@RequestMapping(value="/day0513/add_cookie.do", method=GET)
	public String addCookie(HttpServletResponse response) {
		
		Cookie cookieName = new Cookie("name", "�׽�Ʈ");
		Cookie cookieAddr = new Cookie("addr", "�����");
		
		//�����ð� ����(1hour)
		cookieName.setMaxAge(60*60*1);
		cookieAddr.setMaxAge(60*60*1);
		
		response.addCookie(cookieName);
		response.addCookie(cookieAddr);
		
		return "day0513/add_cookie";
	}
	
	@RequestMapping("/day0513/get_cookie.do")
	public String getCookieValue(@CookieValue(value="name", defaultValue="�̸�����") String name, @CookieValue(value="addr", defaultValue="�ּҾ���")  String addr) {
		System.out.println("name��: "+name);
		System.out.println("addr��: "+addr);
		return "day0513/get_cookie";
	}

	/**
	 * ��Ű ����
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/day0513/remove_cookie.do")
	public String removeCookie(HttpServletResponse response) {
		Cookie cookieName = new Cookie("name", "�׽�Ʈ");
		Cookie cookieAddr = new Cookie("addr", "�����");
		
		//�����ð� ����(���� �̸��� ��Ű�� 0������)
		cookieName.setMaxAge(0);
		cookieAddr.setMaxAge(0);
		
		response.addCookie(cookieName);
		response.addCookie(cookieAddr);
		
		return "day0513/get_cookie";
	}
}
