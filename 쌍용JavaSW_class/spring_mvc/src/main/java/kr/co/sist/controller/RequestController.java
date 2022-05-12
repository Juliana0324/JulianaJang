package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

//굳이  method=RequestMethod.GET 쓰지 않아도됨 ==> method= GET  단축
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
		System.out.println("접속자 IP"+ip);
		System.out.println("요청 URL: "+request.getRequestURL()); //요청 URLhttp://localhost/spring_mvc/request_info.do
		System.out.println("요청 URI: "+request.getRequestURI()); //요청 URI/spring_mvc/request_info.do
		
		Enumeration<String> en = request.getHeaderNames();
		String headerNames="";
		while(en.hasMoreElements()) {
			headerNames=en.nextElement();
			System.out.println(headerNames+" : "+request.getHeader(headerNames));
		}
		
		
		if("211.63.89.133".equals(ip)) {
			System.out.println("강산 접속");
		}
		
		return "day0511/req_info";
	}
	
	/**
	 * HTTPServletRequest를 사용한 WebParameter처리
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/use_request.do", method=GET)
	public String useRequest(HttpServletRequest request){
		String name= request.getParameter("name");
		String age = request.getParameter("age");
		String[] lang = request.getParameterValues("lang");
		
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		
		if(lang!=null) {
			for(String list: lang) {
				System.out.println("선택 과목: "+list);
			}
		}
		
		request.setAttribute("msg", "use_request.do에서 호출!");
		return "day0511/use_request";
	}
	
	
	/**
	 * 단일형으로 웹파라미터 받기<br/>
	 * 웹 파라미터명과 method 파라미터명이 동일해야함
	 * 
	 * @param name
	 * @param age
	 * @param lang
	 * @return
	 */
	@RequestMapping(value="/single_param.do", method=GET)
//	public String singleParam(String name, String age, String[] lang, Model model){
	public String singleParam(String name, @RequestParam(defaultValue = "0") int age, String[] lang, Model model){
		//webParameter는 문자열로만 전달되지만 매개변수의 데이터형을 기본형으로 선언하면 
		//spring Framework에서 형 변환을 수행하여 입력해준다
		model.addAttribute("msg", "single_param.do");
		System.out.println("단일형 데이터 형으로 매개변수 처리");
		System.out.println(name);
		System.out.println(age+" / "+(2022-age+1));
		if(lang!=null) {
			for(String list: lang) {
				System.out.println("선택 과목: "+list);
			}
		}
		
		return "day0511/use_request";
	}
	
	
	@RequestMapping(value="/vo_param.do",method={GET,POST})
	public String paramVO(ParamVO pVO, Model model){
		//@RequestParam(defaultValue = "0") ==> VO부분에 setAge에 넣어둠

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
