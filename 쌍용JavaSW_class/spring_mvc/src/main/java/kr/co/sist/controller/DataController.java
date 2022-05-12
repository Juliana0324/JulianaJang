package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.service.DataService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controller���� ó���� �����͸� JSP�� ������ ���� ��ü ���.
 * @author user
 */
@Controller
public class DataController {
//	<a href="day0512/use_request.do">
	@RequestMapping(value="/day0512/use_request.do",method = GET)
	public String useRequest(HttpServletRequest request) {
		//���������� ó���ϴ� Ŭ������ ���.
		DataService ds=new DataService();
		List<String> list=ds.searchData();
		//ó���� ����� JSP�� �����ϱ����� Scope��ü ���.
		request.setAttribute("data", list);
		request.setAttribute("date", 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date() ));
		
		return "day0512/use_request";
	}//useRequest
	
	@RequestMapping(value="/day0512/use_model.do",method = GET)
	public String useModel(Model model) {
		
		//��������ó��
		DataService ds=new DataService();
		
		//����ó������� Model�� ����
		model.addAttribute("search_data", ds.searchData());
		model.addAttribute("search_date", 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date() ));
		model.addAttribute("user_name", "������");
		return "day0512/use_model";
	}//useModel
	
	@RequestMapping(value="/day0512/use_model_and_view.do",method = GET)
	public ModelAndView useModelAndView() {
		
		//��������ó��
		DataService ds=new DataService();
		//����ó������� ModelAndView�� ����
		ModelAndView mav=new ModelAndView();
		mav.addObject("search_data", ds.searchData());
		mav.addObject("search_date", 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date() ));
		mav.addObject("user_name", "������");
		
		//view���������� ����.
		mav.setViewName("day0512/use_model_and_view");
		
		return mav;
	}//useModel
	

}//class
