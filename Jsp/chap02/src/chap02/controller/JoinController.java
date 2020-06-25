package chap02.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.bean.Member;

public class JoinController {
	public String joinForm() {
//		LoginController controller=new LoginController();
			return "/WEB-INF/view/form/join.jsp";
		}
	//매개변수의 갯수를 줄이기 위해 Bean객체 사용
	//Bean객체는 이처럼 데이터를 주고받기 위해 사용
	//(DTO라고 부름  or VO: ValueObject ,Model)
	//Data Transfer Object
	public String register(Member mem,HttpServletRequest req) {
		System.out.println("register 까지 성공적으로 도착하였습니다.");
		String path=req.getRealPath("/member");
		System.out.println("실제 경로: "+path);File new_mem = new File(path 
		+ "\\" 		
		+ mem.getUser_id() + ".mem");
 
		//AutoClose interface가 구현된 객체를 자동으로 닫아줌
		try (FileWriter f_out=new FileWriter(new_mem,false)){
			f_out.append("이름: "+mem.getName()+"\n");
			f_out.append("아이디: "+mem.getUser_id()+"\n");
			f_out.append("비밀번호: "+mem.getUser_pwd()+"\n");
			f_out.append("생일: "+mem.getBirthday()+"\n");
			f_out.append("가입일: "+mem.getJoinDate()+"\n");
			f_out.append("마켓팅 동의: "+mem.isMarketing()+"\n");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/view/mvc/join_result.jsp";
		}
	}
