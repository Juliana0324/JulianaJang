package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiDAO {
	public List<String> getList() throws SQLException{
		List<String> list = new ArrayList<String>();
		list.add("�ȳ�");
		list.add("����");
		list.add("������");
		list.add("������");
		return list;
	};
	
	
	
}
