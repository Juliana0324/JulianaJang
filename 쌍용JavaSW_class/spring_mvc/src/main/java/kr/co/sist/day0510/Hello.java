package kr.co.sist.day0510;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {
	
	//uri ==> http://localhost/sist/hello
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public String hello() {
		
		//이동 페이지 명
		return "hello_spring";
	}
	
	
}
