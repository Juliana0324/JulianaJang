package study.spring.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import study.spring.myapp.model.UserVO;

@Controller("resCon")
@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	
	/*
	@GetMapping("/test")
	public void test(@RequestParam("age")int age, Model model) {
		model.addAttribute("nick","뽀삐");
		model.addAttribute("age", age);
	}*/
	
	//2.@ModelAttribute를 사용한 화면에 데이터전송처리
	
	@GetMapping("/test")
	public void test(@ModelAttribute("age")int age, Model model) {
		model.addAttribute("nick", "뽀삐");
	}
	
	//3.ModelandView사용
	//뷰에 출력되어야할 데이터를 저장할 수 있고, 뷰 객체를 이용하여 컨트롤러의 실행 결과가 보일 뷰를 지정
	
	@GetMapping("/test2")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName", "박영희");
//		mv.setViewName("/response/test2");
//		return mv;
		
		return new ModelAndView("/response/test2", "userName","김철수");
		
	}
	
	@GetMapping("/res-ex02")
	public void res02() {
		System.out.println("/res-ex02.jsp로 get으로 넘어감");
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user")UserVO user) {
		return "response/test3";
	}
	
	/////////////////////////////////////////////////////
	//퀴즈
	
	@GetMapping("/res-quiz")
	public void resQuiz() {
		System.out.println("/res-quiz.jsp로 get으로 넘어감");
	}
	/*
	@PostMapping("/res-login")
	public String login(@ModelAttribute("user")UserVO user) {
		if(user.getUserId().equals("kim123")&&user.getUserPw().equals("kkk1234")) {
			return "response/res-quiz-success";
		}
		else {
			return "response/res-quiz-fail";			
		}
	}*/
	
	
	//커멘드 객체와 model사용한 방식
	/*@PostMapping("/res-login")
	public String resLogin(UserVO vo, Model model) {
		String id=vo.getUserId();
		String pw=vo.getUserPw();
		
		model.addAttribute("userId", id);//아이디를 모델에 추가
		if(id.equals("kim123")&&pw.equals("kkk1234")) {
			return "response/res-quiz-success";
			}
		else {
				return "response/res-quiz-fail";			
			}
			
	}
	*/
	
	//ModelAttribute사용 방식
	@PostMapping("/res-login")
	public String resLogin(@ModelAttribute("userId") String id
			,@RequestParam("userPw") String pw) {
		
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}
	
	
	//Redirect처리
	//로그인 화면 요청처리
	@GetMapping("/login")
	public String login() {
		System.out.println("/login: GET요청 발셍!");
		return "response/res-redirect-form";
	}
	
	//로그인 검증 처리
	@PostMapping("/login")
	public String login(@ModelAttribute("userId")String id
			,@RequestParam("userPw")String pw
			,@RequestParam("userPwChk")String pwChk
			,RedirectAttributes ra) {
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg","아이디는 필수값이에요!");
			//redirect:context값을 가지고 getMapping login으로 이동
			return "redirect:/response/login";
		}
		else if(!pw.equals(pwChk)) {
			ra.addFlashAttribute("msg","비밀번호 확인란을 체크하세요!");
			return "redirect:/response/login";
		} 
		else if(id.equals("abc123") && pw.equals("1234")) {
			return "response/res-quiz-success";
		} else {		
			return null;
		}
	}
	
}
