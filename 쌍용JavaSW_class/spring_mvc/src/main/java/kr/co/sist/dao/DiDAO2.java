package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DiDAO2 {
	public List<String> getList() throws SQLException{
		List<String> list = new ArrayList<String>();
		list.add("�ȳ�1");
		list.add("����1");
		list.add("������1");
		list.add("������1");
		return list;
	};
	
	
	
}
