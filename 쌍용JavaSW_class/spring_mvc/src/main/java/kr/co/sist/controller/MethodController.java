package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//굳이  method=RequestMethod.GET 쓰지 않아도됨 ==> method= GET  단축
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//annotation이 설정되어있어야 HandlerMapper가 class를 찾을수 있다(component-scan)
//<context:component-scan base-package="kr.co.sist" /> --> servlet-context.xml
@Controller
public class MethodController {

	@RequestMapping(value="/get.do", method= GET )
	public String getMethod() {
		return "get_result";
	}
	@RequestMapping(value="/post.do", method= POST)
	public String postMethod() {
		return "post_result";
	}
	@RequestMapping(value="/multi.do", method= {POST, GET})
	public String multiMethod() {
		System.out.println("multi.do 요청");
		return "multi_request";
	}
	
	@RequestMapping(value="/sub_result.do", method= {GET, POST})
	public String resultMethod() {
		return "day0510/sub_result";
	}
	
	/**
	 * 다양한 요청 URL을 하나의 method로 처리
	 * @return
	 */
	@RequestMapping(value={"/a.do", "/b.do", "/c.do"}, method= {GET, POST})
	public String multiRequest() {
		return "multi_result";
	}
	
	@RequestMapping(value="void_return.do", method= {GET, POST})
	public void voidReturn() {
		System.out.println("void_return.do");
	}
	
}
