package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		DataBaseInfo dbInfo = new DataBaseInfo();
//		dbInfo.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
//		dbInfo.setUid("spring1");
//		dbInfo.setUpw("sss111");
//		
//		MemberDAO dao = new MemberDAO();
//		dao.setDbInfo(dbInfo);
//		dao.showDbInfo();
		
		GenericXmlApplicationContext ct=
				new GenericXmlApplicationContext("classpath:db-config.xml");
		MemberDAO dao = ct.getBean("dao",MemberDAO.class);
		dao.showDbInfo();
	
	}
}
