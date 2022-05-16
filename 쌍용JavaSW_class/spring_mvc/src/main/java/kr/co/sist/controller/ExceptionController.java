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
		//Service�� ��������� ���ܰ� �߻��ϴ� ����
		if(new Random().nextBoolean()) {
			throw new Exception("service���� �߻��� ������");
		}
		return "day0516/success";
	}

	//SQLException�� throws��� ���ܸ� ó���ϴ� ExceptionHandler�� �ۼ�.
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlException(SQLException se) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("err/sql_err");
		mav.addObject("errMsg", se.getMessage());
		
		
		return mav;
		
	}
	
	@ExceptionHandler(Exception.class)
	//��ȯ���� ModelAndView, �Ű������� ExceptionHandler�� ���ǵ� ����ó�� ��ü
	public ModelAndView exceptionHandler(Exception exception, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		exception.printStackTrace();
		
		Enumeration<String> en= request.getHeaderNames();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
	 // ���ܰ� �߻������� ������ view��������
		mav.setViewName("err/err500");
		mav.addObject("err_msg", exception.getMessage());
		mav.addObject("err_user-agent", request.getHeader("user-agent"));
		mav.addObject("err_referer", request.getHeader("referer"));
		
		
		return mav;
	}
	
}
