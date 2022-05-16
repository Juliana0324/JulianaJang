package day0516.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DB DAO
 * 약결합이 되기 위해서 DAO인터페이스 구현
 * @author user
 *
 */
public class MySqlDAO implements DAO{

	@Override
	public void insert(String name) throws SQLException {
		System.out.println("INSERT INTO MySql_TAB(name) values('"+name+"')");
		
	}

	@Override
	public List<String> select() throws SQLException {
		List<String> list = new ArrayList<String>();
		
		list.add("MySql DBMS의 SELECT입니다. ");
		list.add("김예진");
		list.add("박설진");
		list.add("서지숙");
		list.add("김진영");

		return list;
	}
	
	
}
