package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController {

	
	@RequestMapping(value="/day0516/use_exception.do", method=GET)
	public String useMethod() throws Exception {
		//Service를 사용했을때 예외가 발생하는 가정
		if(new Random().nextBoolean()) {
			throw new Exception("service에서 발생한 예외지");
		}
		return "day0516/success";
	}

	//SQLException을 throws라는 예외를 처리하는 ExceptionHandler를 작성.
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlException(SQLException se) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("err/sql_err");
		mav.addObject("errMsg", se.getMessage());
		
		
		return mav;
		
	}
	
	@ExceptionHandler(Exception.class)
	//반환형이 ModelAndView, 매개변수는 ExceptionHandler에 정의된 예외처리 객체
	public ModelAndView exceptionHandler(Exception exception, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		exception.printStackTrace();
		
		Enumeration<String> en= request.getHeaderNames();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
	 // 예외가 발새했을떄 제공할 view페이지명
		mav.setViewName("err/err500");
		mav.addObject("err_msg", exception.getMessage());
		mav.addObject("err_user-agent", request.getHeader("user-agent"));
		mav.addObject("err_referer", request.getHeader("referer"));
		
		
		return mav;
	}
	
}
