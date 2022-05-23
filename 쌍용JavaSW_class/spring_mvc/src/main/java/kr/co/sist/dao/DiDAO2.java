package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DiDAO2 {
	public List<String> getList() throws SQLException{
		List<String> list = new ArrayList<String>();
		list.add("안녕1");
		list.add("오늘1");
		list.add("수요일1");
		list.add("포항항1");
		return list;
	};
	
	
	
}
