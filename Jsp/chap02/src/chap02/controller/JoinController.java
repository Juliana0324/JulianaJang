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
	//�Ű������� ������ ���̱� ���� Bean��ü ���
	//Bean��ü�� ��ó�� �����͸� �ְ�ޱ� ���� ���
	//(DTO��� �θ�  or VO: ValueObject ,Model)
	//Data Transfer Object
	public String register(Member mem,HttpServletRequest req) {
		System.out.println("register ���� ���������� �����Ͽ����ϴ�.");
		String path=req.getRealPath("/member");
		System.out.println("���� ���: "+path);File new_mem = new File(path 
		+ "\\" 		
		+ mem.getUser_id() + ".mem");
 
		//AutoClose interface�� ������ ��ü�� �ڵ����� �ݾ���
		try (FileWriter f_out=new FileWriter(new_mem,false)){
			f_out.append("�̸�: "+mem.getName()+"\n");
			f_out.append("���̵�: "+mem.getUser_id()+"\n");
			f_out.append("��й�ȣ: "+mem.getUser_pwd()+"\n");
			f_out.append("����: "+mem.getBirthday()+"\n");
			f_out.append("������: "+mem.getJoinDate()+"\n");
			f_out.append("������ ����: "+mem.isMarketing()+"\n");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/view/mvc/join_result.jsp";
		}
	}
