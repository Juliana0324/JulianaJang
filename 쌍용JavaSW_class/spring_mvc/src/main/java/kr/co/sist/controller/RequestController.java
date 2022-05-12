package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

//����  method=RequestMethod.GET ���� �ʾƵ��� ==> method= GET  ����
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
@Controller
public class RequestController {

	@RequestMapping(value="/request_info.do", method=GET)
	public String reqInfo(HttpServletRequest request) {
		String ip=request.getRemoteAddr();
		System.out.println("������ IP"+ip);
		System.out.println("��û URL: "+request.getRequestURL()); //��û URLhttp://localhost/spring_mvc/request_info.do
		System.out.println("��û URI: "+request.getRequestURI()); //��û URI/spring_mvc/request_info.do
		
		Enumeration<String> en = request.getHeaderNames();
		String headerNames="";
		while(en.hasMoreElements()) {
			headerNames=en.nextElement();
			System.out.println(headerNames+" : "+request.getHeader(headerNames));
		}
		
		
		if("211.63.89.133".equals(ip)) {
			System.out.println("���� ����");
		}
		
		return "day0511/req_info";
	}
	
	/**
	 * HTTPServletRequest�� ����� WebParameteró��
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/use_request.do", method=GET)
	public String useRequest(HttpServletRequest request){
		String name= request.getParameter("name");
		String age = request.getParameter("age");
		String[] lang = request.getParameterValues("lang");
		
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
		
		if(lang!=null) {
			for(String list: lang) {
				System.out.println("���� ����: "+list);
			}
		}
		
		request.setAttribute("msg", "use_request.do���� ȣ��!");
		return "day0511/use_request";
	}
	
	
	/**
	 * ���������� ���Ķ���� �ޱ�<br/>
	 * �� �Ķ���͸�� method �Ķ���͸��� �����ؾ���
	 * 
	 * @param name
	 * @param age
	 * @param lang
	 * @return
	 */
	@RequestMapping(value="/single_param.do", method=GET)
//	public String singleParam(String name, String age, String[] lang, Model model){
	public String singleParam(String name, @RequestParam(defaultValue = "0") int age, String[] lang, Model model){
		//webParameter�� ���ڿ��θ� ���޵����� �Ű������� ���������� �⺻������ �����ϸ� 
		//spring Framework���� �� ��ȯ�� �����Ͽ� �Է����ش�
		model.addAttribute("msg", "single_param.do");
		System.out.println("������ ������ ������ �Ű����� ó��");
		System.out.println(name);
		System.out.println(age+" / "+(2022-age+1));
		if(lang!=null) {
			for(String list: lang) {
				System.out.println("���� ����: "+list);
			}
		}
		
		return "day0511/use_request";
	}
	
	
	@RequestMapping(value="/vo_param.do",method={GET,POST})
	public String paramVO(ParamVO pVO, Model model){
		//@RequestParam(defaultValue = "0") ==> VO�κп� setAge�� �־��

		model.addAttribute("msg", "/vo_param.do");
		try {
			pVO.setName(URLEncoder.encode(pVO.getName(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(pVO); //day0511/use_request
		return "day0511/use_request";
	}	


}
